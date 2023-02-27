package com.oop.oop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicianDto {

    @MongoId(value = FieldType.INT32)
    private int id;

    private String name;

    private InstrumentDto instrument;
    private BandDto band;
}
