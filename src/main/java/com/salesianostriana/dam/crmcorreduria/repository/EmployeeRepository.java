package com.salesianostriana.dam.crmcorreduria.repository;

import com.salesianostriana.dam.crmcorreduria.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // M (Model)

    String findByName(String name);

}
