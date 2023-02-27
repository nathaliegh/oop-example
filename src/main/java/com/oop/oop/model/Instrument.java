package com.oop.oop.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "instruments")
public class Instrument {
	@MongoId(value = FieldType.INT32)
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

	@DBRef
	private List<Musician> musicians;

}
