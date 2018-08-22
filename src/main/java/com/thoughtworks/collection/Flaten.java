package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        return Arrays.stream(array)
                .flatMap(firstDimension -> Arrays.stream(firstDimension))
                .collect(Collectors.toList());
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        return Arrays.stream(array)
                .flatMap(firstDimension -> Arrays.stream(firstDimension))
                .distinct()
                .collect(Collectors.toList());
    }
}
