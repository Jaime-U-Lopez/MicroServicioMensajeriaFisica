package com.mensajeria.ServicioMensajeria.Service;

import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTO;
import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTOGet;
import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTOUpdate;
import com.mensajeria.ServicioMensajeria.Exception.ExceptionSendPackage;
import com.mensajeria.ServicioMensajeria.Model.*;
import com.mensajeria.ServicioMensajeria.Repository.AdressSendCompImple;
import com.mensajeria.ServicioMensajeria.Repository.SendPackageImple;
import com.mensajeria.ServicioMensajeria.Util.CalculosPackagesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MessagingServiceImple implements MessagingService {


    private SendPackageImple sendPackageImple;
    private CustomerServiceImple customerServiceImple;
    private AdressSendCompImple adressSendCompImple;
    private PackageServiceImple packageServiceImple;
    private EmployeeServiceImple employeeServiceImple;

    @Autowired
    public MessagingServiceImple(SendPackageImple sendPackageImple, CustomerServiceImple customerServiceImple, AdressSendCompImple adressSendCompImple, PackageServiceImple packageServiceImple, EmployeeServiceImple employeeServiceImple) {
        this.sendPackageImple = sendPackageImple;
        this.customerServiceImple = customerServiceImple;
        this.adressSendCompImple = adressSendCompImple;
        this.packageServiceImple = packageServiceImple;
        this.employeeServiceImple = employeeServiceImple;
    }


    public MessagingServiceImple() {
    }

    @Override
    public ResponseEntity<String> RegisterSendPackage(SendPackageDTO sendPackageDTO) {


        if (sendPackageDTO.getCiudadOrigen().equals(null)
                || sendPackageDTO.getCiudadDestino().equals(null)
                || sendPackageDTO.getDireccionDestino().equals(null)
                || sendPackageDTO.getNombrePersonaRecibe().equals(null)
                || sendPackageDTO.getValorPaquete() == 0
                || sendPackageDTO.getPesoPaquete() == 0

        ) {
            throw new ExceptionSendPackage("Alguno de los campos esta vacio o null, valide nuevamente");
        }


        Integer cedula = sendPackageDTO.getCedula();
        Optional<Customer> customerOptional = Optional.ofNullable(this.customerServiceImple.getCustomer(cedula));
        if (!customerOptional.isPresent()) {
            throw new ExceptionSendPackage("The customer with identification number " + cedula + " must be registered to\n" +
                    "be able to send a package");
        }

        Integer peso = sendPackageDTO.getPesoPaquete();
        Integer valorPackages = sendPackageDTO.getValorPaquete();
        String tipoPaquete = CalculosPackagesUtil.tipoPaquete(peso);
        Integer valorEnvio = CalculosPackagesUtil.valorEnvio(tipoPaquete.toString());
        StateSendPackageEnum estadoEnvio = StateSendPackageEnum.RECIBIDO;

        Packages packages = new Packages(tipoPaquete, peso, valorPackages);
        this.packageServiceImple.create(packages);

        AdressSendComp adressSendComp = new AdressSendComp(sendPackageDTO.getCiudadDestino(), sendPackageDTO.getCiudadOrigen(), sendPackageDTO.getDireccionDestino());
        this.adressSendCompImple.create(adressSendComp);

        SendPackage sendPackage = new SendPackage(
                customerOptional.get(),
                packages
                , valorEnvio
                , sendPackageDTO.getCelular()
                , sendPackageDTO.getNombrePersonaRecibe()
                , estadoEnvio
                , adressSendComp);

        this.sendPackageImple.create(sendPackage);

        Integer numeroGuia = sendPackage.getNumeroGuia();
        StateSendPackageEnum estadoEnvio1 = sendPackage.getEstadoEnvio();

        ResponseEntity<String> respuesta = ResponseEntity.ok("Numero guia :" + numeroGuia + " Estado Envio " + estadoEnvio);

        return respuesta;

    }

    @Override
    public ResponseEntity<String> updateSendPackageStatus(SendPackageDTOUpdate sendPackageDTOUpdate) {
        //varibles iniciales
        Integer cedulaEmpleado = sendPackageDTOUpdate.getCedulaEmpleado();
        Integer numeroGuiaABuscar = sendPackageDTOUpdate.getNumeroGuia();
        StateSendPackageEnum estadoPackage = sendPackageDTOUpdate.getEstadoEnvio();
        // trayendo los objetos
        Optional<Employee> empleadoOptional = Optional.ofNullable(this.employeeServiceImple.getEmployee(cedulaEmpleado));
        Optional<SendPackage> sendPackageOptional = Optional.ofNullable(this.sendPackageImple.getSendPackage(numeroGuiaABuscar));

        if (!empleadoOptional.isPresent() || !sendPackageOptional.isPresent()) {
            throw new RuntimeException("El package no existe o el empleado no existe  ");
        }

        sendPackageOptional.get().setEstadoEnvio(estadoPackage);
        this.sendPackageImple.update(sendPackageOptional.get());

        //varibles iniciales para validación y logica

        TypeEmployeeEnum tipoEmpleado = sendPackageDTOUpdate.getTypeEmployee();
        TypeEmployeeEnum repartidor = TypeEmployeeEnum.REPARTIDOR;
        TypeEmployeeEnum coordinador = TypeEmployeeEnum.COORDINADOR;
        TypeEmployeeEnum contador = TypeEmployeeEnum.CONTADOR;

        if (tipoEmpleado == repartidor || tipoEmpleado == coordinador) {

            StateSendPackageEnum estadoActual = sendPackageOptional.get().getEstadoEnvio();
            StateSendPackageEnum estadoNuevo = sendPackageDTOUpdate.getEstadoEnvio();
            StateSendPackageEnum estadoRecibido = StateSendPackageEnum.RECIBIDO;
            StateSendPackageEnum estadoRuta = StateSendPackageEnum.RUTA;
            StateSendPackageEnum estadoEntregado = StateSendPackageEnum.ENTREGADO;

            if (estadoActual == estadoRecibido && estadoNuevo == estadoRuta) {
                sendPackageOptional.get().setEstadoEnvio(estadoRuta);
                this.sendPackageImple.create(sendPackageOptional.get());

            } else if (estadoActual == estadoRuta && estadoNuevo == estadoEntregado) {
                sendPackageOptional.get().setEstadoEnvio(estadoEntregado);
                this.sendPackageImple.create(sendPackageOptional.get());
            } else if (tipoEmpleado == contador) {
                throw new RuntimeException("El cargo de contador no puede realizar cambios de estado");
            } else {
                throw new ExceptionSendPackage("el cambio de estado no cumple\n" +
                        "   con las validaciones, valide que esta colcando el estado correcto y que no esta colocando un estado actual");
            }

        }


        Integer numeroGuiaActual = sendPackageOptional.get().getNumeroGuia();
        StateSendPackageEnum estadoEnvio = sendPackageOptional.get().getEstadoEnvio();
        ResponseEntity<String> respuesta = ResponseEntity.ok("Numero guia :" + numeroGuiaActual + " Estado Envio " + estadoEnvio);

        return respuesta;

    }

    @Override
    public SendPackageDTOGet getSendPackageById(Integer numeroGuia) {
        StateSendPackageEnum estadoEnvioNuevo = StateSendPackageEnum.RUTA;

        Optional<SendPackage> sendPackage = Optional.of(this.sendPackageImple.getSendPackage(numeroGuia));
        sendPackage.get().setEstadoEnvio(estadoEnvioNuevo);
        this.sendPackageImple.update(sendPackage.get());


        if (!sendPackage.isPresent()) {
            throw new RuntimeException("The SendPackage not existed in database");
        }

        SendPackageDTOGet sendPackageDTOGet = new SendPackageDTOGet();

        sendPackageDTOGet.setCedulaCliente(sendPackage.get().getCustomer().getCedula());
        sendPackageDTOGet.setNombreRemitente(sendPackage.get().getCustomer().getName());
        sendPackageDTOGet.setCiudadOrigen(sendPackage.get().getAdressSend().getCiudadOrigen());
        sendPackageDTOGet.setCiudadDestino(sendPackage.get().getAdressSend().getCiudadDestino());
        sendPackageDTOGet.setDireccionDestino(sendPackage.get().getAdressSend().getDireccion());
        sendPackageDTOGet.setNombreRecibe(sendPackage.get().getNombrePersonaRecibe());
        sendPackageDTOGet.setCelular(sendPackage.get().getCelularPersonaRecibe());
        sendPackageDTOGet.setValorDeclaradoPaquete(sendPackage.get().getPackages().getValorPaquete());
        sendPackageDTOGet.setPeso(sendPackage.get().getPackages().getPesoPaquete());
        sendPackageDTOGet.setValorEnvio(sendPackage.get().getValorEnvio());
        sendPackageDTOGet.setEstadoEnvio(sendPackage.get().getEstadoEnvio());

        return sendPackageDTOGet;

    }

    @Override
    public List<SendPackage> getSendPackageByState(StateSendPackageEnum stateSendPackageEnum, Integer cedulaEmpleado) {

        StateSendPackageEnum estadoEnvio = stateSendPackageEnum;

        Optional<Employee> employeeOptional = Optional.of(this.employeeServiceImple.getEmployee(cedulaEmpleado));
        List<SendPackage> sendPackageByStateList = this.sendPackageImple.findSendPackageByState(estadoEnvio);

        return sendPackageByStateList;

    }

    @Override
    public List<SendPackage> getSendPackageByRecipient(Customer recipient) {
        return null;
    }

    @Override
    public void notifyRecipient(SendPackage SendPackage) {

    }

    @Override
    public Boolean delete(Integer id) {
        Optional<Boolean> customer = Optional.ofNullable(this.sendPackageImple.delete(id));

        if (!customer.isPresent()) {
            throw new RuntimeException("The Employee  not existed in database");
        }

        return true;
    }

    @Override
    public List<SendPackage> getSendPackageAll() {
        return this.sendPackageImple.getSendPackagesAll();
    }
}
