package qxcto.code02extends.code02_1visit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/11/08/20:40
 * @Description: 作为父类
 */
public class Employee {
    int numE = 10;
    int num = 10;
    public byte method(){
        System.out.println("方法public void method()，这是一个员工类");
        return 1;
    }
    public void methodEmNum(){
        System.out.println("Employee的num:" + num);
    }
}
