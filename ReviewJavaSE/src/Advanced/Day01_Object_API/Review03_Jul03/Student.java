package Advanced.Day01_Object_API.Review03_Jul03;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/07/03/下午2:48
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
    public Student(){}

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Student{id= " + id + ", name= \'" + name + "\', age= " + age + "}";
    }
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Student stu = (Student)o;
        return id == stu.id && name.equals(stu.name) && age == stu.age;
    }


}
