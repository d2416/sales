package com.salesianostriana.dam.crmcorreduria.service;

import com.salesianostriana.dam.crmcorreduria.model.Employee;
import com.salesianostriana.dam.crmcorreduria.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    // C (Controller)

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public String getEmployeeName() {
        try {
            Employee employee = repository.getById(1L);
            return employee.getName();
        } catch (Exception e) {
            return "No conozco";
        }
    }

    public String getEmployeeName(Long id) {
        Employee employee = repository.getById(id);
        return employee.getName();
    }

    public String getEmployeeName(String name) {
        return repository.findByName(name);
    }
}
