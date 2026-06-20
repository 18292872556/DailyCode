package Advanced.Day03_List_Set.second_Jun20;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/06/20/下午9:59
 * @Description:
 */
public class People {
    int id;
    String name;

    public People(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public People(){}

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
