package code01_reviewJava6;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xuexuezi
 * @Date: 2024/04/17/21:06
 * @Description:
 */
public class Demo02 {
    int num = 10;
    void method(){
        int num = 20;
        //访问三个num
        System.out.println("外部类Demo02方法method:");
        System.out.println("方法内num:" + num + "所在外部类num:" + this.num + "成员内部类num:" + new Inner().num);
        System.out.println("局部内部类num：只能调用所在方法partInner()，方法里怎么输出，会输出其他的，不能直接调用。/n 成员内部类要简介调用也可以写一个方法调用，只调用那个方法即可");
        partInner();
    }

    //成员内部类
    class Inner{
        int num = 30;
        void method(){
            int num = 40;
            System.out.println("成员内部类Inner方法method:");
            System.out.println("方法内num:" + num + "所在内部类num:" + this.num + "外部类num:" + Demo02.this.num);
            System.out.println("成员内部类想要访问外部类的局部内部类，也是直接调用partInner。注意！跟自己内部成员不重名的情况下，成员内部类可以直接访问外部类所有成员/n 重名情况，要访问外部类成员加外部类名.this调用");
            partInner();
        }

    }
    //局部内部类及所在方法
    void partInner(){
        class PartInner{
            int num = 50;
            void method(){
                int num = 60;
                System.out.println("局部内部类PartInner方法method:");
                System.out.println("方法内num:" + num + "所在局部内部类num:" + this.num + "外部类num:" + Demo02.this.num + "成员内部类num:" + new Inner().num);

            }
        }
        System.out.println("partInner方法，调用局部内部类PartInner的method：--------------------------");
        PartInner partObj = new PartInner();
        //partInner方法也属于外部类方法，除了能访问局部内部类PartInner之外，
        // 其他访问方式和外部类Demo02的方法method一样
        partObj.method();
        System.out.println("-----------------------------");


    }
}
