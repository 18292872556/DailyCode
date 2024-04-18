package code01;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/04/09/9:50
 * @Description:
 */
public class Outer {
    int num = 10;
    void method(){
        System.out.println("外部类方法");
    }
    void useInner(){
        System.out.println("间接访问内部类极其成员");
        Inner inner = new Inner();
        System.out.println(inner.num);
        inner.method();
    }
    void visit(){
        System.out.println("外部类visit----------------");
        int num = 30;
        System.out.println(num);//30
        System.out.println(this.num);//10
        System.out.println(new Inner().num);//20
    }
    void localInner(){
        class Inner{
            int num = 50;
            void method(){
                System.out.println("局部内部类");
            }
            void visit(){//只能在localInner方法中访问这个方法
                System.out.println("局部内部类的visit----------------");
                int num = 60;
                System.out.println(num);//60
                System.out.println(this.num);//50
                System.out.println(Outer.this.num);//10
            }
        }
        System.out.println("含有局部内部类的方法的visit-------------");
        Inner inner = new Inner();//就近原则，此处访问的是自己方法中的局部内部类。
        // 如果没有这个重名的局部内部类，也不会报错会访问成员内部类
        int num = 70;//如果没有这句，下一句也不会报错，会访问外部类的成员变量num
        System.out.println(num);//? 输出的是哪个num,70
        System.out.println(inner.num);//50
        System.out.println(Outer.this.num);//10
        /*判断这里的this,因为是外部类方法，不在局部内当中，所以this指的还是外部类对象*/
        System.out.println(this.num);//10
        inner.method();
        inner.visit();

    }
    public class Inner{
        int num = 20;
        void method(){
            System.out.println("内部类方法");
        }
        void visit(){
            System.out.println("成员内部类visit-----------");
            int num = 40;
            System.out.println(num);//40
            System.out.println(this.num);//20
            System.out.println(Outer.this.num);//10
        }
    }
}
