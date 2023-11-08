package qxcto.code02extends.code02_2cover;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/11/08/22:16
 * @Description: P157~P158 这个包下做 继承.重写 的练习测试
 * 重写和重载的区别：
 * 重写（Override）方法名一样，参数列表一样
 * 重载（Overlood）方法名一样，参数列表不一样
 * 方法的覆盖重写的特点：创建的是子类对象，则优先用子类方法，new的是谁就用谁的方法。
 * 子类返回值范围 <= 父类的(父类对象 > 子类对象)
 * 子类修饰符权限 >= 父类(public > protected > default > private)default就是什么都不写，默认的权限
 */
public class TestCover {
    //?若方法的三要素不是全部相同，怎么算重名方法呢。重名方法名和参数列表要求都要相同
    //如果参数列表不同就是重载，方法名是一定相同的，如果不同就不算是相同方法

    public static void main(String[] args) {
        Father f = new Father();
        Son s = new Son();
        s.method();
        f.method();
    }
}
