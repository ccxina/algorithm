package utils;

import sort.InsertionSort;
import sort.SelectionSort;

public class SortingHelper {

    private SortingHelper() {
    }

    public static <E extends Comparable<E>> boolean isSorted(E[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i].compareTo(data[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortname, E[] arr) {

        long start = System.nanoTime();
        switch (sortname) {
            case "SelectionSort":
                SelectionSort.sort(arr);
                break;
            case "InsertLowerSort":
                InsertionSort.lowerSort(arr);
                break;
            case "InsertSort":
                InsertionSort.sort(arr);
                break;
        }
        long end = System.nanoTime();
        double time = (end - start) / 1000000000.0;
        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(sortname + " failed!");
        }
        System.out.printf("%s , n = %d : %f s%n", sortname, arr.length, time);
    }

    public static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
