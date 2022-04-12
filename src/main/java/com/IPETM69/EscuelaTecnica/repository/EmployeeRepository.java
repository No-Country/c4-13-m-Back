package com.IPETM69.EscuelaTecnica.repository;

import com.IPETM69.EscuelaTecnica.entity.EmployeeEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    
    @Query(value = "SELECT * FROM employees WHERE LOWER(first_name) LIKE (:name)" +
            "or LOWER(last_name) LIKE (:name)", nativeQuery = true)
    List<EmployeeEntity> findByName(@Param("name") String name);
}
