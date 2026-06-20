package Advanced.Day03_List_Set.second_Jun20;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/06/20/下午9:24
 * @Description:
 */
public class Student implements Comparable<Student>{
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Student() {}

    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }

    @Override
    public String toString(){
        return "Student{id=" + id + ",name=" + name + "}";
    }

}
