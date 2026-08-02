package Advanced.Day03_List_Set.Review05_Aug01;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/02/下午5:21
 * @Description:
 */
public class Student09 {
    //使姓名和年龄相同的对象认为重复
    String name;
    int age;

    public Student09(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Student09 stu = (Student09)o;
        return (this.name.equals(stu.name)) && (this.age == stu.age);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, age);
    }

    @Override
    public String toString(){
        return "Student09{" + "name=" + name + ", age=" + age + '}';
    }
}
