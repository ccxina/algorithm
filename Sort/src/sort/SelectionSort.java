package sort;

import common.*;
import utils.SortingHelper;

import java.util.Arrays;

public class SelectionSort {
    private SelectionSort() {
    }

    /**
     * arr[0...i)有序 arr(i...n) 无序
     * 选择出无序中最小(最大)的值,与当前值进行交换
     *
     * @param arr 要排序的数组
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
    public static <E extends Comparable<E>> void reverseSort(E[] arr) {
        for (int i = arr.length - 1; i >= 0 ; i--) {
            int minIndex = i;
            for (int j = i; j >= 0 ; j--) {
                if (arr[j].compareTo(arr[minIndex]) > 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] data = ArrayGenerator.generateRandomArray(10, 10);;
        SelectionSort.sort(data);
        System.out.println(Arrays.toString(data));
        SelectionSort.reverseSort(data);
        System.out.println(Arrays.toString(data));
        Student[] students = {new Student(22, "aa"),
                new Student(2, "bb"),
                new Student(11, "cc")};
        SelectionSort.sort(students);
        System.out.println(Arrays.toString(students));

        int[] size = {1000, 100000};
        for (int n : size) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("sort.SelectionSort", arr);
        }
    }
}
