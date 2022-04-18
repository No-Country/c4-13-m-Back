package com.IPETM69.EscuelaTecnica.auth.service.impl;

import com.IPETM69.EscuelaTecnica.auth.entity.RoleEntity;
import com.IPETM69.EscuelaTecnica.auth.repository.RoleRepository;
import com.IPETM69.EscuelaTecnica.auth.service.RoleService;
import com.IPETM69.EscuelaTecnica.exception.ParamNotFound;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    
    @Autowired
    private RoleRepository roleRepo;
    
    @Transactional
    @Override
    public RoleEntity create(@NonNull RoleEntity role){
        role.setCreatedAt(new Date());
        return roleRepo.save(role);
    }
    
    @Transactional
    public RoleEntity create(String name){
        return create(RoleEntity.builder()
                .name(name)
                .build());
    }
    
    @Override
    public List<RoleEntity> findAll(){
        return roleRepo.findAll();
    }
    
    @Override
    public RoleEntity findById(@NonNull Long id) throws ParamNotFound {
        Optional<RoleEntity> opt = roleRepo.findById(id);
        if (opt.isPresent()){
            return opt.get();
        }
        throw new ParamNotFound("Role not found");
    }
    
    @Override
    public RoleEntity findByName(@NonNull String name) throws ParamNotFound {
        RoleEntity role = roleRepo.findByName(name);
        if(role == null){
            throw new ParamNotFound("Role not found");
        }
        return role;
    }
    
    @Transactional
    @Override
    public void update(@NonNull Long id, @NonNull RoleEntity newRole) throws ParamNotFound {
        Optional<RoleEntity> opt = roleRepo.findById(id);
        if (opt.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT).setFieldAccessLevel(AccessLevel.PRIVATE);
            RoleEntity role = opt.get();
            modelMapper.map(newRole, role);
            role.setUpdatedAt(new Date());
            roleRepo.save(role);
        } else {
            throw new ParamNotFound("User not found");
        }
    }
    
    @Transactional
    @Override
    public void put(@NonNull Long id, @NonNull RoleEntity newRole) {
        Optional<RoleEntity> opt = roleRepo.findById(id);
        if (opt.isPresent()) {
            RoleEntity role = opt.get();
            newRole.setCreatedAt(role.getCreatedAt());
            BeanUtils.copyProperties(newRole, role);
            role.setUpdatedAt(new Date());
            roleRepo.save(role);
        } else {
            roleRepo.putId(id);
            newRole.setCreatedAt(new Date());
            roleRepo.save(newRole);
        }
    }
    
    @Transactional
    @Override
    public void delete(@NonNull Long id) throws ParamNotFound {
        if(roleRepo.findById(id).isPresent()){
            roleRepo.deleteById(id);
        } else {
            throw new ParamNotFound("User not found");
        }
    }
    
}
