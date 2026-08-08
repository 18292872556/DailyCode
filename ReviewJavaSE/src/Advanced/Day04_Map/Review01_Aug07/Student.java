package Advanced.Day04_Map.Review01_Aug07;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/08/下午4:29
 * @Description:
 * 根据姓名和年龄判断学生是否相同，重写hashCode和equals。
 */
public class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Student student = (Student) obj;
        //return name.equals(student.name) && age == student.age;
        //考虑name为null的情况是否有可能，验证后发现是可以的。所以修改不这样写
        return Objects.equals(name, student.name);
    }

    public int hashCode(){
        return Objects.hash(name, age);
    }
    @Override
    public String toString() {
        return "Student{name='" + name + '\'' + ", age=" + age + '}';
    }
}
