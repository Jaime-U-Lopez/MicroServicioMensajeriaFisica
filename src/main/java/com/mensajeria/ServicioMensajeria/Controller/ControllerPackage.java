package com.mensajeria.ServicioMensajeria.Controller;



import com.mensajeria.ServicioMensajeria.Model.Packages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-mensajeria/v1/")
public class ControllerPackage {


    private ServicePackage servicePackage;

    @Autowired
    public ControllerPackage(ServicePackage servicePackage) {

        this.servicePackage = servicePackage;
    }


    @PostMapping("package")
    public boolean createPackage(@RequestBody Packages packages) {
        return this.servicePackage.createPackage(packages);

    }

    @GetMapping("package/{id}")
    public Packages getPackage(@PathVariable String id) {
        return this.servicePackage.getPackage(id);
    }


    @GetMapping("package-all")
    public List<Packages> getPackagesAll() {
        return this.servicePackage.getPackageAll();
    }


    @DeleteMapping("package/{id}")
    public boolean deletePackage(@PathVariable String id) {
        return this.servicePackage.deletePackage(id);
    }

    @PutMapping("package/{id}")
    public boolean updatePackage(@RequestBody Packages packages, @PathVariable String id) {
        return this.servicePackage.updatePackage(packages,id);
    }


}
