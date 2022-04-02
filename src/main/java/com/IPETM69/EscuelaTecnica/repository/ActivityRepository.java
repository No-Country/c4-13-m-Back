package com.IPETM69.EscuelaTecnica.repository;

import com.IPETM69.EscuelaTecnica.entity.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityEntity, Long>{
    
}
