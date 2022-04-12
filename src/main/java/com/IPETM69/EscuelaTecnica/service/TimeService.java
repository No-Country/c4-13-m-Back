package com.IPETM69.EscuelaTecnica.service;


import com.IPETM69.EscuelaTecnica.dto.request.TimeDTO;
import com.IPETM69.EscuelaTecnica.dto.response.TimePrintDTO;

import java.util.List;

public interface TimeService {

    TimePrintDTO save(TimeDTO dto);

    List<TimePrintDTO> saveList(List <TimeDTO> dtos);

//    TimeDTO findTimeById(Long Id);

    TimePrintDTO update(Long id, TimeDTO dto);

    void delete(Long id);

}
