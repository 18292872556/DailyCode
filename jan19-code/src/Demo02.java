import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/01/19/23:30
 * @Description:
 */
public class Demo02 {
    public static void main(String[] args) {
        //生成6个1~33之间的随机整数，添加到集合，并遍历
        ArrayList<Integer> intList1 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Random r = new Random();
            int num = r.nextInt(33) + 1;

            intList1.add(num);
            System.out.printf(num + ",");
        }


    }
}
