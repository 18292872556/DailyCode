package Advanced.Day03_List_Set.Review03_Aug10;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/07/12/下午11:16
 * @Description:
 */
public class People {
    int id;
    String name;

    public People(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{id=" + id + ", name=" + name + '}';
    }
}
