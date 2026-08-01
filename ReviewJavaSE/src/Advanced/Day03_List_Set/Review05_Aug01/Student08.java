package Advanced.Day03_List_Set.Review05_Aug01;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/01/下午11:41
 * @Description: 要求元素不可重复，就是要重写hashcode和equals
 */
public class Student08 {
    String name;
    int age;

    public Student08(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(this.getClass() != o.getClass() || o == null){
            return false;
        }
        Student08 student08 = (Student08) o;
        return this.name.equals(student08.name) && this.age == student08.age;
    }
    public int hashcode(){
        return Objects.hash(name,age);
    }

    public String toString(){
        return "Student08{ name: " + name + ", age: " + age + " }";
    }
}
