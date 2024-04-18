package qxcto.day02.demo2;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/09/26/20:46
 * @Description: 匿名对象
 */
public class Demo1Anonymous {

    public static void main(String[] args) {

        Person one = new Person();
        one.name = "芭比";
        new Person().name = "肯";
        one.showName();//我叫null
        new Person().showName();//我叫芭比

    }
}
