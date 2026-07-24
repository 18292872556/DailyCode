package Advanced.Day03_List_Set.Review04_Jul19;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/07/24/下午8:57
 * @Description:
 */
public class Puppy implements Comparator<Puppy>{
    int id;
    String name;
    int age;

    public Puppy(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    //优先年龄降序，其次id升序
    public int compare(Puppy p1, Puppy p2){
        return p2.age - p1.age == 0? p1.id - p2.id : p2.age - p1.age;
    }

    public String toString(){
        return "Puppy{id = " + id + ", name = " + name + ", age = " + age + '}';
    }

}
