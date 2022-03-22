package com.amr.project.service.impl;

import com.amr.project.service.abstracts.Mailer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Service
@RequiredArgsConstructor
public class MailerImpl implements Mailer {
    JavaMailSender javaMailSender;

    @Override
    public void sendMail(@Email(message = "E-Mail введен неверно!") String email,
                         @Size(max = 30, message = "Превышена допустимая длина темы сообщения!") String subject,
                         @Size(max = 500, message = "Превышен допустимый размер сообщения!")String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
}
