package common;

import java.util.Objects;

public class Student implements Comparable<Student>{

    private final Integer score;
    private final String name;

    public Student(Integer score, String name) {
        this.score = score;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!Objects.equals(score, student.score)) return false;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        int result = score != null ? score.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "common.Student{" +
                "score=" + score +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student another) {
//        if (this.score < another.score) return -1;
//        else if (this.score.equals(another.score)) return 0;
//        else return 0;
        return this.score - another.score;
    }
}
