package com.oop.oop.common;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Common <T,S> {

public  final Optional<Map.Entry<T, List<S>>> getShuffleBandListFiltered(Map<T, List<S>> mapContainsList) {
        var record = mapContainsList
        .entrySet()
        .stream()
        .collect(getRandomCollector())
        .filter(entry -> entry.getValue().size() > 0)
        .findFirst();
        return record;
        }

    private  Collector<Map.Entry<T, List<S>>, Object,
            Stream<Map.Entry<T, List<S>>>> getRandomCollector() {
        return Collectors.collectingAndThen(Collectors.toList(), collected -> {
            Collections.shuffle(collected);
            return collected.stream();
        });
    }
}
