package com.IPETM69.EscuelaTecnica.auth.repository;

import com.IPETM69.EscuelaTecnica.auth.entity.PrivilegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<PrivilegeEntity, Long>{
    
    PrivilegeEntity findByName(String name);
    
}
