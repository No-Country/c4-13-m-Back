package com.IPETM69.EscuelaTecnica.auth.controller;

import com.IPETM69.EscuelaTecnica.auth.dto.RegisterUserDTO;
import com.IPETM69.EscuelaTecnica.auth.dto.RequestLoginDTO;
import com.IPETM69.EscuelaTecnica.auth.dto.ResponseLoginDTO;
import com.IPETM69.EscuelaTecnica.auth.dto.ResponseRegisterDTO;
import com.IPETM69.EscuelaTecnica.auth.dto.UserProfileDTO;
import com.IPETM69.EscuelaTecnica.auth.entity.UserEntity;
import com.IPETM69.EscuelaTecnica.auth.repository.UserRepository;
import com.IPETM69.EscuelaTecnica.auth.service.UserService;
import com.IPETM69.EscuelaTecnica.auth.service.impl.JwtUtil;
import com.IPETM69.EscuelaTecnica.auth.service.impl.UserDetailsServiceImpl;
import com.IPETM69.EscuelaTecnica.exception.ParamNotFound;
import com.IPETM69.EscuelaTecnica.service.impl.EmailServiceImpl;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsServiceImpl userDetailsServices;
    @Autowired
    private EmailServiceImpl emailService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterUserDTO registerUserDTO, HttpServletResponse httpResponse)
        throws ParamNotFound {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        Optional<UserEntity> userOptional = userRepository.findByEmail(registerUserDTO.getEmail());
        if (userOptional.isPresent()) {
            throw new ParamNotFound(String.format("Email %s already exists", registerUserDTO.getEmail()));
        }

        UserEntity user = new UserEntity();
        modelMapper.map(registerUserDTO, user);
        userService.create(user);

        ResponseRegisterDTO responseRegisterDTO = new ResponseRegisterDTO();
        modelMapper.map(user, responseRegisterDTO);
        UserDetails userDetails = userDetailsServices.loadUserByUsername(user.getEmail());
        responseRegisterDTO.setToken(jwtTokenUtil.generateToken(userDetails));
        
        emailService.enviarEmail(registerUserDTO);
        
        return ResponseEntity.created(null).body(responseRegisterDTO);

    }


    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> login(@Valid @RequestBody RequestLoginDTO loginRequestDTO){
        ModelMapper modelMapper = new ModelMapper();
        
        Optional<UserEntity> userOptional = userRepository.findByEmail(loginRequestDTO.getUsername());

        ResponseLoginDTO loginResponse = new ResponseLoginDTO();

        if (userOptional.isPresent()) {
            UserDetails userDetails = userDetailsServices.loadUserByUsername(loginRequestDTO.getUsername());

            if (passwordEncoder.matches(loginRequestDTO.getPassword(), userDetails.getPassword())) {
                Authentication authentication = new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(),
                        loginRequestDTO.getPassword());

                authenticationManager.authenticate(authentication);

                String jwt = jwtTokenUtil.generateToken(userDetails);
                UserEntity user = userOptional.get();
                modelMapper.map(user, loginResponse);
                loginResponse.setToken(jwt);

            } else {
                return ResponseEntity.badRequest().body("Password doesn't match");
            }

            return ResponseEntity.ok().body(loginResponse);

        } else {
            return ResponseEntity.badRequest().body("User not found");
        }
    }

    @GetMapping("/me")
    public ResponseEntity<?> getUserProfile(HttpServletRequest httpServletRequest) throws ParamNotFound {
        if(httpServletRequest.getHeader("Authorization") == null){
            throw new ParamNotFound("User not logged");
        }
        String jwt = httpServletRequest.getHeader("Authorization").substring(7);
        UserEntity user = userService.findByEmail(jwtTokenUtil.extractUserEmail(jwt));
        ModelMapper modelMapper = new ModelMapper();
        UserProfileDTO userProfileDTO = new UserProfileDTO();
        modelMapper.map(user, userProfileDTO);

        return ResponseEntity.ok().body(userProfileDTO);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @Valid @RequestBody RegisterUserDTO registerUserDTO){
        userService.update(id, registerUserDTO);
    }
}
