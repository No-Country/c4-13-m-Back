package com.IPETM69.EscuelaTecnica.service;


import com.IPETM69.EscuelaTecnica.dto.TimeDTO;
import com.IPETM69.EscuelaTecnica.dto.TimePrintDTO;

public interface TimeService {

    TimePrintDTO save(TimeDTO dto);

//    TimeDTO findTimeById(Long Id);

    TimePrintDTO update(Long id, TimeDTO dto);

    void delete(Long id);

}
