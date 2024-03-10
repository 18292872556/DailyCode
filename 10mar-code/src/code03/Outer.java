package code03;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/03/10/20:29
 * @Description:
 */
public class Outer {
    int num = 200;

    Outer(){
       ;
    }
    Outer(int num){
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    //外部方法访问内部成员
    void visit(){
        num = 300;
        System.out.println("外部类方法访问");
        Inner inner = new Inner();
        System.out.println(inner.num);
        inner.method();
    }
    void method(){
        System.out.println("外部类方法");
    }
    class Inner{
        String str;
        int num = 100;
        Inner(){
            ;
        }
        Inner(String str, int num){
            this.str = str;
            this.num = num;
        }
        void method(){
            System.out.println("成员内部类方法");
        }
        //内部方法访问外部类成员
        void visit(){
            System.out.println("内部类方法访问");
            System.out.println(Outer.this.num);
            method();//就近原则，优先调用成员内部类方法
            Outer.this.method();
        }

    }
}

