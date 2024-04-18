import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/01/19/23:13
 * @Description: ArrayList练习
 */
public class Demo01 {
    public static void main(String[] args) {

        ArrayList<Integer> intList1 = new ArrayList<>();
        //泛型只能是引用类型，不能是基本类型，因为集合存的地址
        intList1.add(23);
        intList1.add(342);
        intList1.add(56);
        intList1.add(23);
        intList1.add(23);
        System.out.println(intList1);
        System.out.println(intList1.get(2));
        System.out.println(intList1.get(0));
        intList1.remove(2);
        System.out.println(intList1);
        System.out.println(intList1.size());



    }
}
