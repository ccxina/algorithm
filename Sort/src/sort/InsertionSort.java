package sort;

import common.ArrayGenerator;
import utils.SortingHelper;

import java.util.Arrays;

public class InsertionSort {

    private InsertionSort() {
    }

    /**
     * 在区间arr[0..j) 找到适合j的位置, 进行插入
     * @param arr 待排序数组
     */
    public static <E extends Comparable<E>> void lowerSort(E[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    SortingHelper.swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 由每次交换，修改为移动
     * @param arr
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {

        for (int i = 0; i < arr.length; i++) {
            E temp = arr[i];
            int j;
            for (j = i; j > 0 && temp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j-1];
            }

            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        Integer[] data = ArrayGenerator.generateRandomArray(20, 30);
        InsertionSort.lowerSort(data);
        System.out.println(SortingHelper.isSorted(data));
        int[] size = {10000, 100000};
        for (int n : size) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("InsertLowerSort", arr);
            SortingHelper.sortTest("InsertSort", arr2);

        }
    }
}
