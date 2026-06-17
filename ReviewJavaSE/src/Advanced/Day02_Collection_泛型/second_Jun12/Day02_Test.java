package Advanced.Day02_Collection_泛型.second_Jun12;

import java.util.*;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/06/12/下午5:43
 * @Description:
 */
public class Day02_Test {
    public static void printUpper(Collection<? extends Number> coll){
        Iterator<? extends Number> iter = coll.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
    public static void printLower(Collection<? super Integer> coll){
        Iterator<? super Integer> iter = coll.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }


    public static void main(String[] args) {
        ////进阶Day02_Collection_泛型
        //    /*一、基础概念题（考察对核心概念的理解）
        //     * 请简述 Java 中集合与数组的核心区别？
        /* 集合长度可变，一个集合中可以存储不同类型的引用对象*/
        //     * Collection 接口是单列集合的根接口，它的两个核心子接口
        //     List 和 Set 有哪些关键区别？
        /* List有序可重复， Set无序不可重复*/
        //     * 什么是迭代器（Iterator）？迭代器遍历集合的核心方法有哪些，分别作用是什么？
        /* Iterator就是一个可以遍历集合和数组的接口，通过Collection下的方法获得
        *  有hasNext()判断遍历集合下一位是否还有元素，还有next()取到下一位元素*/
        //     * 泛型的核心作用是什么？使用泛型相比不使用泛型有哪些优势？
        /* 1. 规定集合中元素的类型，编译期安全
           2. 不用强转，比如从集合中取数单独存储的时候需要接收
           3. 代码复用比如ArrayList<E>中E可以接收所有引用类型
        *  4. 通配符安全兼容
            不使用泛型的优势：
            可以存很多不同类型的元素
            */
        //     * 增强 for 循环（for-each）的底层实现原理是什么？遍历集合时使用
        //     增强 for 有哪些注意事项？
        /*原理：迭代器，增强for只能遍历不能增删改变集合*/



        //     * 二、代码实操题（考察代码编写与问题解决能力）
        //     * 题目 1：Collection 接口方法使用
        //     * 要求：编写代码，使用 Collection 接口的常用方法（add、remove、contains、size、isEmpty、toArray 等）完成以下操作：
        //     * 创建一个 Collection 集合，存储至少 5 个字符串元素；
        //     * 删除其中指定的一个元素；
        //     * 判断集合中是否包含某个特定元素；
        //     * 将集合转换为数组并遍历输出；
        //     * 清空集合并验证集合是否为空。
        Collection<String> coll1 = new ArrayList();
        coll1.add("!@#dq~");
        coll1.add("true");
        coll1.add("^");
        coll1.add("1234.42");
        coll1.add("1421");
        System.out.println(coll1);
        coll1.remove("^");
        System.out.println("是否含有1421" + coll1.contains("1421"));
        Object[] arr = coll1.toArray();
        for(Object obj : arr){
            System.out.print(obj + ",");
        }
        coll1.clear();
        System.out.println("集合是否为空" + coll1.isEmpty());




        //     * 题目 2：迭代器遍历与泛型结合
        //     * 要求：
        //     * 定义一个自定义类（比如 Student，包含 name、age 属性）；
        //     * 创建一个存储 Student 对象的 Collection 集合，添加 3 个 Student 实例；
        //     * 使用 Iterator 迭代器遍历集合，打印每个 Student 的信息；
        //     * 要求全程使用泛型，避免类型转换异常。
        Student stu1 = new Student("Barbie", 8);
        Student stu2 = new Student("Barbie", 80);
        Student stu3 = new Student();
        Collection<Student> coll2 = new ArrayList();
        coll2.add(stu1);
        coll2.add(stu2);
        coll2.add(stu3);

        Iterator<Student> it = coll2.iterator();
        while(it.hasNext()){
            Student stu = it.next();
            System.out.println(stu.name + stu.age);
        }


        //     * 题目 3：泛型通配符与上下限
        //     * 要求：编写代码验证泛型上下限的规则，完成以下操作：
        //     * 定义方法printUpper(Collection<? extends Number> coll)，
        //     遍历输出集合元素，验证只能传入 Number 及其子类（Integer、Double 等）的集合；
        //     * 定义方法printLower(Collection<? super Integer> coll)，
        //     遍历输出集合元素，验证只能传入 Integer 及其父类（Number、Object）的集合；
        //     * 编写测试代码，分别传入不同类型的集合（如 String、Integer、Number、Object），观察编译结果并解释原因。

        //printUpper只能接收Number及其子类，比如数据类，printLower只能接收Integer的父类
        Collection<Integer> coll3 = new ArrayList();
        Collection<Double> coll4 = new ArrayList();
        Collection<Number> coll5 = new ArrayList();
        Collection<Object> coll6 = new ArrayList();
        printUpper(coll3);
        printUpper(coll4);
        printUpper(coll5);
        //printUpper(coll6);

        printLower(coll3);
       // printLower(coll4);
        printLower(coll5);
        printLower(coll6);


    }
}
