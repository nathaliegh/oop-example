package com.oop.oop.helper;

import com.oop.oop.common.Common;
import com.oop.oop.model.Band;
import com.oop.oop.model.Musician;
import com.oop.oop.repository.BandRepository;
import com.oop.oop.repository.InstrumentRepository;
import com.oop.oop.repository.MusicianRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.oop.oop.common.Util.random;

@Service
@RequiredArgsConstructor
public class PlayHelper {

    private final Common common;

    private final MusicianRepository musicianRepository;

    private final BandRepository bandRepository;

    private final InstrumentRepository instrumentRepository;

    private static final Logger log = LoggerFactory.getLogger(PlayHelper.class);


    public void addMusicianRandomly(List<Musician> musiciansBandless,
                                    List<Band> manipulateBands,
                                     int randomBandlessNbr,
                                     Map<Band, List<Musician>> musiciansAllowForBand) {
        var i =0;
        do {
            Optional<Map.Entry<Band, List<Musician>>> entryRecord = common.getShuffleBandListFiltered(musiciansAllowForBand);
            entryRecord.ifPresent(entryRecord1 ->
                    addMusicianForBand(musiciansBandless, manipulateBands, musiciansAllowForBand, entryRecord1)
            );
            i++;
        }while(i <= randomBandlessNbr);
    }

    private Map<Band, List<Musician>> addMusicianForBand(List<Musician> musiciansBandless,
                                                         List<Band> manipulateBands,
                                                         Map<Band, List<Musician>> musiciansAllowForBand,
                                                         Map.Entry<Band, List<Musician>> entryRecord) {
        var currentBand = entryRecord.getKey();
        var musiciansAvailable = entryRecord.getValue();
        var musicianRandomIndex = random.nextInt(musiciansAvailable.size());
        var musicianSelected = musiciansAvailable.get(musicianRandomIndex);
        musiciansAvailable.remove(musicianSelected);
        musiciansBandless.remove(musicianSelected);
        musicianSelected.setBandId(currentBand.getId());
        musicianRepository.save(musicianSelected);
        musiciansAllowForBand.remove(currentBand);
        manipulateBands.remove(currentBand);
        currentBand.getMusicians().add(musicianSelected);
        bandRepository.save(currentBand);
        musiciansAllowForBand =  getBandsAvailableMusicians(manipulateBands, musiciansBandless);
        return musiciansAllowForBand;
    }

    public void removeMusicianForEachBand(List<Band> allBands) {
        allBands
                .stream()
                .forEach(band -> {
                    if(!band.getMusicians().isEmpty()) {
                        log.info(" >>> removeMusicianForBand {} ",band.getId());
                        var randomIndex = random.nextInt(band.getMusicians().size());
                        var musician = band.getMusicians().get(randomIndex);
                        musician.setBandId(0);
                        musicianRepository.save(musician);
                        band.getMusicians().remove(randomIndex);
                        bandRepository.save(band);
                    }
                });
    }


    /**
     * get map contains each band which musicians available for it
     *
     * @param bandList
     * @param musiciansBandless
     * @return
     */
    public Map<Band, List<Musician>> getBandsAvailableMusicians(List<Band> bandList,
                                                                 List<Musician> musiciansBandless){
        var instrumentNames = new ArrayList<String>();
        var musiciansAllowForBand = new HashMap<Band, List<Musician>>();
        bandList.stream()
                .forEach(band -> {
                    log.info(" >>> getBandsAvailableMusicians {} ",band.getId());
                    getAllInstrumentsNames(instrumentNames, band.getMusicians());
                    var musicianBandlessFilter = getMusiciansBandlessWithDifferentInstrument(instrumentNames, musiciansBandless);
                    musiciansAllowForBand.put(band, musicianBandlessFilter);
                });
        return musiciansAllowForBand;
    }

    private void getAllInstrumentsNames(ArrayList<String> instrumentsName,
                                        List<Musician> musicians) {
        musicians
                .stream()
                .forEach(musician ->
                        instrumentsName.add(getInstrumentNameForMusician(musician)));
    }

    private String getInstrumentNameForMusician(Musician musician) {
        return instrumentRepository
                .findInstrumentById(musician.getInstrumentId()).getName();
    }

    /**
     * Get all musicians bandless has instrument not exit in the band
     *
     * @param instrumentNamesExist
     * @param musiciansBandless
     * @return
     */
    private List<Musician> getMusiciansBandlessWithDifferentInstrument(List<String> instrumentNamesExist,
                                                                       List<Musician> musiciansBandless){
        var musicianBandlessFilter = new ArrayList<Musician>();
        musiciansBandless.stream()
                .forEach(musician -> {
                    var instrumentName = getInstrumentNameForMusician(musician);
                    if(!instrumentNamesExist.contains(instrumentName)) musicianBandlessFilter.add(musician);
                });
        return musicianBandlessFilter;
    }

}
