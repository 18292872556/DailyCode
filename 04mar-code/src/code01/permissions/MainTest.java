package code01.permissions;

import code01.MyClass;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/03/04/21:29
 * @Description:
 */
public class MainTest {
    public static void main(String[] args) {
        MyClass c1 = new MyClass();
        c1.method();
        System.out.println(c1.num);
    }
}
