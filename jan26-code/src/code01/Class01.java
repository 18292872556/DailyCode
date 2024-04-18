package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/01/26/14:47
 * @Description: 静态方法调用
 */
public class Class01 {
    static int num1;
    int num2;
    public static void stc1Method1(){
        System.out.println("------Class01的静态方法1 成功执行------");

        Class01 c1 = new Class01();
        Class02 c2 = new Class02();
        num1 = 10;// ● 内部静态直接使用
        c1.num2 = 20;//  ● 哪怕是本类的变量，但只要是非静态在静态方法中调用就必须用对象名才可以
        Class02.num3 = 30;// ● 外部静态，用外部类名
        c2.num4 = 40;// ● 外部非静态，用外部类的对象名

        System.out.println("Class01的num1,num2:" + num1 + ", " + c1.num2);
        System.out.println("Class02的num3,num4:" + Class02.num3 + "," + c2.num4);

        stc1Method2();//同上，内部静态
        c1.c1Method1();//同上，内部非静态

        Class02.stc2Method2();//同上，外部类静态
        //stc2Method2();//因为这里静态导入了外部类，所以也可以直接方法名使用外部静态。
        c2.c2Method2();//同上，外部非静态
        System.out.println("-----------------------");

    }
    public static void stc1Method2(){
        System.out.println("Class01的静态方法2 成功执行");

    }
    public void c1Method1(){
        System.out.println("Class01的方法1 成功执行");

    }
    public void c1Method2(){
        System.out.println("Class01的方法2 成功执行");

    }
}
