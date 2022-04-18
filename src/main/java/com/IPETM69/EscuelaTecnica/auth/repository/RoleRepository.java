package com.IPETM69.EscuelaTecnica.auth.repository;

import com.IPETM69.EscuelaTecnica.auth.entity.RoleEntity;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    
    RoleEntity findByName(String name);
    
    @Modifying
    @Query(value = "INSERT INTO roles (id) VALUES (:id)", nativeQuery = true)
    @Transactional
    void putId(@Param("id") Long id);
    

   
    
}
