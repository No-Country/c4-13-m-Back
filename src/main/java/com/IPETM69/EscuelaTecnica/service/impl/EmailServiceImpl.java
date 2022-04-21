package com.IPETM69.EscuelaTecnica.service.impl;

import com.IPETM69.EscuelaTecnica.auth.dto.RegisterUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImpl {
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    public void enviarEmail(RegisterUserDTO registerUserDTO){
        String asunto = "Registro Exitoso";
        String contenido = "¡Felicitaciones " + registerUserDTO.getFirstName() + "! Te has registrado con éxito en la plataforma.\n"
                + "Tu usuario es: " + registerUserDTO.getEmail() + "\n"
                + "Tu contraseña es: " + registerUserDTO.getPassword();
        
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(registerUserDTO.getEmail());
        simpleMailMessage.setSubject(asunto);
        simpleMailMessage.setText(contenido);
        
        javaMailSender.send(simpleMailMessage);
    }

    

}
