package Advanced.Day03_List_Set.Review03_Jul10;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/07/12/下午5:36
 * @Description:
 * 在自定义类中继承重写，要求Puppy类属性有id，姓名，年龄。
 * 用年龄降序排序，
 *     // 年龄相等的情况下用id升序。
 */
public class Puppy implements Comparator<Puppy> {
    int id;
    String name;
    int age;

    public Puppy(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public Puppy() {

    }

    @Override
    public int compare(Puppy p1, Puppy p2) {
        /*疑问？需要判空吗，会传入空吗？而且有一个问题是，如果有空就没法比大小
        * 思考： 应该不会有空，因为排序规则只应用于集合，要看集合允不允许元素为null*/
        return (p2.age - p1.age) == 0 ? p1.id - p2.id : p2.age - p1.age;

    }


    @Override
    public String toString() {
        return "Puppy{ id=" + id + ", name=" + name + ", age=" + age + '}';
    }
}
