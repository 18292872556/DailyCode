package Advanced.Day03_List_Set.second_Jun20;

import java.util.*;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/06/20/下午4:19
 * @Description:
 */
public class MainTest {
    public static void main(String[] args) {


        //复习自然排序的接口2种用法和比较器的3种
        //首先有一些引用对象是内部有排序规则的，比如String,自动调用集合内元素排序规则的
        // 方法主要是TreeSet,TreeMap，和Collections.sort(List<?> list)
        //问题1：使用自然排序中的方法，比较所有包装类型，并考虑参数的可用类型
        System.out.println(Byte.valueOf("12").compareTo(Byte.valueOf("35")));
        System.out.println(Byte.valueOf((byte)15).compareTo((byte)80));
        /*这个方法只能用包装类调用，参数也是同类的包装类对象
        但对应的基本类型参数可以自动装箱。String类型必须装箱*/
        System.out.println(Short.valueOf("34").compareTo(Short.valueOf("45")));
        System.out.println(Short.valueOf((short)21).compareTo((short)34));

        System.out.println(Integer.valueOf("213").compareTo(Integer.valueOf("43")));
        System.out.println(Integer.valueOf(123).compareTo(231));

        System.out.println(Long.valueOf("23124").compareTo(Long.valueOf("313434")));
        System.out.println(Long.valueOf(23123L).compareTo(3214214L));

        System.out.println("Float------------------------");
        /*这里发现装箱时候字符串参数编译时期没有判错，所以还是对应的基本类型装箱更安全，做参数还能自动装箱*/
//        System.out.println(Float.valueOf("2^3.2f").compareTo(Float.valueOf("23.43f")));//NumberFormatException
        System.out.println(Float.valueOf("23.2").compareTo(Float.valueOf("23.43f")));
        System.out.println(Float.valueOf(2312.43f).compareTo(3232.23f));

        System.out.println(Double.valueOf("23.43").compareTo(Double.valueOf("232.3")));
        System.out.println(Double.valueOf(23.432).compareTo(1.2));

        System.out.println("Boolean-----------------------");
        System.out.println(Boolean.valueOf("true").compareTo(Boolean.valueOf("false")));
        System.out.println(Boolean.valueOf(true).compareTo(false));

        System.out.println("#".compareTo("R"));//不太合法，只能把字符当成String来比较大小
        System.out.println(Character.valueOf('%').compareTo('6'));

        //问题2：给自定义类继承重写自然排序，要求自定义Student类属性有id，姓名，用id升序排序
        //并且用TreeSet,TreeMap和Collections.sort(List<?>)检查排序结果
        Student stu1 = new Student(10, "Barbie");
        Student stu2 = new Student(1, "Ken");
        Student stu3 = new Student(19, "Barbie");
        TreeSet<Student> set = new TreeSet<>();
        set.add(stu1);
        set.add(stu2);
        set.add(stu3);
        System.out.println("TreeSet ->" + set.toString());
        TreeMap<Student, Integer> map = new TreeMap<>();
        map.put(stu1, 1);
        map.put(stu2, 2);
        map.put(stu3, 3);
        System.out.println("TreeMap ->" + map.toString());

        List<Student> list = new ArrayList<>();
        list.addAll(Arrays.asList(stu1, stu2, stu3));
        System.out.println("list ->" + list.toString());
        Collections.sort(list);
        System.out.println("list排序后 ->" + list.toString());

        System.out.println("Comparator比较器---------------------------------------------");
        //比较器排序
        //问题1：在自定义类中继承重写，要求Puppy类属性有姓名，主人和年龄。用姓名降序排序，
        // 姓名相等的情况下用主人名字升序排序。姓名String类型直接用String自带的排序规则
        Puppy p1 = new Puppy("12" , "23");
        Puppy p2 = new Puppy("1" , "0");
        Puppy p3 = new Puppy("1" , "24");
        Puppy p4 = new Puppy("0" , "1");
        /*问题在于TreeMap的key，TreeSet的元素都不可重复,诶改了比较方法以后就可以了。是否重复应该跟内部比较规则有关*/

        //问题2：在TreeSet,Map和Collections.sort(List<?>)创建时传入重写的比较器的Puppy类？
        //还是传入已经重写了比较器的类对象？
        /*错误TreeMap<Puppy, Integer> map1 = new TreeMap<>(Puppy);
        * 那为什么 匿名实现类可以，有名实现类的类名就不行？*/

        TreeSet<Puppy> set1 = new TreeSet<>(p1);
        set1.addAll(List.of(p1, p2, p3, p4));/*疑惑？为啥List那是Arrays.asList()*/
        System.out.println("set1，Puppy 自己姓名降序，相同情况主人姓名升序->" + set1.toString());
        TreeMap<Puppy, Integer> map1 = new TreeMap<>(new Puppy());
        map1.put(p1, 1);
        map1.put(p2, 2);
        map1.put(p3, 3);
        map1.put(p4, 4);
        System.out.println("map1 ->" + map1.toString());

        //问题3：在TreeSet,Map和Collections.sort()创建时传入匿名的比较器实现类
        People peo1 = new People(45, "Barbie");
        People peo2 = new People(13, "as");
        People peo3 = new People(12, "As");
        People peo4 = new People(46, "Bar");
        TreeSet<People> set2 = new  TreeSet<People>(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.id - o2.id;
            }
        });
        set2.addAll(List.of(peo1, peo2, peo3, peo4));
        System.out.println("匿名实现类的People,set2，id升序" + set2.toString());

        TreeMap<People,Integer> map2 = new TreeMap<>(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o2.id - o1.id;
            }
        });
        map2.put(peo1, 1);
        map2.put(peo2, 1);
        map2.put(peo3, 1);
        map2.put(peo4, 1);
        System.out.println("map2，人类id降序" + map2.toString());

        List<People> peopleList = new ArrayList<>();
        peopleList.addAll(Arrays.asList(peo1, peo2, peo3, peo4));
        Collections.sort(peopleList, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println("list姓名升序：" + peopleList.toString());

    }
}
