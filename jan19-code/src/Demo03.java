import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/01/19/23:38
 * @Description:
 */
public class Demo03 {
    public static void main(String[] args) {
        //自定义4个学生对象，添加到集合，并遍历
        Student stu1 = new Student("学生1", 23, "女");
        Student stu2 = new Student("学生2", 45, "女");
        Student stu3 = new Student("学生3", 27, "女");
        Student stu4 = new Student("学生4", 80, "男");

        ArrayList<Student> list1 = new ArrayList<>();
        list1.add(stu1);
        list1.add(stu2);
        list1.add(stu3);
        list1.add(stu4);

        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i).getName());
        }

    }
}
