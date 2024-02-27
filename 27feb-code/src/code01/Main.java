package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/02/25/7:51
 * @Description:
 * 1. 写一个实现类D 实现两个接口A,B，继承一个父类C
 * 接口A写所有可能内容（5种）的完整写法
 * 接口B写所有可有内容的省略写法
 * 其中A,B 中1常量名重复，1抽象方法重复，1抽象方法只方法名相同，1私有方法重复，A,B,C 1默认方法重复,1静态方法重复。（分析哪些不能实现及原因）
 */
public class Main {
    public static void main(String[] args) {
        MyClassD d1 = new MyClassD();
        System.out.println("因为接口中常量都为static,所以类名或实现类对象调用都可以。但在父接口常量重名时，不可用实现类对象调用，因为混淆");
        System.out.println(MyInterA.NUM);
        System.out.println(MyInterB.NUM);
        System.out.println(d1.BNUM);

        d1.abMethod1();
        d1.abMethod2();
        /*默认方法1，ABC中重名，优先使用父类C的，但是接口A，B中也重名，需要在实现类D中重写*/
        d1.deMethod1();
        /*默认方法2 ，BC中重名，优先用父类C的，D中不用重写。直接用*/
        d1.deMethod2();

        /*静态方法用类名or接口名调用*/
        System.out.println("======================");
        MyInterA.stMethod1();
        MyInterB.stMethod2();
        MyClassC.stMethod1();
    }
}
