package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        if (left > right) {
            return IntStream.rangeClosed(right, left)
                    .boxed()
                    .sorted((a, b) -> b - a)
                    .collect(Collectors.toList());
        }
        return IntStream.rangeClosed(left, right)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        return getListByInterval(left, right).stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).filter(e -> e % 2 == 0)
                .boxed().collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return Arrays.stream(array).reduce((left, right) -> right).getAsInt();
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> result = Arrays.stream(firstArray)
                .boxed().collect(Collectors.toList());
        result.retainAll(Arrays.stream(secondArray)
                .boxed().collect(Collectors.toList()));
        return result;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> result = Arrays.stream(firstArray)
                .collect(Collectors.toList());
        result.addAll(Arrays.stream(secondArray)
                .collect(Collectors.toList()));
        return result;
    }
}
