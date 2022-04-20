package com.IPETM69.EscuelaTecnica;

import com.IPETM69.EscuelaTecnica.auth.entity.UserEntity;
import com.IPETM69.EscuelaTecnica.auth.enums.Roles;
import com.IPETM69.EscuelaTecnica.auth.repository.UserRepository;
import com.IPETM69.EscuelaTecnica.auth.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EscuelaTecnicaApplication implements ApplicationRunner {
    
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
	SpringApplication.run(EscuelaTecnicaApplication.class, args);
    }
    
     @Override
    public void run(ApplicationArguments args) {
        
            Optional<UserEntity> opt = userRepository.findByEmailIgnoreCase("admin@admin.com");
            if (!opt.isPresent()) {
                UserEntity user = new UserEntity();
                user.setEmail("admin@admin.com");
                user.setFirstName("Administrador");
                user.setLastName("Root");
                user.setPassword("admin");
                user.setRole(Roles.ADMIN);
                userService.create(user);
            }

    }

}
