package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public Integer getMaximum() {
        return arrayList.stream().max(Integer::compareTo).orElse(null);
    }

    public Integer getMinimum() {
        return arrayList.stream().min(Integer::compareTo).orElse(null);
    }

    public double getAverage() {
        return arrayList.stream()
                .mapToDouble(e -> e).average().getAsDouble();
    }

    public double getOrderedMedian() {
        List<Integer> list = arrayList.stream().sorted().collect(Collectors.toList());
        int middle = list.size() / 2;

        if (list.size() % 2 == 0) {
            return (list.get(middle) + list.get(middle - 1)) / 2.0;
        }

        return list.get(middle);
    }

    public int getFirstEven() {
        return arrayList.stream()
                .filter(e -> e % 2 == 0)
                .findFirst().get();
    }

    public int getIndexOfFirstEven() {
        Integer value = arrayList.stream()
                .filter(e -> e % 2 == 0)
                .findFirst().get();
        return arrayList.indexOf(value);
    }

    public int getLastOdd() {
        return arrayList.stream().filter(e -> e % 2 != 0).reduce((a, b) -> b).get();
    }

    public int getIndexOfLastOdd() {
        Integer value = arrayList.stream().filter(e -> e % 2 != 0).reduce((a, b) -> b).get();
        return arrayList.indexOf(value);
    }

    public boolean isEqual(List<Integer> arrayList) {
        this.arrayList.sort(Integer::compareTo);
        arrayList.sort(Integer::compareTo);
        return Arrays.equals(new List[]{arrayList}, new List[]{this.arrayList});
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        arrayList.stream().sorted().forEach(singleLink::addTailPointer);
        int middle = arrayList.size() / 2;

        if (arrayList.size() % 2 == 0) {
            return ((Integer) singleLink.getNode(middle) + (Integer) singleLink.getNode(middle + 1)) / 2.0;
        }

        return (Double) singleLink.getNode(middle);
    }
}
