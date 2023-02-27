package com.oop.oop.mapper;

import com.oop.oop.dto.BandDto;
import com.oop.oop.model.Band;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class BandDetailsMapper {

    private final BandMapper bandMapper;

    private final MusicianDetailsMapper musicianDetailsMapper;

    public BandDto bandToDto(Band band) {
         var bandDto = bandMapper.bandToDto(band);
        bandDto.setMusicians(musicianDetailsMapper
                .musiciansToDtos(band.getMusicians()));
       return bandDto;
    }

    public List<BandDto> bandsToDtos(List<Band> bandList) {
        var bandsDto = new ArrayList<BandDto>();
        bandList.stream()
                .forEach(band -> bandsDto.add(bandToDto(band)));
        return bandsDto;
    }

}
