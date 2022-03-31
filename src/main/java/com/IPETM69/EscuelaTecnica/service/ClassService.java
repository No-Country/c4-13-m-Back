package com.IPETM69.EscuelaTecnica.service;

import com.IPETM69.EscuelaTecnica.dto.ClassDTO;

import java.util.List;

public interface ClassService {

    public ClassDTO create(ClassDTO dto);

    public void delete(Long id);

    public ClassDTO update(Long id, ClassDTO classDTO);

    public List<ClassDTO> getAllClasses();

    public ClassDTO findById(Long id);
}
