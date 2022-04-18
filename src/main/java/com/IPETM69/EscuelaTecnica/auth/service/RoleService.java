/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.IPETM69.EscuelaTecnica.auth.service;

import com.IPETM69.EscuelaTecnica.auth.entity.RoleEntity;
import java.util.List;


public interface RoleService {
    
    public RoleEntity create(RoleEntity  role);
    
    public List<RoleEntity> findAll();
    
    public RoleEntity findById(Long id);
    
    public RoleEntity findByName(String name);
    
    public void update(Long id, RoleEntity role);
    
    public void delete(Long id);
    
    public void put(Long id, RoleEntity role);
    
}
