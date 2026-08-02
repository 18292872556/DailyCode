package Advanced.Day03_List_Set.Review05_Aug01;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/02/下午8:20
 * @Description:
 */
public class Student17 implements Comparable<Student17>{
    private String name;
    private int age;
    public Student17(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student17 o) {
        return this.age - o.age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return "Student17{Name: " + name + " Age: " + age + '}';
    }

}
