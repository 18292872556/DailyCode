package qxcto.day04.demo2;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/09/28/16:56
 * @Description: 对象数组
 * 要求定义一个数组，用来存3个Person对象
 */
public class Demo1ObjectArray {
    public static void main(String[] args) {
        Person[] array = new Person[3];
        
        Person p1 = new Person("barbie","女",true);
        Person p2 = new Person("ken","男",false);
        Person p3 = new Person("雪","女",true);
        
        array[0] = p3;
        array[1] = p1;
        array[2] = p2;

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getName() + array[i].getSex() + array[i].isPower());
        }
    }


}
