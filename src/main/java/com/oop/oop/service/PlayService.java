package com.oop.oop.service;

import com.oop.oop.dto.BandDto;
import com.oop.oop.helper.PlayHelper;
import com.oop.oop.model.Band;
import com.oop.oop.model.Musician;
import com.oop.oop.repository.BandRepository;
import com.oop.oop.repository.MusicianRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.oop.oop.common.Util.random;

@Service
@RequiredArgsConstructor
public class PlayService {

    private final BandRepository bandRepository;

    private final MusicianRepository musicianRepository;

    private final BandService bandService;

    private final PlayHelper playHelper;

    private static final Logger log = LoggerFactory.getLogger(PlayService.class);



    public List<BandDto> playNightN(int n) throws InterruptedException, ExecutionException {
        log.info(" >>> playNightN {} ",n);
        CompletableFuture<List<BandDto>> bands = CompletableFuture.completedFuture(List.of(new BandDto()));
        for(int i =0; i< n ;i++){
            log.info(" >>> playNightN {} ",i);
            bands = playNightAsync();
            if(bands.isDone()) Thread.sleep(3000);
            log.info(" <<<  playNightN {}, {} ",i , bands.get());
        }
        return bands.get();
    }

    @Async
    public CompletableFuture<List<BandDto>> playNightAsync() {
        log.info(" >>> playNightAsync ");
        var allBands = bandRepository.findAll();
        log.info(" remove one member from each band ");
        playHelper.removeMusicianForEachBand(allBands);
        // add random number musicians to a random bands taking into consideration the instrument name is unique foreach band
        var musiciansBandless = musicianRepository.findAllByBandId(0);
        var manipulateBands = new ArrayList<>(allBands);
        var randomBandlessNbr = getRandomBandlessNbr(musiciansBandless, manipulateBands);
        var musiciansAllowForBand = playHelper.getBandsAvailableMusicians(manipulateBands, musiciansBandless);
        playHelper.addMusicianRandomly(musiciansBandless, manipulateBands, randomBandlessNbr, musiciansAllowForBand);
        log.info(" <<< playNightAsync ");
        return  CompletableFuture.completedFuture(bandService.getAllBands());
    }

    private int getRandomBandlessNbr(List<Musician> musiciansBandless, ArrayList<Band> manipulateBands) {
        return random.nextInt((Integer.max(musiciansBandless.size(),
                manipulateBands.size()) - Integer.min(musiciansBandless.size(), manipulateBands.size()))
                + Integer.min(musiciansBandless.size(), manipulateBands.size()));
    }


}
