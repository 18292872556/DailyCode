package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/04/07/18:57
 * @Description:
 */
public class MainTest {
    public static void main(String[] args) {
        // 1.成员变量中使用自定义类对象并输出信息。（注意输出对象的名字等）
        //2. 接口类型做为成员变量，注意其中的Setter（4种传参方式都可以）
        // 传入为实现类，匿名实现类，匿名内部类，或匿名内部类匿名对象都可以。
        Business thing1 = new Business("无业游民", 0, 0);
        Business thing2 = new Business("程序员", 20000, 10);
        //第3个参数自定义类，第4个参数，匿名实现类
        Person p1 = new Person("ken", false, thing1, new Zi());
        Zi object1 = new Zi();
        //第4个参数，实现类
        Person p2 = new Person("barbie", true, thing2, object1);
        Fu object2 = new Fu(){
            @Override
            public void method() {
                System.out.println("p3匿名内部类实现接口方法");
            }
        };
        //第4个参数，匿名内部类（指接口的实现类匿名，但生成的对象有名）
        Person p3 = new Person("barbie", true, thing2, object2);
        //第4个参数，匿名对象匿名内部类
        Person p4 = new Person("barbie", true, thing2, new Fu(){
            @Override
            public void method() {
                System.out.println("p4匿名对象匿名内部类实现接口方法");
            }
        });


        p1.show();
        p2.show();
        p3.show();
        p4.show();

        //3. 接口做为方法的参数和返回值（复习多态的作用）
        p1.method01(new Zi());
        p2.method01(new Fu(){
            @Override
            public void method() {
                System.out.println("匿名内部类作为匿名实现类");
            }
        });

        Fu obj2 = p1.method02();//多态写法，相当于向上转型
        //Zi obj3 = p1.method02();错在方法返回值返回的是多态的，看似是Fu,其实是Zi。名称还是Fu的
        //对于变量，编译看左，运行还看左。相当于。Fu xx= new Zi() , Zi obj3 = xx。
        Zi obj3 = (Zi)p2.method02();//强转，相当于还原

    }
}
