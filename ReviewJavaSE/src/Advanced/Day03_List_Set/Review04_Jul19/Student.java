package Advanced.Day03_List_Set.Review04_Jul19;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/07/24/下午8:33
 * @Description:
 */
public class Student implements Comparator<Student> {
    int id;
    String name;
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int compare(Student s1, Student s2) {
        return s1.id - s2.id;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + "]";
    }
}
