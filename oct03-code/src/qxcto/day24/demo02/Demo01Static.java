package qxcto.day24.demo02;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/03/19:14
 * @Description:
 */
public class Demo01Static {
    public static void main(String[] args) {
        Student stu1 = new Student("barbie",true,18);
        Student stu2 = new Student();
        Student stu3 = new Student("奥罗拉",true,16);
        Student stu4 = new Student("菲利普",false, 17);
        stu3.showInfo();
        stu2.showInfo();
        stu4.showInfo();

        MyClass obj = new MyClass();
        obj.method();

        obj.methodStatic();//不推荐，会误以为是普通成员方法
        MyClass.methodStatic();
    }
}
