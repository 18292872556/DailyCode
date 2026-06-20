package Advanced.Day03_List_Set.second_Jun20;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/06/20/下午9:29
 * @Description:
 */
public class Puppy implements Comparator<Puppy> {
    String name;
    String master;

    public Puppy(String name, String master) {
        this.name = name;
        this.master = master;
    }
    public Puppy() {}

    @Override
    public String toString() {
        return "Puppy{name=" + name + ",master=" +master +"}";
    }

    @Override
    public int compare(Puppy o1, Puppy o2) {
        return o1.name.equals(o2.name) ? o1.master.compareTo(o2.master) :
                o2.name.compareTo(o1.name);
    }
}
