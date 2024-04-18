package code01;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/02/15/14:33
 * @Description: 这个包下，测试发红包（均等）案例
 */
public class MainTest {
    public static void main(String[] args) {
        //System.out.println("请依次输入，群主，成员1");
        Leader l1 = new Leader(3456);
        Member m1 = new Member(0);
        Member m2 = new Member(0);
        Member m3 = new Member(0);
        ArrayList<Double> redList = l1.send(3, 67.89);
        m1.receive(redList);
        m2.receive(redList);
        m3.receive(redList);

        l1.show();
        m1.show();
        m2.show();
        m3.show();

    }
}
