package utils;

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
        if (sortname.equals("sort.SelectionSort")) {
            SelectionSort.sort(arr);
        }
        long end = System.nanoTime();
        double time = (end - start) / 1000000000.0;
        System.out.println(time + " s");
        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(sortname + " failed!");
        }
        System.out.println(String.format("%s , n = %d : %f s", sortname, arr.length, time));
    }
}
