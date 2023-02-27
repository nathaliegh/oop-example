package com.oop.oop.controller;

import com.oop.oop.dto.BandDto;
import com.oop.oop.service.PlayService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
@EnableAsync
@RequiredArgsConstructor
public class PlayController {

    private static final Logger log = LoggerFactory.getLogger(PlayController.class);

    private final PlayService playService;

    @QueryMapping
    public Flux<BandDto> playNight() {
        log.info(" >>> play one night");
        List<BandDto> bands = new ArrayList<>();
        try {
            bands = playService.playNightN(1);
            log.info(" <<< play one night");
        }  catch (InterruptedException | ExecutionException e) {
            log.error("Interrupted!",e);
            Thread.currentThread().interrupt();
        }
        return Flux.fromIterable(bands);
    }

    @SchemaMapping(typeName = "Query",field="playNightN")
    public Flux<BandDto> playNightN(@Argument(name="n") int n){
        log.info(" >>> play {} night", n);
        List<BandDto> bands = new ArrayList<>();
        try {
            bands = playService.playNightN(n);
            log.info(" <<< play {} night",n);
        } catch (InterruptedException | ExecutionException e) {
            log.error("Interrupted!",e);
            Thread.currentThread().interrupt();
        }
        return Flux.fromIterable(bands);
    }


}
