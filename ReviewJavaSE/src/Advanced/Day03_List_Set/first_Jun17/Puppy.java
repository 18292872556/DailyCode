package Advanced.Day03_List_Set.first_Jun17;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/06/17/下午8:50
 * @Description:
 */
public class Puppy {
    int id;
    String name;

    public Puppy(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Puppy(){}

    public String toString(){
        return "Puppy{" + "id=" + id + ", name=" + name + '}';
    }
}
