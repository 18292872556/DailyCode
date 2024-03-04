package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/03/04/21:28
 * @Description:
 */
public class MyAnother {
    public void test(){
        System.out.println("子类访问方法");
        MyClass c1 = new MyClass();
        System.out.println(c1.num);
        c1.method();
    }

}
