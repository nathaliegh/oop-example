package com.oop.oop.service;

import com.oop.oop.dto.BandDto;
import com.oop.oop.mapper.BandDetailsMapper;
import com.oop.oop.repository.BandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BandService {

    private final BandDetailsMapper bandDetailsMapper;
    private final BandRepository bandRepository;
    public List<BandDto> getAllBands(){
        return bandDetailsMapper.bandsToDtos(bandRepository.findAll());
    }


}
