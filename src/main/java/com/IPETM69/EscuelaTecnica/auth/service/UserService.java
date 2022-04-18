/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.IPETM69.EscuelaTecnica.auth.service;

import com.IPETM69.EscuelaTecnica.auth.dto.RegisterUserDTO;
import com.IPETM69.EscuelaTecnica.auth.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    
    public RegisterUserDTO create(RegisterUserDTO user);
    
    public void validated(RegisterUserDTO user);

    public RegisterUserDTO update(Long id, RegisterUserDTO user);

    public void delete(Long id);

    public RegisterUserDTO findById(Long id);

    public RegisterUserDTO findByEmail(String email);
    
    
}
