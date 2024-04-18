package qxcto.day24.demo02;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/03/19:32
 * @Description: static修饰学号，统计学生数量
 */
public class Student {
    //为什么定义两个，因为id属于学生的属性，属于对象，每个对象不一样。但idCount属于属于类
    //每次new该类对象才自增，不保存加过的数
    private static int idCount = 0;
    private int id = 0;
    static String room = "一年级一班";
    String name;
    boolean girl;
    int age;

    public Student(String name, boolean girl, int age) {
        this.id = ++idCount;
        this.name = name;
        this.girl = girl;
        this.age = age;
    }
    public Student(){
        this.id = ++idCount;
    }
    public void showInfo(){
        System.out.println("学生学号：" + this.id + " 姓名：" + this.name + " 是否女孩：" + this.girl + " 年龄：" + this.age);
    }

    public static void setRoom(String room) {
        Student.room = room;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGirl(boolean girl) {
        this.girl = girl;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getIdCount() {
        return idCount;
    }

    public int getId() {
        return id;
    }

    public static String getRoom() {
        return room;
    }

    public String getName() {
        return name;
    }

    public boolean isGirl() {
        return girl;
    }

    public int getAge() {
        return age;
    }

}
