package com.IPETM69.EscuelaTecnica.repository;

import com.IPETM69.EscuelaTecnica.entity.ClassEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
        List<ClassEntity> findAll(Specification<ClassEntity> spec);
}
