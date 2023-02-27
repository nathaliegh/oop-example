package com.oop.oop.repository;

import com.oop.oop.model.Band;
import com.oop.oop.model.Instrument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BandRepository extends MongoRepository<Band, Integer> {

    @Query("{'name':?0}")
    Instrument findBandByName(String name);

    @Query("{'id':'?0'}")
    Instrument findBandById(int id);
}
