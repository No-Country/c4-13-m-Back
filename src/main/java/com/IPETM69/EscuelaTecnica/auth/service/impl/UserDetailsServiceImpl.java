package com.IPETM69.EscuelaTecnica.auth.service.impl;

import com.IPETM69.EscuelaTecnica.auth.entity.UserEntity;
import com.IPETM69.EscuelaTecnica.auth.repository.UserRepository;
import com.IPETM69.EscuelaTecnica.exception.ParamNotFound;
import java.util.ArrayList;
import java.util.Collection;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws ParamNotFound {
        Optional<UserEntity> user = userRepository.findByEmail(username);

        user.orElseThrow(() -> new ParamNotFound("Not found: " + username));

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.get().getRole().getName()));

        return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(), authorities);
    }
}
