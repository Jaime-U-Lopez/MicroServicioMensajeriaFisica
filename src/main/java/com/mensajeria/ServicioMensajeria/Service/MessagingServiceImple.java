package com.mensajeria.ServicioMensajeria.Service;

import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTO;
import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTOGet;
import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTOGetAll;
import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTOUpdate;
import com.mensajeria.ServicioMensajeria.Exception.ExceptionSendPackage;
import com.mensajeria.ServicioMensajeria.Model.*;
import com.mensajeria.ServicioMensajeria.Repository.AdressSendCompImple;
import com.mensajeria.ServicioMensajeria.Repository.SendPackageImple;
import com.mensajeria.ServicioMensajeria.Util.SendPackageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class MessagingServiceImple implements MessagingService {


    private SendPackageImple sendPackageImple;
    private CustomerServiceImple customerServiceImple;
    private AdressSendCompImple adressSendCompImple;
    private PackageServiceImple packageServiceImple;
    private EmployeeServiceImple employeeServiceImple;
    private SendPackageMapper sendPackageMapper;


    @Autowired
    public MessagingServiceImple( SendPackageMapper sendPackageMapper, SendPackageImple sendPackageImple, CustomerServiceImple customerServiceImple, AdressSendCompImple adressSendCompImple, PackageServiceImple packageServiceImple, EmployeeServiceImple employeeServiceImple) {
        this.sendPackageImple = sendPackageImple;
        this.customerServiceImple = customerServiceImple;
        this.adressSendCompImple = adressSendCompImple;
        this.packageServiceImple = packageServiceImple;
        this.employeeServiceImple = employeeServiceImple;
        this.sendPackageMapper= sendPackageMapper;
    }


    public MessagingServiceImple() {
    }

    @Override
    public ResponseEntity<String> RegisterSendPackage(SendPackageDTO sendPackageDTO)  throws RuntimeException{

        if (sendPackageDTO.getCiudadOrigen().equals(null)
                || sendPackageDTO.getCiudadDestino().equals(null)
                || sendPackageDTO.getDireccionDestino().equals(null)
                || sendPackageDTO.getNombrePersonaRecibe().equals(null)
                || sendPackageDTO.getValorPaquete() <= 0
                || sendPackageDTO.getPesoPaquete() <= 0  || sendPackageDTO.getCelular() <= 0
        ) {
            throw new ExceptionSendPackage("Alguno de los campos esta vacio o null, valide nuevamente");
        }

        Optional<Customer> customerOptional = Optional.ofNullable(this.customerServiceImple.getCustomer(sendPackageDTO.getCedulaCliente()));


        Integer peso = sendPackageDTO.getPesoPaquete();
        Integer valorPackages = sendPackageDTO.getValorPaquete();
        TypePackageEnum tipoPaquete = Packages.tipoPaquete(peso);
        Integer valorEnvio = SendPackage.valorEnvio(tipoPaquete.toString());
        StateSendPackageEnum estadoEnvio = StateSendPackageEnum.RECIBIDO;

        Packages packages = new Packages(tipoPaquete, peso, valorPackages);
        this.packageServiceImple.create(packages);

        AdressSendComp adressSendComp = new AdressSendComp(customerOptional.get(), sendPackageDTO.getCiudadDestino(), sendPackageDTO.getCiudadOrigen(), sendPackageDTO.getDireccionDestino());
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

        ResponseEntity<String> respuesta = ResponseEntity.ok("Numero guia : " + numeroGuia +
                " /n Estado Envio :" + estadoEnvio);
        return respuesta;
    }

    @Override
    public ResponseEntity<String> updateSendPackageStatus(SendPackageDTOUpdate sendPackageDTOUpdate)  throws RuntimeException {

        Integer cedulaEmpleado = sendPackageDTOUpdate.getCedulaEmpleado();
        Integer numeroGuiaABuscar = sendPackageDTOUpdate.getNumeroGuia();
        StateSendPackageEnum estadoPackage = sendPackageDTOUpdate.getEstadoEnvio();

        Optional<Employee> empleadoOptional = Optional.ofNullable(this.employeeServiceImple.getEmployee(cedulaEmpleado));
        Optional<SendPackage> sendPackageOptional = Optional.ofNullable(this.sendPackageImple.getSendPackage(numeroGuiaABuscar));

        sendPackageOptional.get().setEstadoEnvio(estadoPackage);
        this.sendPackageImple.update(sendPackageOptional.get());


        TypeEmployeeEnum tipoEmpleado = empleadoOptional.get().getTypeEmpleoyer();
        TypeEmployeeEnum repartidor = TypeEmployeeEnum.REPARTIDOR;
        TypeEmployeeEnum coordinador = TypeEmployeeEnum.COORDINADOR;
        TypeEmployeeEnum contador = TypeEmployeeEnum.CONTADOR;

        if (tipoEmpleado.equals(repartidor)   || tipoEmpleado.equals(coordinador)  ) {

            StateSendPackageEnum estadoActual = sendPackageOptional.get().getEstadoEnvio();
            StateSendPackageEnum estadoNuevo = sendPackageDTOUpdate.getEstadoEnvio();
            StateSendPackageEnum estadoRecibido = StateSendPackageEnum.RECIBIDO;
            StateSendPackageEnum estadoRuta = StateSendPackageEnum.RUTA;
            StateSendPackageEnum estadoEntregado = StateSendPackageEnum.ENTREGADO;

            Date hora = new Date();
            hora.getTime();
            String horaEntrega =  String.valueOf(hora.getTime());

            if (estadoActual.equals(estadoRecibido)  && estadoNuevo.equals(estadoRuta) ) {
                sendPackageOptional.get().setEstadoEnvio(estadoRuta);
                this.sendPackageImple.create(sendPackageOptional.get());

            } else if (estadoActual.equals(estadoRuta)   && estadoNuevo.equals(estadoEntregado) ) {
                sendPackageOptional.get().setEstadoEnvio(estadoEntregado);
                sendPackageOptional.get().setHoraEntrega(horaEntrega);
                this.sendPackageImple.create(sendPackageOptional.get());
            } else  {
                throw new ExceptionSendPackage("El cambio de estado " + estadoNuevo + " no cumple\n" +
                        "   con las validaciones, valide que esta colocando el estado correcto,   estado actual en base datos : " +estadoActual  );

            }
        } else  {
            throw new ExceptionSendPackage("El cargo de "+ tipoEmpleado +" no puede realizar cambios de estado");
        }

        Integer numeroGuiaActual = sendPackageOptional.get().getNumeroGuia();
        StateSendPackageEnum estadoEnvio = sendPackageOptional.get().getEstadoEnvio();
        ResponseEntity<String> respuesta = ResponseEntity.ok("Numero guia :" + numeroGuiaActual + " Estado Envio " + estadoEnvio);

        return respuesta;

    }

    @Override
    public SendPackageDTOGet getSendPackageById(Integer numeroGuia)  throws RuntimeException {
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
    public Boolean delete(Integer id)  throws RuntimeException {

        Integer idDelete=id;
        Optional<Boolean> customer = Optional.ofNullable(this.sendPackageImple.delete(idDelete));

        if (!customer.isPresent()) {
            throw new RuntimeException("The Customer  not existed in database");
        }

        return true;
    }

    @Override
    public List<SendPackageDTOGetAll> getSendPackageAll()  throws RuntimeException{

        List<SendPackage> sendPackageList= this.sendPackageImple.getSendPackagesAll();

        List<SendPackageDTOGetAll> sendPackageDTOGets=  this.sendPackageMapper.entityListToDtoList(sendPackageList);
        return sendPackageDTOGets  ;

    }
}
