package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        IntStream intStream;
        if (leftBorder <= rightBorder) {
            intStream = IntStream.rangeClosed(leftBorder, rightBorder);
        } else {
            intStream = IntStream.rangeClosed(rightBorder, leftBorder);
        }
        return intStream.filter(e -> e % 2 == 0)
                .reduce((sum, e) -> sum + e)
                .getAsInt();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        IntStream intStream;
        if (leftBorder <= rightBorder) {
            intStream = IntStream.rangeClosed(leftBorder, rightBorder);
        } else {
            intStream = IntStream.rangeClosed(rightBorder, leftBorder);
        }
        return intStream.filter(e -> e % 2 != 0)
                .reduce((sum, e) -> sum + e)
                .getAsInt();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.parallelStream().reduce(0,
                (a, b) -> a + b * 3 + 2,
                Integer::sum
        );
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .map(e -> e % 2 == 0 ? e : e * 3 + 2)
                .collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.parallelStream()
                .filter(e -> e % 2 != 0)
                .reduce(0,
                        (a, b) -> a + b * 3 + 5,
                        Integer::sum);
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        Iterator<Integer> iterator = arrayList.stream().iterator();
        ArrayList<Integer> result = new ArrayList<>();
        Integer last = iterator.next();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            result.add((last + next) * 3);
            last = next;
        }
        return result;
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> collect = arrayList.stream().filter(e -> e % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
        int middle = collect.size() / 2;

        if (collect.size() % 2 == 0) {
            return (collect.get(middle) + collect.get(middle - 1)) / 2.0;
        }

        return collect.get(middle);
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(e -> e % 2 == 0)
                .mapToDouble(e -> e)
                .average()
                .getAsDouble();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList())
                .contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(e -> e % 2 == 0)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> list = arrayList.stream()
                .filter(e -> e % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
        list.addAll(arrayList.stream()
                .filter(e -> e % 2 != 0)
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList()));
        return list;
    }
}
