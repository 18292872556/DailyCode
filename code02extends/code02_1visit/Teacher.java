package qxcto.code02extends.code02_1visit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/11/08/20:45
 * @Description: 讲师类
 */
public class Teacher extends Employee{
    int numT = 20;
    int num = 20;
    public void methodTeNum(){
        System.out.println("Teacher的num:" + num);
    }
    public byte method(){
        System.out.println("方法public void method()，这是一个教师类");
        return 1;
    }
    public void method(int num){
        System.out.println("public void method(int num)，这是一个教师类");
    }

}
