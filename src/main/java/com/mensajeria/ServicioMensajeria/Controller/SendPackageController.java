package com.mensajeria.ServicioMensajeria.Controller;

import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTO;
import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTOGet;
import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTOGetAll;
import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTOUpdate;
import com.mensajeria.ServicioMensajeria.Model.Customer;
import com.mensajeria.ServicioMensajeria.Model.SendPackage;
import com.mensajeria.ServicioMensajeria.Model.StateSendPackageEnum;
import com.mensajeria.ServicioMensajeria.Service.MessagingServiceImple;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mensajeria/v1/")
@Api(tags = "SendPackages", description = "Operation for SendPackage  management")
@CrossOrigin
public class SendPackageController {

    private MessagingServiceImple messagingServiceImple;

    @Autowired
    public SendPackageController(MessagingServiceImple messagingServiceImple) {
        this.messagingServiceImple = messagingServiceImple;
    }
    @ApiResponses(value = {
            @ApiResponse(description = "400 - Bad Request", responseCode = "400"),
            @ApiResponse(description = "200 - Request successful", responseCode = "200"),
            @ApiResponse(description = "401 - Unauthorized", responseCode = "401"),
            @ApiResponse(description = "403 - Access Denied", responseCode = "403"),
            @ApiResponse(description = "404 - Not Found", responseCode = "404"),
            @ApiResponse(description = "500 - Internal error, please validate the entered fields", responseCode = "500")
    })
    @PreAuthorize("isAuthenticated()")
    @ApiOperation(value = "Create one  SendPackage ",notes = "En este endpoind podras crear un paquete" )
    @PostMapping("SendPackages")
    public ResponseEntity<String> createMessage(@RequestBody SendPackageDTO sendPackageDTO){
        ResponseEntity<String> sendPackageCreateDto = this.messagingServiceImple.RegisterSendPackage(sendPackageDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(sendPackageCreateDto.getBody());
    }

    @ApiResponses(value = {
            @ApiResponse(description = "400 - Bad Request", responseCode = "400"),
            @ApiResponse(description = "200 - Request successful", responseCode = "200"),
            @ApiResponse(description = "401 - Unauthorized", responseCode = "401"),
            @ApiResponse(description = "403 - Access Denied", responseCode = "403"),
            @ApiResponse(description = "404 - Not Found", responseCode = "404"),
            @ApiResponse(description = "500 - Internal error, please validate the entered fields", responseCode = "500")
    })

    @ApiOperation(value = "Consult all sendPackage",notes = "En este endpoind podras consultar todos los envios " )
    @GetMapping("SendPackages")
    public List<SendPackageDTOGetAll> sendPackageDTOAll(){
        return this.messagingServiceImple.getSendPackageAll();
    }

    @ApiResponses(value = {
            @ApiResponse(description = "400 - Bad Request", responseCode = "400"),
            @ApiResponse(description = "200 - Request successful", responseCode = "200"),
            @ApiResponse(description = "401 - Unauthorized", responseCode = "401"),
            @ApiResponse(description = "403 - Access Denied", responseCode = "403"),
            @ApiResponse(description = "404 - Not Found", responseCode = "404"),
            @ApiResponse(description = "500 - Internal error, please validate the entered fields", responseCode = "500")
    })
    @ApiOperation(value = "Consult SendPackage for Status",notes = "En este endpoind podras consultar  por estado de envio" )
    @GetMapping("SendPackages/")
    public List<SendPackage> sendPackageByStateList(@RequestParam("estadoEnvio")StateSendPackageEnum stateSendPackageEnum,@RequestParam("cedulaEmpleado") Integer cedulaEmpleado){

        return this.messagingServiceImple.getSendPackageByState(stateSendPackageEnum, cedulaEmpleado);
    }

    @ApiResponses(value = {
            @ApiResponse(description = "400 - Bad Request", responseCode = "400"),
            @ApiResponse(description = "200 - Request successful", responseCode = "200"),
            @ApiResponse(description = "401 - Unauthorized", responseCode = "401"),
            @ApiResponse(description = "403 - Access Denied", responseCode = "403"),
            @ApiResponse(description = "404 - Not Found", responseCode = "404"),
            @ApiResponse(description = "500 - Internal error, please validate the entered fields", responseCode = "500")
    })
    @ApiOperation(value = "SendPackage  id to consult",notes = "En este endpoind podras consultar un envio por Guia de paquete y empleado " )
    @GetMapping("SendPackages/{numeroGuia}")
    public SendPackageDTOGet sendPackageDTO(@PathVariable  @ApiParam(value = "Tracking number of SendPackage ", example = "123")  Integer numeroGuia){
        return this.messagingServiceImple.getSendPackageById(numeroGuia);
    }

    @ApiResponses(value = {
            @ApiResponse(description = "400 - Bad Request", responseCode = "400"),
            @ApiResponse(description = "200 - Request successful", responseCode = "200"),
            @ApiResponse(description = "401 - Unauthorized", responseCode = "401"),
            @ApiResponse(description = "403 - Access Denied", responseCode = "403"),
            @ApiResponse(description = "404 - Not Found", responseCode = "404"),
            @ApiResponse(description = "500 - Internal error, please validate the entered fields", responseCode = "500")
    })

    @ApiOperation(value = "Update one SendPackage",notes = "En este endpoind podras consultar los paquetes por estado de envio" )
    @PutMapping("SendPackages")
    public ResponseEntity<String>  sendPackageUpdateState(@RequestBody  @ApiParam(value = "SendPackage  for status", example = "123") SendPackageDTOUpdate sendPackageDTOUpdate){

        ResponseEntity<String> sendPackageUpdate = this.messagingServiceImple.updateSendPackageStatus(sendPackageDTOUpdate);
        return ResponseEntity.status(HttpStatus.CREATED).body(sendPackageUpdate.getBody());
    }


}
