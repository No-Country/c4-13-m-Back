package com.IPETM69.EscuelaTecnica.auth.service.impl;


import com.IPETM69.EscuelaTecnica.auth.dto.RegisterUserDTO;
import com.IPETM69.EscuelaTecnica.auth.entity.UserEntity;
import com.IPETM69.EscuelaTecnica.auth.enums.Roles;
import com.IPETM69.EscuelaTecnica.auth.repository.UserRepository;
import com.IPETM69.EscuelaTecnica.auth.service.UserService;
import com.IPETM69.EscuelaTecnica.exception.ParamNotFound;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    @Override
    public UserEntity create(@NonNull UserEntity user) {
        user.setCreatedAt(new Date());
        user.setPassword(encoder.encode(user.getPassword()));
       return userRepo.save(user);
    }

    @Transactional
    public UserEntity create(String firstName, String lastName, String email, String password, Roles role) {
        return create(UserEntity.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .role(role)
                .build());
    }

    @Transactional
    public UserEntity created(String firstName, String lastName, String email, String password, Roles role) {
        return create(firstName, lastName, email, password, role);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepo.findAll();
    }

    @Override
    public List<UserEntity> findByRole(String role) {
        return userRepo.findByRole(role);
    }

    @Override
    public boolean emailExists(String email) {
        Optional<UserEntity> users = userRepo.findByEmail(email);
        return users.isPresent();
    }

    @Override
    public UserEntity findById(@NonNull Long id) throws ParamNotFound {
        Optional<UserEntity> opt = userRepo.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        }
        throw new ParamNotFound("User not found");
    }

    @Override
    public UserEntity findByEmail(@NonNull @Email String email) throws ParamNotFound {
        Optional<UserEntity> opt = userRepo.findByEmailIgnoreCase(email);
        if (opt.isPresent()) {
            return opt.get();
        }
        throw new ParamNotFound("User not found");
    }

    @Transactional
    @Override
    public void update(@NonNull Long id, @NonNull RegisterUserDTO registerUserDTO) throws ParamNotFound {
        Optional<UserEntity> opt = userRepo.findById(id);
        if (opt.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT).setFieldAccessLevel(AccessLevel.PRIVATE);;
            if(registerUserDTO.getPassword() != null){
                registerUserDTO.setPassword(encoder.encode(registerUserDTO.getPassword()));
            }
            UserEntity user = opt.get();
            modelMapper.map(registerUserDTO, user);
            user.setUpdatedAt(new Date());
            userRepo.save(user);
        } else {
            throw new ParamNotFound("User not found");
        }
    }

    @Transactional
    @Override
    public void put(@NonNull Long id, @NonNull UserEntity newUser) {
        newUser.setId(id);
        Optional<UserEntity> opt = userRepo.findById(id);
        if (opt.isPresent()) {
            UserEntity user = opt.get();
            newUser.setCreatedAt(user.getCreatedAt());
            BeanUtils.copyProperties(newUser, user);
            user.setUpdatedAt(new Date());
            user.setPassword(encoder.encode(newUser.getPassword()));
            userRepo.save(user);
        } else {
            userRepo.putId(id);
            newUser.setCreatedAt(new Date());
            userRepo.save(newUser);
        }
    }

    @Transactional
    @Override
    public void delete(@NonNull Long id) throws ParamNotFound {
        if(userRepo.findById(id).isPresent()){
            userRepo.deleteById(id);
        } else {
            throw new ParamNotFound("User not found");
        }
    }

    
}
