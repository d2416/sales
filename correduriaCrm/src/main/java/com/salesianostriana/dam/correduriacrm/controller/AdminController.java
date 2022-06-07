package com.salesianostriana.dam.correduriacrm.controller;

import com.salesianostriana.dam.correduriacrm.model.Empleado;
import com.salesianostriana.dam.correduriacrm.repository.EmpleadoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private EmpleadoRepository empleadoRepo;

    @GetMapping("/admin")
    public String adminIndex(Model model, @AuthenticationPrincipal UserDetails user) {

        //model.addAttribute("usuario", user.getUsername());
        Optional<Empleado> elUsuario = empleadoRepo.findUserByUsername(user.getUsername());

        if (elUsuario.isPresent()) {
            model.addAttribute("usuario", elUsuario.get());
        } else {
            return "error404";
        }

        return "dashboard/admin/index";
    }


}
