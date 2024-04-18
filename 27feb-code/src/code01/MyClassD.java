package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/02/25/7:50
 * @Description:
 */
public class MyClassD extends MyClassC implements MyInterA, MyInterB{
//    @Override
//    public Double abMethod1() {
//        return null;
//    }
    /*复习：虽然该抽象方法，A接口返回值为Object,B接口返回值为Float,
    重写时子类方法返回值 <= 父类返回值即可*/
    @Override
    public Float abMethod1() {
        System.out.println("类D重写的抽象方法1");
        return null;
    }


    @Override
    public Integer abMethod2() {
        System.out.println("类D重写的抽象方法2");
        return null;
    }
    public void deMethod1(){
        System.out.println("默认方法1，接口A，B默认方法和类C方法重名，所以需要实现类D重写一次");
        System.out.println("但实际上A,B默认方法都无法调用到，只能super调用父类C的该名称方法");

        super.deMethod1();
    }

}
