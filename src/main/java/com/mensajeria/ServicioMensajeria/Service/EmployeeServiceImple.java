package com.mensajeria.ServicioMensajeria.Service;


import com.mensajeria.ServicioMensajeria.Exception.ExcepcionEmployee;
import com.mensajeria.ServicioMensajeria.Model.Customer;
import com.mensajeria.ServicioMensajeria.Model.Employee;
import com.mensajeria.ServicioMensajeria.Repository.EmployeeReposImple;
import com.mensajeria.ServicioMensajeria.Util.UpdateFieldUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class EmployeeServiceImple implements EmployeeService {


    private EmployeeReposImple employeeReposImple;

    @Autowired
    public EmployeeServiceImple(EmployeeReposImple employeeReposImple) {
        this.employeeReposImple = employeeReposImple;
    }

    public EmployeeServiceImple() {
    }


    @Override
    public Employee create(Employee employee) {

        Optional<Employee> validacionEmployeeExistencia= Optional.of(this.employeeReposImple.create(employee));
        if(!validacionEmployeeExistencia.isPresent()){
            throw new ExcepcionEmployee("The employee could not be created, validate the data entered and that the ID no longer exists in the database");
        }

        return this.employeeReposImple.create(employee);
    }

    @Override
    public List<Employee> getEmployeeAll() {

        Optional<List<Employee>> employeeOptional= Optional.ofNullable(this.employeeReposImple.getEmployeesAll());

        if (!employeeOptional.isPresent()){

            throw new ExcepcionEmployee("There are no employees in the database to display ");

        }

        return this.employeeReposImple.getEmployeesAll();
    }

    @Override
    public Employee getEmployee(Integer id) {

        Optional<Employee> employee= Optional.ofNullable(this.employeeReposImple.getEmployee(id));

        if (!employee.isPresent()){
            throw  new RuntimeException("The employee not existed in database");
        }

        return employee.get();

    }

    @Override
    public Boolean delete(Integer cedula) {

        Optional<Boolean> customer = Optional.ofNullable(this.employeeReposImple.deleteEmployee(cedula));
        if (!customer.isPresent()) {
            throw new RuntimeException("The Employee  not existed in database");
        }
        return true;
    }

    @Override
    public Employee updateEmployee(Employee employee) {

        Integer idCedula=employee.getCedula();
        Optional<Employee> employeeOptional= Optional.ofNullable(this.employeeReposImple.getEmployee(idCedula));

        if(!employeeOptional.isPresent()){
            throw new ExcepcionEmployee("The employee could not be updated, the id does not exist in the database");
        }

        employeeOptional.ifPresent(e -> {
            UpdateFieldUtil.updateFieldNullEmptyString(employee.getName(), e::setName);
            UpdateFieldUtil.updateFieldNullEmptyString(employee.getLastName(), e::setLastName);
            UpdateFieldUtil.updateFieldNullEmptyString(employee.getCiudad(), e::setCiudad);
            UpdateFieldUtil.updateFieldNullEmptyString(employee.getCorreoElectronico(), e::setCorreoElectronico);
            UpdateFieldUtil.updateFieldNullEmptyString(employee.getDireccionResidencia(), e::setDireccionResidencia);
            UpdateFieldUtil.updateFieldNullEmptyString(employee.getTipoSangreRH(), e::setTipoSangreRH);
            UpdateFieldUtil.updateFieldNullEmptyString(employee.getDireccionResidencia(), e::setDireccionResidencia);

            UpdateFieldUtil.updateFieldDate(employee.getAntiguedad(), e::setAntiguedad);

            UpdateFieldUtil.updateFieldLong(employee.getCelular(), (value) -> e.setCelular(value));

                this.employeeReposImple.UpdateEmployee(e);
            });


        return employeeOptional.get();
    }
}
