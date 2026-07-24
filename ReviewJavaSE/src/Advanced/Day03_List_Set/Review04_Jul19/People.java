package Advanced.Day03_List_Set.Review04_Jul19;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/07/24/下午9:23
 * @Description:
 */
public class People {
    int id;
    String name;

    public People(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString(){
        return "ID: " + id + " Name: " + name;
    }
}
