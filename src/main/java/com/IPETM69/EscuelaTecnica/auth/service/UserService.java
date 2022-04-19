package com.IPETM69.EscuelaTecnica.auth.service;

import com.IPETM69.EscuelaTecnica.auth.entity.UserEntity;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    
    UserEntity create(UserEntity user);
    
    List<UserEntity> findAll();
    
    List<UserEntity> findByRole(String role);
    
    List<UserEntity> findByRole(Long id);
    
    boolean emailExists(String email);
    
    UserEntity findById(Long id);
    
    UserEntity findByEmail(String email);
    
    void update(Long id, UserEntity user);
    
    void put(Long id, UserEntity user);
    
    void delete(Long id);
    
    
}
