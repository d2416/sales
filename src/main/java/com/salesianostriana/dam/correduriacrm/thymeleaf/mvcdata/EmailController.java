package com.salesianostriana.dam.correduriacrm.thymeleaf.mvcdata;

import com.salesianostriana.dam.correduriacrm.service.EmpleadoService;
import com.salesianostriana.dam.correduriacrm.thymeleaf.mvcdata.repository.EmailData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@Controller
public class EmailController {
    private EmailData emailData;
    private EmailData emailData1;
    private ServletContext servletContext;

    @Autowired
    private EmpleadoService empleadoService;

    public EmailController(ServletContext servletContext) {
        this.servletContext = servletContext;

        emailData1 = new EmailData();
        emailData1.setEmailSubject("texto falso");
    }

    // Test 1
    @GetMapping("/email/beandata")
    public String emailBeanData() {
        return "mvcdata/email-bean-data";
    }

    // Test 2
    @GetMapping(value = "/email/modelattributes")
    public String emailModel(Model model) {

        EmailData emailData2 = new EmailData();
        emailData2.setEmailSubject("emailData2 subject");
        model.addAttribute("emaildata", emailData2);

        String name = empleadoService.getName();
        model.addAttribute("empleadoname", name);

        return "mvcdata/email-model-attributes";
    }

    @ModelAttribute("emailModelAttribute")
    EmailData emailModelAttribute() {
        return emailData;
    }

    // Test 3
    // Ejemplo url:
    // localhost:9000/email/requestparameters?emailsubject=1&emailcontent=2&emailaddress=a@b.com&emailaddress=c@d.com&emaillocale=5
    @GetMapping(value = "/email/requestparameters")
    public String emailRequestParameters(
            @RequestParam(value = "emailsubject") String emailSubject,
            @RequestParam(value = "emailcontent") String emailContent,
            @RequestParam(value = "emailaddress") String emailAddress1,
            @RequestParam(value = "emailaddress") String emailAddress2,
            @RequestParam(value = "emaillocale") String emailLocale) {
        return "mvcdata/email-request-parameters";
    }

    @GetMapping("/email/sessionattributes")
    public String emailSessionAttributes(HttpSession httpSession) {
        httpSession.setAttribute("emaildata", emailData);
        return "mvcdata/email-session-attributes";
    }

    @GetMapping("/email/servletcontext")
    public String emailServletContext() {
        servletContext.setAttribute("emailsubject", emailData.getEmailSubject());
        servletContext.setAttribute("emailcontent", emailData.getEmailBody());
        servletContext.setAttribute("emailaddress", emailData.getEmailAddress1());
        servletContext.setAttribute("emaillocale", emailData.getEmailLocale());
        return "mvcdata/email-servlet-context";
    }


}
