package com.amr.project.service.abstracts;

public interface Mailer {
    void sendMail(String email, String subject, String text);
}
