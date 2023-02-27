package com.oop.oop.dto;

import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstrumentDto {
	private int id;

	@NonNull
	private String name;

	private int numberOfStrings;

	private int numberOfKeys;

	private String has;

	@NonNull
	private String manufacturer;

	private String size;

	private String is;

	private List<MusicianDto> musicians;

}
