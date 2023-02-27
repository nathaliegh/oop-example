package com.oop.oop.config.dbmigrations;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.oop.oop.model.Band;
import com.oop.oop.model.Musician;
import com.oop.oop.repository.BandRepository;
import com.oop.oop.repository.MusicianRepository;

import java.util.ArrayList;

@ChangeLog
public class DatabaseChangeLog03 {

    @ChangeSet(order = "03", id = "init_Band", author = "rockAndRoll")
    public void initMusicians(BandRepository bandRepository,
                              MusicianRepository musicianRepository) {
        var musicians = new ArrayList<Musician>();
        musicians.add(musicianRepository.findById(2).get());
        musicians.add(musicianRepository.findById(3).get());
        musicians.add(musicianRepository.findById(4).get());
        bandRepository.save(Band.builder()
                .id(1)
                .name("Run away Slide")
                .musicians(musicians)
                .build());

        musicians.clear();
        musicians.add(musicianRepository.findById(5).get());
        musicians.add(musicianRepository.findById(6).get());
        musicians.add(musicianRepository.findById(7).get());
        bandRepository.save(Band.builder()
                .id(2)
                .name("Axelhof")
                .musicians(musicians)
                .build());
    }
}
