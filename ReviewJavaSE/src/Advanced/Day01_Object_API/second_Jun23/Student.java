package Advanced.Day01_Object_API.second_Jun23;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/06/23/下午2:20
 * @Description:
 */
public class Student {
    int id;
    String name;
    int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public Student(){

    }

    @Override
    public String toString(){
        return "Student{id=" + id + ",name= \'" + name + "\',age=" + age + "}";
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;

        }
        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        Student stu = (Student)obj;
        return this.id == stu.id && this.age == stu.age && this.name.equals(stu.name);
    }
}
