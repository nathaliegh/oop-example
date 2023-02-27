package com.oop.oop.mapper;

import com.oop.oop.dto.MusicianDto;
import com.oop.oop.model.Musician;
import com.oop.oop.repository.BandRepository;
import com.oop.oop.repository.InstrumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class MusicianDetailsMapper {

    private final InstrumentRepository instrumentRepository;

    private final BandRepository bandRepository;


    private final MusicianMapper musicianMapper;

    private final InstrumentMapper instrumentMapper;

    private final BandMapper bandMapper;


    public MusicianDto musicianToDto(Musician musician) {
    var musicianDto = musicianMapper.musicianToDto(musician);
        setMusicianInstrumentDto(musician, musicianDto);
        setMusicianBand(musician, musicianDto);
        return musicianDto;
    }

    private void setMusicianBand(Musician musician, MusicianDto musicianDto) {
        bandRepository
                .findById(musician.getBandId())
                        .ifPresent(band ->musicianDto
                                .setBand(bandMapper
                                .bandToDto(band)) );
    }

    private void setMusicianInstrumentDto(Musician musician, MusicianDto musicianDto) {
        musicianDto.setInstrument(instrumentMapper
                .instrumentToDto(instrumentRepository
                        .findInstrumentById(musician.getInstrumentId())));
    }

    public List<MusicianDto> musiciansToDtos(List<Musician> musicians) {
        var musiciansDto = new ArrayList<MusicianDto>();
        musicians.stream()
                .forEach(musician -> {
                    musiciansDto.add(musicianToDto(musician));
                });
        return musiciansDto;
    }



}
