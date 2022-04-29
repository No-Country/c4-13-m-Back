package com.IPETM69.EscuelaTecnica.auth.service;

import com.IPETM69.EscuelaTecnica.auth.dto.RegisterUserDTO;
import com.IPETM69.EscuelaTecnica.auth.entity.UserEntity;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    
    UserEntity create(UserEntity user);
    
    List<UserEntity> findAll();
    
    List<UserEntity> findByRole(String role);
    
    boolean emailExists(String email);
    
    UserEntity findById(Long id);
    
    UserEntity findByEmail(String email);
    
    void update(Long id, RegisterUserDTO registerUserDTO);
    
    void put(Long id, UserEntity user);
    
    void delete(Long id);
    
    
}
