package Advanced.Day02_Collection_泛型.Review06_Jul07;

import java.util.Comparator;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/07/13/下午11:31
 * @Description:
 */
public class PokerComparator implements Comparator<String> {
    private HashMap<String, Integer> map;
    public PokerComparator(HashMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public int compare(String o1, String o2) {
        //这里的this和o都是要比较的元素,
        return map.get(o1) - (map.get(o2));
    }
}
