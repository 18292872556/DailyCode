package Advanced.Day01_Object_API.first_Jun08;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/06/08/下午2:20
 * @Description:
 */
public class Student {
    int id;
    String name;
    int age;

    public Student(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(){

    }

    @Override
    public String toString(){
        return "Student{id=" + id + ", name='" + name + "\', age=" + age +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if ((null == o) || getClass() != o.getClass()) {
            return false;
        }
        if (this == o) {
            return true;
        }
        Student stu = (Student) o;
        return (id == stu.id) && (age == stu.age) && (Objects.equals(name, stu.name));
        //并且需要注意的是引用类型要使用equals比较，因为这里要求的是name相同，而不是要求是同一个对象
    }

}
