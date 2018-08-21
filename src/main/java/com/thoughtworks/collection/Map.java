package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Map {

    List<Integer> array;

    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public Map(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream()
                .map(element -> element * 3)
                .collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream()
                .map(element -> letterList.get(element - 1))
                .collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return array.stream()
                .map(element -> {
                    String letter = "";
                    Integer n = element;
                    while (n > 0){
                        int m = n % 26;
                        if (m == 0) m = 26;
                        letter = letterList.get(m - 1) + letter;
                        n = (n - m) / 26;
                    }
                    return letter;
                })
                .collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        return array.stream()
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
