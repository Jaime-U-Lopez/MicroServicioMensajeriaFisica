package com.mensajeria.ServicioMensajeria.Service;


import com.mensajeria.ServicioMensajeria.Exception.ExcepcionCustomer;
import com.mensajeria.ServicioMensajeria.Exception.ExcepcionEmployee;
import com.mensajeria.ServicioMensajeria.Model.Customer;
import com.mensajeria.ServicioMensajeria.Model.Employee;
import com.mensajeria.ServicioMensajeria.Repository.EmployeeReposImple;
import com.mensajeria.ServicioMensajeria.Util.UpdateFieldUtil;
import com.mensajeria.ServicioMensajeria.Util.ValidarCorreo;
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
    public Employee create(Employee employee)  throws RuntimeException {

        Optional<Employee> validacionEmployeeExistencia= Optional.of(this.employeeReposImple.create(employee));
         if(!ValidarCorreo.esCorreoValido(employee.getCorreoElectronico())){
            throw new ExcepcionEmployee("The employee could not be created, validate the el email not is correct ");
        }
        if(!validacionEmployeeExistencia.isPresent()){
            throw new ExcepcionEmployee("The employee could not be created, validate the data entered and that the ID no longer exists in the database");
        }
        return this.employeeReposImple.create(employee);
    }

    @Override
    public List<Employee> getEmployeeAll()  throws RuntimeException {

        Optional<List<Employee>> employeeOptional= Optional.ofNullable(this.employeeReposImple.getEmployeesAll());
        if (!employeeOptional.isPresent()){
            throw new ExcepcionEmployee("There are no employees in the database to display ");
        }

        return this.employeeReposImple.getEmployeesAll();
    }

    @Override
    public Employee getEmployee(Integer id)  throws RuntimeException {

        Optional<Employee> employee= Optional.ofNullable(this.employeeReposImple.getEmployee(id));
        if (!employee.isPresent()){
            throw new ExcepcionEmployee("El Employee  con cc " + id + " no existe en la base de datos");
        }
        return employee.get();
    }

    @Override
    public Boolean delete(Integer cedula)  throws RuntimeException {

        this.getEmployee(cedula);

        Optional<Boolean> employee = Optional.ofNullable(this.employeeReposImple.deleteEmployee(cedula));
        if (!employee.isPresent()) {
            throw new ExcepcionEmployee("The Employee  not existed in database");
        }
        return true;
    }

    @Override
    public Employee updateEmployee(Employee employee) throws RuntimeException {

        Optional<Employee> validacionEmployeeExistencia= Optional.of(this.employeeReposImple.create(employee));
        if(!ValidarCorreo.esCorreoValido(employee.getCorreoElectronico())){
            throw new ExcepcionEmployee("The employee "+ employee.getCedula() +  " could not be created, validate the el email not is correct ");
        }
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

            UpdateFieldUtil.updateFieldLong(employee.getNumeroCelular(), (value) -> e.setNumeroCelular(value));

                this.employeeReposImple.UpdateEmployee(e);
            });
        return employeeOptional.get();
    }
}
