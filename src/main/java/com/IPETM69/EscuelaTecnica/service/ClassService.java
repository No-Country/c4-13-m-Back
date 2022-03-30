package com.IPETM69.EscuelaTecnica.service;

import com.IPETM69.EscuelaTecnica.dto.ClassDto;

import java.util.List;

public interface ClassService {

    ClassDto save (ClassDto dto);

    void delete(Long id);

    ClassDto update(Long id, ClassDto classDTO);

    List<ClassDto> getAllClasses();
}
