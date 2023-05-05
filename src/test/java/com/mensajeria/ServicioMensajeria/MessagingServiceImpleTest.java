package com.mensajeria.ServicioMensajeria;

import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTO;
import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTOGet;
import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTOUpdate;
import com.mensajeria.ServicioMensajeria.Exception.ExceptionSendPackage;
import com.mensajeria.ServicioMensajeria.Model.*;
import com.mensajeria.ServicioMensajeria.Repository.AdressSendCompImple;
import com.mensajeria.ServicioMensajeria.Repository.SendPackageImple;
import com.mensajeria.ServicioMensajeria.Service.CustomerServiceImple;
import com.mensajeria.ServicioMensajeria.Service.EmployeeServiceImple;
import com.mensajeria.ServicioMensajeria.Service.MessagingServiceImple;
import com.mensajeria.ServicioMensajeria.Service.PackageServiceImple;

import com.mensajeria.ServicioMensajeria.Util.SendPackageMapper;
import org.junit.Rule;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.junit.rules.ExpectedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

import static org.mockito.Mockito.when;


public class MessagingServiceImpleTest {


    MessagingServiceImple messagingServiceImple;

    @Mock
    CustomerServiceImple customerServiceImpleMock;

    @Mock
    private EmployeeServiceImple employeeServiceImpleMock;
    @Mock
    private SendPackageImple sendPackageImpleMock;
    @Mock
    private AdressSendCompImple adressSendCompImpleMock;
    @Mock
    private PackageServiceImple packageServiceImpleMock;
    @Mock
    private SendPackageMapper sendPackageMapper;


    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.messagingServiceImple = new MessagingServiceImple(sendPackageMapper,  sendPackageImpleMock, customerServiceImpleMock, adressSendCompImpleMock, packageServiceImpleMock, employeeServiceImpleMock);
    }

    @Test(expected = ExceptionSendPackage.class)
    public void testRegisterSendPackage_Create_WithNullFields() throws ExceptionSendPackage {
        SendPackageDTO sendPackageDTO = new SendPackageDTO(1, "Bogotá", "Cra 1 # 2-3", "Juan Perez", "123456",1L, 0, 40);
        messagingServiceImple.RegisterSendPackage(sendPackageDTO);
    }

    @Test
    public void updateSendPackageStatus_shouldThrowRuntimeExceptionWhenSendPackageNotFound() {
        // arrange
        Integer cedulaEmpleado = 1;
        Integer numeroGuia = 123;
        StateSendPackageEnum estadoEnvio = StateSendPackageEnum.RUTA;
        TypeEmployeeEnum typeEmployee = TypeEmployeeEnum.REPARTIDOR;

        Employee employee = new Employee();
        employee.setCedula(cedulaEmpleado);
        employee.setTypeEmpleoyer(typeEmployee);

        SendPackageDTOUpdate sendPackageDTOUpdate = new SendPackageDTOUpdate();
        sendPackageDTOUpdate.setCedulaEmpleado(cedulaEmpleado);
        sendPackageDTOUpdate.setNumeroGuia(numeroGuia);
        sendPackageDTOUpdate.setEstadoEnvio(estadoEnvio);


        when(employeeServiceImpleMock.getEmployee(cedulaEmpleado)).thenReturn(employee);
        when(sendPackageImpleMock.getSendPackage(numeroGuia)).thenReturn(null);


    }


    @Test(expected = RuntimeException.class)
    public void testRegisterSendPackage_Create_SinUnCliente() throws ExceptionSendPackage {
        when(customerServiceImpleMock.getCustomer(Mockito.anyInt())).thenReturn(null);
        SendPackageDTO sendPackageDTO = new SendPackageDTO(1,"Bogotá", "Cra 1 # 2-3", "Juan Perez", "123456", 1L,10, 1);
        ResponseEntity<String> responseEntity = messagingServiceImple.RegisterSendPackage(sendPackageDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody().contains("Numero guia"));
        assertTrue(responseEntity.getBody().contains("Estado Envio"));
    }



    @Test(expected = RuntimeException.class)
    public void testUpdateSendPackageStatus_NoEmployee() {
        SendPackage sendPackage = new SendPackage();
        sendPackage.setNumeroGuia(12345);
        when(sendPackageImpleMock.getSendPackage(Mockito.anyInt())).thenReturn(sendPackage);

        when(employeeServiceImpleMock.getEmployee(Mockito.anyInt())).thenReturn(null);

        SendPackageDTOUpdate sendPackageDTOUpdate = new SendPackageDTOUpdate();
        sendPackageDTOUpdate.setNumeroGuia(12345);
        sendPackageDTOUpdate.setCedulaEmpleado(123456789);
        sendPackageDTOUpdate.setEstadoEnvio(StateSendPackageEnum.RUTA);

        messagingServiceImple.updateSendPackageStatus(sendPackageDTOUpdate);
    }



    @Test(expected = RuntimeException.class)
    public void testUpdateSendPackageStatus_whitStatusEqual() {
        SendPackage sendPackage = new SendPackage();
        sendPackage.setNumeroGuia(12345);
        sendPackage.setEstadoEnvio(StateSendPackageEnum.RUTA);
        when(sendPackageImpleMock.getSendPackage(Mockito.anyInt())).thenReturn(sendPackage);

        Employee employee = new Employee();
        employee.setCedula(123456);
        when(employeeServiceImpleMock.getEmployee(Mockito.anyInt())).thenReturn(employee);

        SendPackageDTOUpdate sendPackageDTOUpdate = new SendPackageDTOUpdate();
        sendPackageDTOUpdate.setNumeroGuia(12345);
        sendPackageDTOUpdate.setCedulaEmpleado(123456);
        sendPackageDTOUpdate.setEstadoEnvio(StateSendPackageEnum.ENTREGADO);


        ResponseEntity<String> response = messagingServiceImple.updateSendPackageStatus(sendPackageDTOUpdate);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contains("Numero guia :12345 Estado Envio RUTA"));
    }


    @Test(expected = RuntimeException.class)
    public void testUpdateSendPackageStatus_InvalidStateChange() {
        SendPackage sendPackage = new SendPackage();
        sendPackage.setNumeroGuia(12345);
        sendPackage.setEstadoEnvio(StateSendPackageEnum.ENTREGADO);
        when(sendPackageImpleMock.getSendPackage(Mockito.anyInt())).thenReturn(sendPackage);

        Employee employee = new Employee();
        employee.setCedula(123456789);
        when(employeeServiceImpleMock.getEmployee(Mockito.anyInt())).thenReturn(employee);

        SendPackageDTOUpdate sendPackageDTOUpdate = new SendPackageDTOUpdate();
        sendPackageDTOUpdate.setNumeroGuia(12345);
        sendPackageDTOUpdate.setCedulaEmpleado(123456789);
        sendPackageDTOUpdate.setEstadoEnvio(StateSendPackageEnum.RUTA);

        messagingServiceImple.updateSendPackageStatus(sendPackageDTOUpdate);
    }





}


