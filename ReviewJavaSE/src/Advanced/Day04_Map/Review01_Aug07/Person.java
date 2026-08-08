package Advanced.Day04_Map.Review01_Aug07;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/08/下午6:33
 * @Description:
 */
public class Person {
    int id;
    String name;
    int age;
    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "Person{ id: " + id + ", name: " + name + ", age: " + age + " }";
    }
}
