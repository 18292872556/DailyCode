package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/01/16/23:12
* @Description: 对象数组
 */
public class Demo01 {
    public static void main(String[] args) {
        /* 要求定义一个数组，用来存3个Person对象
        默认值为null,分别创建Person对象入数组*/
        Person[] arr1 = new Person[3];
        Person p1 = new Person("barbie", "女", 100);
        Person p2 = new Person();
        Person p3 = new Person("ken", "男", 30);

        arr1[0] = p1;
        arr1[1] = p2;
        arr1[2] = p3;

        System.out.println(arr1[0].getName());
        System.out.println(arr1[2].getAge());


    }
}
