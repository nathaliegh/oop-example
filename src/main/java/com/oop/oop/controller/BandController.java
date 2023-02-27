package com.oop.oop.controller;

import com.oop.oop.dto.BandDto;
import com.oop.oop.service.BandService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
public class BandController {

    private static final Logger log = LoggerFactory.getLogger(BandController.class);

    private final BandService bandService;

    @QueryMapping
    public Flux<BandDto> allBands() {
        log.info("fetch all bands");
        return Flux.fromIterable(bandService.getAllBands());
    }



}
