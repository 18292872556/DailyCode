package qxcto.code02extends.code02_4super;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/11/08/23:24
 * @Description: P161~P164
 * 关于子类父类间的构造方法，this和super关键字……
 * 只有子类构造器才能调用父类的构造器，且必须在第一句。
 * 如果不写，则子类的构造器第一句隐含赠送super()，也可以调用自己其他的构造器this()之类的
 * 也是只有一句，必须在构造方法内的第一句，也是唯一一句。
 * 若A->B->C->D继承关系，则new D时，会依次执行A,B,C,D的构造方法，
 * 因为自己的构造方法内第一句不写的话赠送super()。而且是先执行调用的父类构造器再执行本类构造方法中其他句
 * 1.单继承，即最多一个父类
 * 2.多级继承，即A->B->C->D
 * 3.一个子类的直接父类是唯一的，但是一个父类可以拥有很多个子类
 */
public class TestSuper {
    public static void main(String[] args) {
        Son s1 = new Son();
        Son s2 = new Son("张三");
        Father f1 = new Father();
        System.out.println("-----------------");
        GrandSon g1 = new GrandSon();
        System.out.println("-----------------");
        GreatGrandSon gg1 = new GreatGrandSon();



    }

}
