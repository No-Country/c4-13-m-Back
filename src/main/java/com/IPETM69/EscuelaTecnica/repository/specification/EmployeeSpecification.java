package com.IPETM69.EscuelaTecnica.repository.specification;

import com.IPETM69.EscuelaTecnica.dto.EmployeeFilterDTO;
import com.IPETM69.EscuelaTecnica.entity.EmployeeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeSpecification {

    public Specification<EmployeeEntity> getByFilters(EmployeeFilterDTO employeeFilterDTO){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(employeeFilterDTO.getFirstName())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("firstName")),
                                "%"+employeeFilterDTO.getFirstName().toLowerCase()+"%"
                        )
                );
            }

            if (StringUtils.hasLength(employeeFilterDTO.getLastName())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("lastName")),
                                "%"+employeeFilterDTO.getLastName().toLowerCase()+"%"
                        )
                );
            }

            query.distinct(true);

            return criteriaBuilder.and(predicates.toArray(predicates.toArray(new Predicate[0])));
        };


    }

}
