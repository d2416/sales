package com.salesianostriana.dam.correduriacrm.thymeleaf.mvcdata.repository;

import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
public class EmailData implements Serializable {
    private String emailSubject;
    private String emailBody;
    private String emailLocale;
    private String emailAddress1;
    private String emailAddress2;

    // DTO : Data Transfer Object
    // VO : Value Object

    public EmailData() {
        this.emailSubject = "You have received a new message";
        this.emailBody = "Good morning !";
        this.emailLocale = "en-US";
        this.emailAddress1 = "jhon.doe@example.com";
        this.emailAddress2 = "mark.jakob@example.com";
    }

    public String getEmailSubject() {
        return this.emailSubject;
    }

    public String getEmailBody() {
        return this.emailBody;
    }

    public String getEmailLocale() {
        return this.emailLocale;
    }

    public String getEmailAddress1() {
        return this.emailAddress1;
    }

    public String getEmailAddress2() {
        return this.emailAddress2;
    }

    public List<String> getEmailAddresses() {
        List<String> emailAddresses = new ArrayList<>();
        emailAddresses.add(getEmailAddress1());
        emailAddresses.add(getEmailAddress2());
        return emailAddresses;
    }
}
