package com.IPETM69.EscuelaTecnica.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImpl {
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    public void enviarEmail(String destinatario){
        String asunto = "Registro Exitoso";
        String contenido = "Felicitaciones! Te has registrado con éxito a la plataforma de Disney.";
        
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(destinatario);
        simpleMailMessage.setSubject(asunto);
        simpleMailMessage.setText(contenido);
        
        javaMailSender.send(simpleMailMessage);
    }

    

}
