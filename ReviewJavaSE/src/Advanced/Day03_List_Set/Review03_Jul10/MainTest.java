package Advanced.Day03_List_Set.Review03_Jul10;

import java.util.*;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/07/10/下午9:00
 * @Description:
 */
public class MainTest {
    //复习自然排序的接口的2用法和比较器的3种
    //首先有一些引用对象是内部有排序规则的，比如String,自动调用集合内元素排序规则的
    // 方法主要是TreeSet,TreeMap，和Collections.sort(List<?> list)
    //问题1：使用自然排序中的方法，比较所有包装类型大小，并考虑参数的可用类型
    /*自然排序的引用对象比较
    * 所有的装箱参数都可以用对应的数据类型，或者字符串参数。对应的数据类型可以自动装箱，字符串不行，必须手动装箱
    * 但是Character不可以用字符串参数装箱，只能把字符当成字符串的格式来比较*/
    private static void demo01(){
        System.out.println(Integer.valueOf(12).compareTo(13));
        System.out.println(Integer.compare(12,13));
        System.out.println(Integer.valueOf("12").compareTo(Integer.valueOf("12")));

        System.out.println(Double.valueOf(12.13).compareTo(13.1));
        System.out.println(Double.valueOf("12.12").compareTo(Double.valueOf("13.1")));


        //参数的可用类型
        System.out.println("%".compareTo("%"));
        System.out.println(Character.valueOf('@').compareTo(Character.valueOf('@')));

    }
    //问题2：给自定义类继承重写自然排序，要求自定义Student类属性有id，姓名，用id升序排序
    //并且用TreeSet,TreeMap和Collections.sort()检查排序结果
    private static void demo02(){
        System.out.println("demo02-------------Student id升序");
        //因为这里已经让Student实现了自然排序
        Student stu1 = new Student("Barbie", 01);
        Student stu2 = new Student("Barbie", 03);
        Student stu3 = new Student("Barbie", 02);

        TreeSet treeSet1 = new TreeSet();
        treeSet1.add(stu1);
        treeSet1.add(stu2);
        treeSet1.add(stu3);
        System.out.println("有自然排序的TreeSet: " + treeSet1);

        TreeMap treeMap = new TreeMap();
        treeMap.put(stu1, "stu1");
        treeMap.put(stu2, "stu2");
        treeMap.put(stu3, "stu3");
        System.out.println("有自然排序的TreeMap:" + treeMap);

        List<Student> list = new ArrayList<Student>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        Collections.sort(list);
        System.out.println("sort排序的list:" + list);


    }
    //比较器排序
    //问题1：在自定义类中继承重写，要求Puppy类属性有id，姓名，年龄。用年龄降序排序，
    // 年龄相等的情况下用id升序。
    //问题2：在TreeSet,Map和Collections.sort()创建时传入写好比较器的Puppy类？
    //还是传入已经重写了比较器的类对象？答：是对象，有重写了比较器的类对象，或重写了比较器类的匿名对象
    /*传了一个有重写比较器的类对象*/
    private static void demo03(){
        System.out.println("demo03--------Puppy年龄降序排序，年龄相等的情况下用id升序。");
        Puppy p1 = new Puppy(01, "边牧", 4);
        Puppy p2 = new Puppy(03, "伯恩山", 4);
        Puppy p3 = new Puppy(01, "西高地", 5);

        TreeSet set = new TreeSet(p1);
        /*需要注意的是，虽然Puppy重写了比较器，但是和自然排序的区别在于要手动传参，不传的话可以看看结果
        * 结果就是这行报错，因为TreeSet，TreeMap只要带Tree都要求有排序规则*/
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println("TreeSet: " + set);

        List<Puppy> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        Collections.sort(list, new Puppy());
        System.out.println("list排序后：" + list);

    }

    //问题3：在TreeSet,Map和Collections.sort()创建时传入匿名的比较器实现类
    private static void demo04(){
        //一个普通的类，没有重写任何比较器，自然排序
        TreeSet<People> treeSet = new TreeSet(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.id - o2.id;
            }
        });//此处按id升序排序
        People p1 = new People(1, "张三");
        People p2 = new People(4, "李四");
        People p3 = new People(1, "王五");
        People p4 = new People(2, "赵四");
        treeSet.add(p1);
        treeSet.add(p2);
        treeSet.add(p3);
        treeSet.add(p4);
        System.out.println("TreeSet-id升序: " + treeSet);
        /*注意！因为这里的比较规则只有id,TreeSet中元素不可重复，所以最终结果id为1的只有第一个id为1的也就是张三*/

        List<People> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        Collections.sort(list, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.id == o2.id ? o1.name.compareTo(o2.name) : o2.id - o1.id;
            }
        });//此处比较规则为id降序，id相同时name升序
        System.out.println("List-id降序，id相同name升序" + list);


    }
    public static void main(String[] args) {
        demo01();
        demo02();
//        demo03();
//        demo04();



    }




}
