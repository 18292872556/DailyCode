package qxcto.day24.demo02;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/03/21:04
 * @Description: 调用Student，分析内存图
 */
public class Demo02Static {
    public static void main(String[] args) {
        Student.room = "大一一班";

        Student one = new Student("小刘", false, 20);
        System.out.println("one的姓名：" + one.getName());
        System.out.println("one的教室：" + Student.getRoom());
        System.out.println("one的年龄：" + one.getAge());
        System.out.println("one的学号：" + one.getId());
        System.out.println("============================");
        Student two = new Student("小李", true, 12);
        System.out.println("two的姓名：" + two.getName());
        System.out.println("two的教室：" + Student.getRoom());
        System.out.println("two的年龄：" + two.getAge());
        System.out.println("two的学号：" + two.getId());

        System.out.println("学生人数：" + Student.getIdCount());

    }

}
