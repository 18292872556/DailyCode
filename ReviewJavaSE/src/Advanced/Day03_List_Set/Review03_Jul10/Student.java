package Advanced.Day03_List_Set.Review03_Jul10;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/07/11/下午8:03
 * @Description:
 * id 姓名
 * id升序，自然排序
 */
public class Student implements Comparable<Student>{
    String name;
    int id;

    public  Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString(){
        return "Student [name=" + name + ", id=" + id + "]";
    }



    @Override
    public int compareTo(Student o){
        return this.id - o.id;
    }




}
