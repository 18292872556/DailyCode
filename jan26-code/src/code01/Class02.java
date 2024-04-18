package code01;
import static code01.Class01.*;
/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/01/26/14:51
 * @Description: 非静态方法
 */
public class Class02 {
    static int num3;

    int num4;
    public static void stc2Method1(){
        System.out.println("Class02的静态方法1 成功执行");
    }
    public static void  stc2Method2(){
        System.out.println("Class02的静态方法2 成功执行");

    }
    public void c2Method1(){
        System.out.println("--------Class02的方法1 成功执行--------");
        Class01 c1 = new Class01();

        Class01.num1 = 50;// ● 外部静态用类名
        c1.num2 = 60;//  ● 外部非静态用对象名

        num3 = 70;// ● 内部静态或非静态都是直接调用
        num4 = 80;
        this.num3 = 90;// ● 当然非要写类名或者对象名调用也可以，只是多余
        Class02.num3 = 100;
        this.num4 = 110;

        System.out.println("Class01的num1,num2:" + Class01.num1 + ", " + c1.num2);
        System.out.println("Class02的num3,num4:" + num3 + "," + num4);

        stc2Method2();//同上，内部静态
        c2Method2();//同上，内部非静态,，只要是内部统统直接调

        Class01.stc1Method2();//同上，外部类静态
        c1.c1Method2();//同上，外部非静态
        System.out.println("-------------------------------------");


    }
    public void c2Method2(){
        System.out.println("Class02的方法2 成功执行");

    }


}
