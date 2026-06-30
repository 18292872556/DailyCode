package Advanced.Day02_Collection_泛型.Review04_Jun30;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/06/30/下午5:21
 * @Description:
 */
public class Student {
    String name;
    int age;

    public Student(){
    }
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "Student{name=" + name + ", age=" + age + "}";
    }

}
