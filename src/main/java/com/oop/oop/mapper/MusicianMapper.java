package com.oop.oop.mapper;

import com.oop.oop.dto.BandDto;
import com.oop.oop.dto.InstrumentDto;
import com.oop.oop.dto.MusicianDto;
import com.oop.oop.model.Musician;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class MusicianMapper {

    @Mapping(target = "band", ignore = true)
    @Mapping(target = "instrument", ignore = true)
    public abstract MusicianDto musicianToDto(Musician musician);
    @Mapping(source = "instrument.id", target = "instrumentId")
    @Mapping(source = "band.id", target = "bandId")
    public abstract Musician dtoToMusician(MusicianDto musicianDto);



}
