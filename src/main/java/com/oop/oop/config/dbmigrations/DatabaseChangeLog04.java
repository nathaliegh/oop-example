package com.oop.oop.config.dbmigrations;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.oop.oop.repository.MusicianRepository;

@ChangeLog
public class DatabaseChangeLog04 {

    @ChangeSet(order = "04", id = "update_Musician", author = "rockAndRoll")
    public void updateMusicians(MusicianRepository musicianRepository) {
        var musician = musicianRepository.findById(2);
        musician.get().setBandId(1);
        musicianRepository.save(musician.get());

        musician = musicianRepository.findById(3);
        musician.get().setBandId(1);
        musicianRepository.save(musician.get());

        musician = musicianRepository.findById(4);
        musician.get().setBandId(1);
        musicianRepository.save(musician.get());

        musician = musicianRepository.findById(5);
        musician.get().setBandId(2);
        musicianRepository.save(musician.get());

        musician = musicianRepository.findById(6);
        musician.get().setBandId(2);
        musicianRepository.save(musician.get());

        musician = musicianRepository.findById(7);
        musician.get().setBandId(2);
        musicianRepository.save(musician.get());
    }
}
