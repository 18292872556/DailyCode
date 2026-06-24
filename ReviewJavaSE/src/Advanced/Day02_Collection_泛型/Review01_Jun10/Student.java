package Advanced.Day02_Collection_泛型.Review01_Jun10;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/06/10/下午6:42
 * @Description:
 */
public class Student {
    //     * 题目 2：迭代器遍历与泛型结合
    //     * 要求：
    //     * 定义一个自定义类（比如 Student，包含 name、age 属性）；
    //     * 创建一个存储 Student 对象的 Collection 集合，添加 3 个 Student 实例；
    //     * 使用 Iterator 迭代器遍历集合，打印每个 Student 的信息；
    //     * 要求全程使用泛型，避免类型转换异常。
    String name;
    int age;

    Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    Student(){

    }

    @Override
    public String toString(){
        return "Student{ name = " + name + ",age = " + age + "}";
    }
}
