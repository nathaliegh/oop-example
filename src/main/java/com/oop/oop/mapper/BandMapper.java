package com.oop.oop.mapper;

import com.oop.oop.dto.BandDto;
import com.oop.oop.model.Band;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class BandMapper {
    @Mapping(target = "musicians",ignore = true)
    public abstract BandDto bandToDto(Band band);
    @Mapping(target = "musicians",ignore = true)
    public abstract Band dtoToBand(BandDto bandDto);

    public abstract List<BandDto> bandsToDtos(List<Band> band);

}
