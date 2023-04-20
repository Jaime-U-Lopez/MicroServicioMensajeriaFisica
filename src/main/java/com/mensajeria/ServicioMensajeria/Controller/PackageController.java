package com.mensajeria.ServicioMensajeria.Controller;


import com.mensajeria.ServicioMensajeria.Model.Employee;
import com.mensajeria.ServicioMensajeria.Model.Packages;
import com.mensajeria.ServicioMensajeria.Service.PackageServiceImple;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mensajeria/v1/")
@Api(tags = "Package", description = "Operation for Package  management")
public class PackageController {

    private PackageServiceImple packageServiceImple;
    @Autowired
    public PackageController(PackageServiceImple packageServiceImple) {
        this.packageServiceImple = packageServiceImple;
    }


    @ApiResponses(value = {
            @ApiResponse(description = "400 - Bad Request", responseCode = "400"),
            @ApiResponse(description = "200 - Request successful", responseCode = "200"),
            @ApiResponse(description = "401 - Unauthorized", responseCode = "401"),
            @ApiResponse(description = "403 - Access Denied", responseCode = "403"),
            @ApiResponse(description = "404 - Not Found", responseCode = "404"),
            @ApiResponse(description = "500 - Internal error, please validate the entered fields", responseCode = "500")
    })
   // @PreAuthorize("isAuthenticated()")
    @ApiOperation(value = "Create one Package ",notes = "En este endpoind podras crear un paquete" )
    @PostMapping("packages")
    public ResponseEntity<Packages> create(@RequestBody Packages packages) {
        Packages PackagesCreate = this.packageServiceImple.create(packages);
        return ResponseEntity.status(HttpStatus.CREATED).body(PackagesCreate);

    }

    @ApiResponses(value = {
            @ApiResponse(description = "400 - Bad Request", responseCode = "400"),
            @ApiResponse(description = "200 - Request successful", responseCode = "200"),
            @ApiResponse(description = "401 - Unauthorized", responseCode = "401"),
            @ApiResponse(description = "403 - Access Denied", responseCode = "403"),
            @ApiResponse(description = "404 - Not Found", responseCode = "404"),
            @ApiResponse(description = "500 - Internal error, please validate the entered fields", responseCode = "500")
    })
    @ApiOperation(value = "Consult all Package",notes = "En este endpoind podras consultar todos los  paquete de la base de datos" )
    @GetMapping("packages")
    public List<Packages> getEmployeeAll() {
        return this.packageServiceImple.getPackagesAll();
    }

    @ApiResponses(value = {
            @ApiResponse(description = "400 - Bad Request", responseCode = "400"),
            @ApiResponse(description = "200 - Request successful", responseCode = "200"),
            @ApiResponse(description = "401 - Unauthorized", responseCode = "401"),
            @ApiResponse(description = "403 - Access Denied", responseCode = "403"),
            @ApiResponse(description = "404 - Not Found", responseCode = "404"),
            @ApiResponse(description = "500 - Internal error, please validate the entered fields", responseCode = "500")
    })
    @ApiOperation(value = "Package id to consult",notes = "En este endpoind podras consultar un paquete por ID" )
    @GetMapping("packages/{id}")
    public Packages getPackage(@PathVariable @ApiParam(value = "ID SendPackage ", example = "123") Integer id) {
        return this.packageServiceImple.getPackages(id);
    }


    @ApiResponses(value = {
            @ApiResponse(description = "400 - Bad Request", responseCode = "400"),
            @ApiResponse(description = "200 - Request successful", responseCode = "200"),
            @ApiResponse(description = "401 - Unauthorized", responseCode = "401"),
            @ApiResponse(description = "403 - Access Denied", responseCode = "403"),
            @ApiResponse(description = "404 - Not Found", responseCode = "404"),
            @ApiResponse(description = "500 - Internal error, please validate the entered fields", responseCode = "500")
    })
   // @PreAuthorize("isAuthenticated()")
    @ApiOperation(value = "Update one Package",notes = "En este endpoind podras realizar la actualización  de un paquete" )
    @PutMapping("packages")
    public ResponseEntity<Packages> updatePackage(@RequestBody @ApiParam(value = "SendPackage ", example = "123") Packages packages) {
        Packages empleado = this.packageServiceImple.updatePackages(packages);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(empleado);
    }
    @ApiResponses(value = {
            @ApiResponse(description = "400 - Bad Request", responseCode = "400"),
            @ApiResponse(description = "200 - Request successful", responseCode = "200"),
            @ApiResponse(description = "401 - Unauthorized", responseCode = "401"),
            @ApiResponse(description = "403 - Access Denied", responseCode = "403"),
            @ApiResponse(description = "404 - Not Found", responseCode = "404"),
            @ApiResponse(description = "500 - Internal error, please validate the entered fields", responseCode = "500")
    })
  //  @PreAuthorize("isAuthenticated()")
    @ApiOperation(value = "Packages id to delete ",notes = "En este endpoind podras realizar la eliminación de un Paquete  por ID" )
    @DeleteMapping("packages/{id}")
    public ResponseEntity<String> delete(@PathVariable @ApiParam(value = "ID SendPackage ", example = "123") Integer id) {
        Boolean deleted = this.packageServiceImple.delete(id);
        if (deleted) {
            String messaje = "El package con numero  " + id + " fue eliminado con exito!";
            return ResponseEntity.ok(messaje);
        } else {
            String messaje = "El package con numero  " + id + " no fue eliminado, valide el numero de guia ingresado no si exista en la base de datos";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messaje);
        }
    }

}
