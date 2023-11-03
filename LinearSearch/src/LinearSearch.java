import common.ArrayGenerator;
import common.Student;

public class LinearSearch {

    private LinearSearch() {}

    /**
     * 线性查找
     * @param data 带查找的数组
     * @param target 目标
     * @return 返回数组下标 -1 为失败
     */
    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++)
            if (data[i].equals(target)) return i;
        return -1;
    }

    public static void main(String[] args) {
        int[] dataSize = {1000000, 10000000};
        for (int n: dataSize) {
            Integer[] data = ArrayGenerator.generateOrderArray(n);
            long start = System.nanoTime();
            for (int i = 0; i < 100; i ++)
                LinearSearch.search(data, n);
            long end = System.nanoTime();
            double time = (end - start) / (1000000000.0);
            System.out.println("n = " + n + ", 100 runs : " + time + " s");
        }

        Student[] students = {new Student(1, "aa"),
                new Student(2, "bb"),
                new Student(3, "cc")};
        Student s = new Student(2, "bb");
        int res = LinearSearch.search(students, s);
        System.out.println(res);
        System.out.println(s);
    }

}
