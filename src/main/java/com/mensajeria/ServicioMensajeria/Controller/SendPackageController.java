package com.mensajeria.ServicioMensajeria.Controller;

import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTO;
import com.mensajeria.ServicioMensajeria.Dto.SendPackageDTOGet;
import com.mensajeria.ServicioMensajeria.Model.Customer;
import com.mensajeria.ServicioMensajeria.Model.SendPackage;
import com.mensajeria.ServicioMensajeria.Service.MessagingServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mensajeria/v1/")
public class SendPackageController {

    private MessagingServiceImple messagingServiceImple;

    @Autowired
    public SendPackageController(MessagingServiceImple messagingServiceImple) {
        this.messagingServiceImple = messagingServiceImple;
    }

    @PostMapping("mensajeria")
    public ResponseEntity<String> createMessage(@RequestBody SendPackageDTO sendPackageDTO){
        ResponseEntity<String> sendPackageCreateDto = this.messagingServiceImple.RegisterSendPackage(sendPackageDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(sendPackageCreateDto.getBody());
    }


    @GetMapping("mensajeria")
    public List<SendPackage> sendPackageDTOList(){

        return this.messagingServiceImple.getSendPackageAll();
    }


    @GetMapping("mensajeria/{numeroGuia}")
    public SendPackageDTOGet sendPackageDTO(@PathVariable  Integer numeroGuia){
        return this.messagingServiceImple.getSendPackageById(numeroGuia);
    }


    @PutMapping("mensajeria")
    public SendPackageDTO sendPackageUpdateState(@RequestBody  SendPackageDTO  sendPackageDTO){

        return this.messagingServiceImple.updateSendPackageStatus(sendPackageDTO);
    }



}
