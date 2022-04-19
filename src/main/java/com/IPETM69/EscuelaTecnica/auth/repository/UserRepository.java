package com.IPETM69.EscuelaTecnica.auth.repository;

import com.IPETM69.EscuelaTecnica.auth.entity.UserEntity;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
    
    @Modifying
    @Query(value = "INSERT INTO users (id) VALUES (:id)", nativeQuery = true)
    @Transactional
    void putId(@Param("id") Long id);
    
    Optional<UserEntity> findByEmailIgnoreCase(String email);
    
    Optional<UserEntity> findByEmail(String email);
    
    List<UserEntity> findByRole_Name(String name);
    
    List<UserEntity> findByRole_Id(Long id);
    
}
