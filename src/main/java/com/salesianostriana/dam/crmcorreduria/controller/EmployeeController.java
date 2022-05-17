package com.salesianostriana.dam.crmcorreduria.controller;

import com.salesianostriana.dam.crmcorreduria.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EmployeeController {

    // View

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employeename")
    public String getEmployeeName() {
        return service.getEmployeeName();
    }

    @GetMapping("/employeename/{id}")
    public String getEmployeeName(@PathVariable Long id) {
        return service.getEmployeeName(id);
    }

}
