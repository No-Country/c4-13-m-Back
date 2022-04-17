package com.IPETM69.EscuelaTecnica.repository.specification;

import com.IPETM69.EscuelaTecnica.dto.request.FilterDTORequest;
import com.IPETM69.EscuelaTecnica.entity.ActivityEntity;
import com.IPETM69.EscuelaTecnica.entity.ClassEntity;
import com.IPETM69.EscuelaTecnica.entity.ScheduleEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduleSpecification {

    public Specification<ScheduleEntity> getByFilters(FilterDTORequest filterDTO){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(!ObjectUtils.isEmpty(filterDTO.getActivity())){
                Join<ScheduleEntity,ActivityEntity> join = root.join("activity", JoinType.INNER);
                Expression<String> activity = join.get("name");
                predicates.add(activity.in(filterDTO.getActivity()));
            }

            if (!ObjectUtils.isEmpty(filterDTO.getGrade())){
                Join<ScheduleEntity, ClassEntity> join = root.join("classEntity", JoinType.INNER);
                Expression<String> classEntity = join.get("grade");
                predicates.add(classEntity.in(filterDTO.getGrade()));
            }

            if (!ObjectUtils.isEmpty(filterDTO.getDepartment())){
                Join<ScheduleEntity, ClassEntity> join = root.join("classEntity", JoinType.INNER);
                Expression<String> classEntity = join.get("department");
                predicates.add(classEntity.in(filterDTO.getDepartment()));
            }

            query.distinct(true);

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
/*
    public Specification<ActivityEntity> getByFilters(FilterDTORequest activityFilterDTO){

        return (root, query, criteriaBuilder) ->{
            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.hasLength(String.valueOf(activityFilterDTO.getIdActivity())){
                predicates.add(
                        criteriaBuilder.like()
                )
            }
        }


    }

    /*
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

	return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	};


	}

	}

*/

}

