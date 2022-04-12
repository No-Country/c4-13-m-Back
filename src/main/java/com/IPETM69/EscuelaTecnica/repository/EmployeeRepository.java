package com.IPETM69.EscuelaTecnica.repository;

import com.IPETM69.EscuelaTecnica.entity.EmployeeEntity;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    
    @Query("SELECT e FROM employees e WHERE e.first_name like :name;")
    public List<EmployeeEntity> findByName(@Param("name") String name);

    public List<EmployeeEntity> findAll(Specification<EmployeeEntity> specification);
}
