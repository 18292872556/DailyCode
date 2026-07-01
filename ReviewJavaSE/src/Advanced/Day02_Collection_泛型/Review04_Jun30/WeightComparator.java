package Advanced.Day02_Collection_泛型.Review04_Jun30;

import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/07/01/下午3:33
 * @Description:
 */
public class WeightComparator<E> implements Comparator<E> {
    List<String> weightList;
    public WeightComparator(List<String> weight){
        this.weightList = weight;
    }
    @Override
    public int compare(E o1, E o2){
        //升序排序
        return weightList.indexOf(o1) - weightList.indexOf(o2);
        //回忆返回负数对应的排序顺序是o1,o2
    }

//    @Override
//    public int compare(E o1, E o2) {
//        return 0;
//    }
}
