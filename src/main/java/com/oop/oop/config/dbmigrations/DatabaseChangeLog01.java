package com.oop.oop.config.dbmigrations;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.oop.oop.model.Instrument;
import com.oop.oop.repository.InstrumentRepository;

@ChangeLog
public class DatabaseChangeLog01 {

    @ChangeSet(order = "01", id = "init_instruments", author = "rockAndRoll")
    public void initInstruments(InstrumentRepository instrumentRepository) {
        instrumentRepository.save(Instrument.builder()
                .id(1)
                .name("Bass")
                .numberOfStrings(6)
                .manufacturer("Fodera")
                .size("7mm")
                .build());
        instrumentRepository.save(Instrument.builder()
                .id(2)
                .name("Banjo")
                .numberOfStrings(6)
                .manufacturer("Fender")
                .size("0.9mm")
                .build());
        instrumentRepository.save(Instrument.builder()
                .id(3)
                .name("Piano")
                .numberOfKeys(64)
                .manufacturer("Honda")
                .is("acoustic")
                .build());
        instrumentRepository.save(Instrument.builder()
                .id(4)
                .name("Drums")
                .manufacturer("Killy")
                .has("hi-hat")
                .build());
        instrumentRepository.save(Instrument.builder()
                .id(5)
                .name("Bass")
                .numberOfStrings(5)
                .manufacturer("Gibson")
                .size("4mm")
                .build());
        instrumentRepository.save(Instrument.builder()
                .id(6)
                .name("Drums")
                .manufacturer("Gibson")
                .has("Regnal")
                .build());
        instrumentRepository.save(Instrument.builder()
                .id(7)
                .name("Synthesizer")
                .numberOfKeys(64)
                .manufacturer("Suzuki")
                .has("no LED")
                .build());
    }
}
