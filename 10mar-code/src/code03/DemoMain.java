package code03;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/03/10/18:53
 * @Description:
 */
public class DemoMain {
    public static void main(String[] args) {
        /*3. 在外部类访问成员内部类成员，在内部类访问外部类成员。*/
        Outer out = new Outer();
        out.visit();
        Outer.Inner inner = new Outer().new Inner();
        inner.visit();

    }
}
