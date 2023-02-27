package com.oop.oop.mapper;

import com.oop.oop.dto.InstrumentDto;
import com.oop.oop.model.Instrument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class InstrumentMapper {

    @Mapping(target = "musicians",ignore = true)
    public abstract InstrumentDto instrumentToDto(Instrument instrument);
    @Mapping(target = "musicians",ignore = true)
    public abstract Instrument dtoToInstrument(InstrumentDto instrumentDto);

}
