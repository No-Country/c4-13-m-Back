package com.IPETM69.EscuelaTecnica.repository;

import com.IPETM69.EscuelaTecnica.dto.request.FilterDTORequest;
import com.IPETM69.EscuelaTecnica.entity.ScheduleEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long>, JpaSpecificationExecutor<ScheduleEntity> {

    List<ScheduleEntity> findAll(Specification<ScheduleEntity> spec);
}
