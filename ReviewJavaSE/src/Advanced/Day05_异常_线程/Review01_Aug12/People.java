package Advanced.Day05_异常_线程.Review01_Aug12;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/12/下午6:19
 * @Description:
 */
public class People {
    int id;
    String name;
    int age;

    public People(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "People[id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
