package com.oop.oop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BandDto {

    private int id;

    private String name;

    private List<MusicianDto> musicians;
}
