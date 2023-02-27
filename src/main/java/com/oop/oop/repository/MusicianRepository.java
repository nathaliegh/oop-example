package com.oop.oop.repository;

import com.oop.oop.model.Musician;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicianRepository extends MongoRepository<Musician, Integer> {

    @Query("{'bandId':?0}")
    List<Musician> findAllByBandId(int bandId);
}
