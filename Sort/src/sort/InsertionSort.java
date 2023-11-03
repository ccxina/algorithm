package sort;

import common.ArrayGenerator;
import utils.SortingHelper;

import java.util.Arrays;

public class InsertionSort {

    private InsertionSort() {
    }

    public static <E extends Comparable<E>>void sort(E[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    SortingHelper.swap(arr, j, j - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] data = ArrayGenerator.generateRandomArray(20, 30);
        InsertionSort.sort(data);
        System.out.println(Arrays.toString(data));
        int[] size = {1000, 100000};
        for (int n : size) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("InsertSort", arr);
        }
    }
}
