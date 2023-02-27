package com.oop.oop.repository;

import com.oop.oop.model.Instrument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentRepository extends MongoRepository<Instrument, Integer> {

	@Query("{'id':?0}")
	Instrument findInstrumentById(Integer id);

}
