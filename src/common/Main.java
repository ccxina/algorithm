package common;


public class Main {

    public static void main(String[] args) {

        Array<Integer> array = new Array<>(10);
        for (int i = 0; i < 10; i++) {
            array.addLast(1);
        }
        System.out.println(array);
        array.add(1, 100);

        System.out.println(array);
        array.remove(2);
        array.removeElement(1);
        System.out.println(array);
        array.removeAllElement(1);
        System.out.println(array);


        Array<Student> studentArray = new Array<>();
        studentArray.addLast(new Student(1, "aa"));
        studentArray.addLast(new Student(1, "aa"));
        studentArray.addLast(new Student(1, "aa"));
        System.out.println(studentArray);

    }

}
