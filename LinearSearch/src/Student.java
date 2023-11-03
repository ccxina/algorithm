import java.util.Objects;

public class Student {


    private final Integer number;
    private final String name;

    public Student(Integer number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!Objects.equals(number, student.number)) return false;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Student[] students = {new Student(1, "aa"),
                new Student(2, "bb"),
                new Student(3, "cc")};
        Student s = new Student(2, "bb");
        int res = LinearSearch.Search(students, s);
        System.out.println(res);
        System.out.println(s);
    }
}
