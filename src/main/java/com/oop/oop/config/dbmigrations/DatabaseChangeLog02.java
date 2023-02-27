package com.oop.oop.config.dbmigrations;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.oop.oop.model.Musician;
import com.oop.oop.repository.InstrumentRepository;
import com.oop.oop.repository.MusicianRepository;

@ChangeLog
public class DatabaseChangeLog02 {

    @ChangeSet(order = "02", id = "init_Musician", author = "rockAndRoll")
    public void initMusicians(MusicianRepository musicianRepository,
                              InstrumentRepository instrumentRepository) {
        musicianRepository.save(Musician.builder()
                .id(1)
                .name("Steve Nick")
                .instrumentId(1)
                .build());
        musicianRepository.save(Musician.builder()
                .id(2)
                .name("Tony Gose")
                .instrumentId(2)
                .build());
        musicianRepository.save(Musician.builder()
                .id(3)
                .name("Mr Mee")
                .instrumentId(3)
                .build());
        musicianRepository.save(Musician.builder()
                .id(4)
                .name("Crazy Joe")
                .instrumentId(4)
                .build());
        musicianRepository.save(Musician.builder()
                .id(5)
                .name("Tiny Tina")
                .instrumentId(5)
                .build());
        musicianRepository.save(Musician.builder()
                .id(6)
                .name("Danei")
                .instrumentId(6)
                .build());
        musicianRepository.save(Musician.builder()
                .id(7)
                .name("Sven")
                .instrumentId(7)
                .build());
    }
}
