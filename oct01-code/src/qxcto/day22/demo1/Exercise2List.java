package qxcto.day22.demo1;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/01/15:21
 * @Description: 自定义4个学生对象，添加到集合，并遍历
 */
public class Exercise2List {
    public static void main(String[] args) {
        Student stu1 = new Student("barbie",true,"研二");
        Student stu2 = new Student("ken",false,"大一");
        Student stu3 = new Student("小明",true,"一年级");
        Student stu4 = new Student("小李",false,"幼儿园");

        ArrayList<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        list.add(stu4);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).name);
        }
    }







}
