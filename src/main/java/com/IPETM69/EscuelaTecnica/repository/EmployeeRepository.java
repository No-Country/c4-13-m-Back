package com.IPETM69.EscuelaTecnica.repository;

import com.IPETM69.EscuelaTecnica.entity.EmployeeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long>, JpaSpecificationExecutor<EmployeeEntity> {

    List<EmployeeEntity> findAll(Specification<EmployeeEntity> specification);
}
