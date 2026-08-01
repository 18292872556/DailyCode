package Advanced.Day03_List_Set.Review05_Aug01;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/01/下午10:41
 * @Description:
 */
public class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "Student{Name: " + name + " Age: " + age + "}";
    }
}
