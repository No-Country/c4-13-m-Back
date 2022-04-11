package com.IPETM69.EscuelaTecnica.service;


import com.IPETM69.EscuelaTecnica.dto.TimeDTO;

import java.util.List;

public interface TimeService {

    TimeDTO save(TimeDTO dto);

    List<TimeDTO> saveList(List <TimeDTO> dtos);

    TimeDTO findTimeById(Long Id);

    TimeDTO update(Long id, TimeDTO dto);

    void delete(Long id);

}
