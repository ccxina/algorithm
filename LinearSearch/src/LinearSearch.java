public class LinearSearch {

    private LinearSearch() {}

    public static <E> int Search(E[] data, E target) {
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
                LinearSearch.Search(data, n);
            long end = System.nanoTime();
            double time = (end - start) / (1000000000.0);
            System.out.println("n = " + n + ", 100 runs : " + time + " s");
        }
    }

}
