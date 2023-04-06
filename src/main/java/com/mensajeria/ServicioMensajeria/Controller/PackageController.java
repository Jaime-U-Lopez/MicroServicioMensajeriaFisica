package com.mensajeria.ServicioMensajeria.Controller;


import com.mensajeria.ServicioMensajeria.Model.Employee;
import com.mensajeria.ServicioMensajeria.Model.Packages;
import com.mensajeria.ServicioMensajeria.Service.PackageServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mensajeria/v1/")
public class PackageController {


    private PackageServiceImple packageServiceImple;

    @Autowired
    public PackageController(PackageServiceImple packageServiceImple) {
        this.packageServiceImple = packageServiceImple;
    }

    @PostMapping("packages")
    public ResponseEntity<Packages> create(@RequestBody Packages packages) {

        Packages PackagesCreate = this.packageServiceImple.create(packages);
        return ResponseEntity.status(HttpStatus.CREATED).body(PackagesCreate);

    }

    @GetMapping("packages")
    public List<Packages> getEmployeeAll() {
        return this.packageServiceImple.getPackagesAll();
    }

    @GetMapping("packages/{id}")
    public Packages getPackage(@PathVariable Integer id) {
        return this.packageServiceImple.getPackages(id);
    }

    @DeleteMapping("packages/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {

        Boolean deleted = this.packageServiceImple.delete(id);

        if (deleted) {
            String messaje = "El package con numero  " + id + "fue eliminado con exito";
            return ResponseEntity.ok(messaje);
        } else {
            String messaje = "El package con numero  " + id + "no fue eliminado, valide el numero de guia ingresado no si exista en la base de datos";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messaje);
        }
    }


    @PutMapping("packages")
    public ResponseEntity<Packages> updateEmployee(@RequestBody Packages packages) {
        Packages empleado = this.packageServiceImple.updatePackages(packages);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(empleado);
    }


}
