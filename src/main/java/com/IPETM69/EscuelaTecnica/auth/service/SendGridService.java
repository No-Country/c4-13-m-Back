package com.IPETM69.EscuelaTecnica.auth.service;


public interface SendGridService {
    
    boolean welcomeMessage(String yourFirstName, String yourLastName, String yourEmail);
    boolean contactMessage(String firstName, String email);
}
