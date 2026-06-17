package Advanced.Day03_List_Set.first_Jun17;

import java.util.*;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/06/17/下午7:42
 * @Description:
 */
public class Day03_Test {
    public static void main(String[] args) {
        //自定义Student类，以属性id决定大小，实现自然排序
        //让自定义类继承Comparable接口，并在其中重写方法
        //1使用，TreeMap会自动调用并排好序
//        Student stu1 = new Student(80, "barbie", 30);
//        Student stu3 = new Student(18, "", 1);
//        Student stu2 = new Student(02, "ken", 18);
//
//        TreeMap<Student, Integer> map1 = new TreeMap<>();
//        map1.put(stu1, 1);
//        map1.put(stu2, 1);
//        map1.put(stu3, 1);
//        System.out.println(map1);
//
//
//        //? 2猜测直接用普通的List呢？用Collections.sort(list<stu>)排序是可以的吗？
//
//        List<Student> list1 = new ArrayList<>();
//        list1.add(stu1);
//        list1.add(stu2);
//        list1.add(stu3);
//
//        Collections.sort(list1);
//        System.out.println(list1);
//
//        //MyData类，以属性data决定大小降序排序，实现比较器
//        List<MyData> list2 = new ArrayList<>();
//        MyData d1 = new MyData(14, "");
//        MyData d2 = new MyData(89, "123#$!");
//        MyData d3 = new MyData(-5, "23!@");
//        MyData d4 = new MyData(290, "");
//        list2.add(d1);
//        list2.add(d2);
//        list2.add(d3);
//        list2.add(d4);
//        Collections.sort(list2, d1);//这里第二个参数随便填一个实现了比较器的该类的任意对象
//        System.out.println(list2);

        //用法2-new存储该类的集合时（比如TreeSet)，匿名比较器重写排序方法
        //定义普通类小狗，有编号和名字，按编号排序
        TreeSet<Puppy> tree1 = new TreeSet<>(new Comparator<Puppy>() {
            @Override
            public int compare(Puppy o1, Puppy o2) {
                return o1.id - o2.id;
            }
        });
        Puppy p1 = new Puppy(10, "边牧");
        Puppy p2 = new Puppy(20, "萨摩耶");
        Puppy p3 = new Puppy(3, "西高地");
        Puppy p4 = new Puppy();
        tree1.addAll(Arrays.asList(p1, p2, p3, p4));

        System.out.println(tree1);


        //new TreeMap的时候传比较器，主要传key的比较器，因为是根据key来排序比较的
        TreeMap<Puppy, String> map1 = new TreeMap<>(new Comparator<Puppy>() {
            @Override
            public int compare(Puppy o1, Puppy o2) {
                return o2.id - o1.id;
            }
        });
        map1.put(p1, "1");
        map1.put(p2, "231");
        map1.put(p3, "1");
        map1.put(p4, "321");
        System.out.println(map1);

    }
}
