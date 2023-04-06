package com.mensajeria.ServicioMensajeria.Service;

import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTO;
import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTOGet;
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

    public MessagingServiceImple(SendPackageImple sendPackageImple, CustomerServiceImple customerServiceImple, AdressSendCompImple adressSendCompImple, PackageServiceImple packageServiceImple, EmployeeServiceImple employeeServiceImple) {
        this.sendPackageImple = sendPackageImple;
        this.customerServiceImple = customerServiceImple;
        this.adressSendCompImple = adressSendCompImple;
        this.packageServiceImple = packageServiceImple;
        this.employeeServiceImple = employeeServiceImple;
    }

    @Autowired



    public MessagingServiceImple() {
    }

    @Override
    public ResponseEntity<String>  RegisterSendPackage(SendPackageDTO sendPackageDTO) {
        //          || (sendPackageDTO.getValorPaquete() != 0)
        //  || (sendPackageDTO.getPesoPaquete() != 0)

        if (sendPackageDTO.getCiudadOrigen().equals(null)
                || sendPackageDTO.getCiudadDestino().equals(null)
                || sendPackageDTO.getDireccionDestino().equals(null)
                || sendPackageDTO.getNombrePersonaRecibe().equals(null)


        ) {
            throw new ExceptionSendPackage("Alguno de los campos esta vacio o null, valide nuevamente");
        }


        Integer cedula = sendPackageDTO.getCedula();
        Optional<Customer> customerOptional = Optional.of(this.customerServiceImple.getCustomer(cedula));
        if (!customerOptional.isPresent()) {
            throw new ExceptionSendPackage("The customer with identification number " +  cedula +" must be registered to\n" +
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

        Integer numeroGuia=sendPackage.getNumeroGuia();
        StateSendPackageEnum estadoEnvio1=  sendPackage.getEstadoEnvio();

        ResponseEntity<String> respuesta= ResponseEntity.ok( "Numero guia :"+  numeroGuia + " Estado Envio "+ estadoEnvio);

        return respuesta;

    }

    @Override
    public void updateSendPackageStatus(SendPackageDTO sendPackageDTO ) {

        Integer cedulaEmpleado=  sendPackageDTO.getCedula();
        Integer numeroGuia= sendPackageDTO.getNumeroGuia();
        StateSendPackageEnum estadoPackage=  sendPackageDTO.getEstadoEnvio();

        Optional<Employee> empleadoOptional = Optional.of(this.employeeServiceImple.getEmployee(cedulaEmpleado));
        Optional<SendPackage> sendPackageOptional  = Optional.of(this.sendPackageImple.getSendPackage(numeroGuia));
        sendPackageOptional.get().setEstadoEnvio(estadoPackage);
        this.sendPackageImple.update(sendPackageOptional.get());


       TypeEmployeeEnum tipoEmpleado=sendPackageDTO.getTypeEmployee();




       switch (tipoEmpleado){

           case tipoEmpleado;


           case

           case

       };

        /*
        Solo los tipos de empleados (REPARTIDOR Y COORDINADOR) podran cambiar el
        estado del paquete.
                si el estado del envio esta en RECIBIDO, solo se podra cambiar al siguiente estado
        que es EN RUTA.
        Si el estado del envio esta EN RUTA, solo se podra cambiar al estado final
        ENTREGADO
        No se puede cambiar estado entre RECIBIDO a ENTREGADO (si esto sucede se
                debera retornar un error ) ejemplo : {"mensaje" : "el cambio de estado no cumple
            con las validaciones" }

*/

    }

    @Override
    public SendPackageDTOGet getSendPackageById(Integer numeroGuia) {
        StateSendPackageEnum estadoEnvioNuevo= StateSendPackageEnum.RUTA;

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
    public List<SendPackage> getSendPackageBySender(Customer sender) {
        return null;
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
