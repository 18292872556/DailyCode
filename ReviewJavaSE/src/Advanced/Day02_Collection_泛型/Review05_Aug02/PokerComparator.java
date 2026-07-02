package Advanced.Day02_Collection_泛型.Review05_Aug02;

import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/07/02/下午9:03
 * @Description:
 */
public class PokerComparator<E> implements Comparator<E> {
    /*为什么Comparator也要写<E>因为Comparator的方法参数有用到E*/
    List<E> weight;
    //因为这里是要用到权重的集合weight,所以只写一种有参构造，要求必须传入这些牌由小到大顺序的集合
    public PokerComparator(List<E> weight){
        this.weight = weight;
    }

    @Override
    public int compare(E o1, E o2){
        return weight.indexOf(o2) - weight.indexOf(o1);
    }

}
