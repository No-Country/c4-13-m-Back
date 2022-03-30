package com.IPETM69.EscuelaTecnica.service;


import com.IPETM69.EscuelaTecnica.dto.TimeDTO;

public interface TimeService {

    TimeDTO save(TimeDTO dto);

    TimeDTO findTimeById(Long Id);

    TimeDTO update(Long id, TimeDTO dto);

    void delete(Long id);

}
