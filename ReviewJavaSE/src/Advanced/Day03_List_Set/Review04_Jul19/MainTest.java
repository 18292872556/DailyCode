package Advanced.Day03_List_Set.Review04_Jul19;

import java.util.*;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/07/19/下午10:38
 * @Description:
 */
public class MainTest {
//    int id;
//    public People(int id) {
//        this.id = id;
//    }
//    public People(){
//    }
    private static void demo01(){
        //复习自然排序的接口的2用法和比较器的3种
        //首先有一些引用对象是内部有排序规则的，比如String,自动调用集合内元素排序规则的
        // 方法主要是TreeSet,TreeMap，和Collections.sort(List<?> list)
        //问题1：使用自然排序中的方法，比较所有包装类型大小，并考虑参数的可用类型
        /* ""做参数装箱时，不会检查类型是否正确*/
        System.out.println(Integer.valueOf(12).compareTo(Integer.valueOf("12")));
        System.out.println(Integer.valueOf(12).compareTo(13));

        System.out.println(Byte.valueOf((byte)14).compareTo(Byte.valueOf("14")));
        System.out.println(Byte.valueOf((byte)12).compareTo((byte)14));

        System.out.println(Short.valueOf((short)12).compareTo(Short.valueOf("12")));
        System.out.println(Short.valueOf((short)13).compareTo((short)15));

        System.out.println(Long.valueOf(12).compareTo(Long.valueOf("12")));
        System.out.println(Long.valueOf(14).compareTo(15L));

        System.out.println(Double.valueOf(12.21).compareTo(Double.valueOf("12.21")));
        System.out.println(Double.valueOf(13.1).compareTo(14.1));

        System.out.println(Float.valueOf(12.1F).compareTo(Float.valueOf("12.3")));
        System.out.println(Float.valueOf(13.4F).compareTo(13.4F));

        System.out.println(Boolean.valueOf(true).compareTo(Boolean.valueOf("true")));
        System.out.println(Boolean.valueOf(false).compareTo(false));

        System.out.println("a".compareTo("b"));
        System.out.println(Character.valueOf('c').compareTo('d'));
    }
    //问题2：给自定义类继承重写自然排序，要求自定义Student类属性有id，姓名，用id升序排序
    //并且用TreeSet和Collections.sort()检查排序结果
    private static void demo02(){
        Student stu1 = new Student(1, "Barbie");
        Student stu2 = new Student(3, "Bob");
        Student stu3 = new Student(2, "Carl");

        TreeSet<Student> set = new TreeSet<>(stu1);
        set.add(stu1);
        set.add(stu2);
        set.add(stu3);
        System.out.println("TreeSet: " + set);

        List<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        System.out.println("排序前的List:" + list);
        Collections.sort(list, stu1);
        System.out.println("排序后的List,Student以id升序:" + list);
    }
    //比较器排序
    //问题1：在自定义类中继承重写，要求Puppy类属性有id，姓名，和年龄。用年龄降序排序，
    // 年龄相等的情况下用id升序。
    private static void demo03(){
        Puppy p1 = new Puppy(3, "边牧", 1);
        Puppy p2 = new Puppy(1, "柯基", 4);
        Puppy p3 = new Puppy(3, "萨摩耶", 12);
        Puppy p4 = new Puppy(1, "西高地", 12);
        List<Puppy> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        Collections.sort(list, p1);
        System.out.println("Puppu集合年龄降序，再id升序为：" + list);

    }
    //问题3：在TreeSet,Map和Collections.sort()创建时传入匿名的比较器实现类
    private static void demo04(){
        //id降序
        People p1 = new People(4, "人1");
        People p2 = new People(1, "人2");
        People p3 = new People(3, "人3");
        People p4 = new People(2, "人4");
        TreeSet<People> set = new TreeSet<>(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o2.id - o1.id;
            }
        });
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);


    }
    public static void main(String[] args) {

        demo01();

        demo02();

        demo03();
        //问题2：在TreeSet,Map和Collections.sort()创建时传入写好比较器的Puppy类？
        //还是传入已经重写了比较器的类对象？
        //是已经重写的类【对象】
        demo04();
    }
}
