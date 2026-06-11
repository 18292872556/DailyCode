package Advanced.Day02_Collection_泛型.first_Jun10;

import java.util.*;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/06/08/下午8:01
 * @Description:
 */
public class Day02_Test {
    //一、基础概念题（考察对核心概念的理解）
    //     * 请简述 Java 中集合与数组的核心区别？
    /*集合长度可变，数组长度是固定的
    * 集合只能存储引用类型
    * 集合可以一次存储多种不同类型的对象*/

    //     * Collection 接口是单列集合的根接口，它的两个核心子接口 List 和 Set 有哪些关键区别？
    /*List有序可重复。Set无序，且元素不可重复*/
    //     * 什么是迭代器（Iterator）？迭代器遍历集合的核心方法有哪些，分别作用是什么？
    /*就是内部有指针，可以遍历集合和数组的接口，是Collection下的方法可获得*/
    //     * 泛型的核心作用是什么？使用泛型相比不使用泛型有哪些优势？
    /*固定集合中的元素类型，不容易出错
    * 不使用泛型的好处就是一个集合可以存储多种不同类型的元素*/

    //     * 增强 for 循环（for-each）的底层实现原理是什么？遍历集合时使用增强 for 有哪些注意事项？
    /*原理就是内部有迭代器，所以只能遍历查看，不能增删操作*/
    public <MVP> void myGenericMethod(MVP mvp){
        System.out.println(mvp.getClass());

    }
    private static void printColl(Collection coll){
        //coll.add("21");错误的，泛型通配符的情况不可以存储，只能接收
        Iterator it = coll.iterator();
        System.out.print("【");
        while(it.hasNext()){
            System.out.print(it.next());
            if(it.hasNext()){
                System.out.print("-");
            }
        }
        System.out.print("】");

    }
    public static void subNumber(Collection<? extends Number> coll){}
    public static void superNumber(Collection<? super Number> coll){}

    public static void main(String[] args) {

        //先复习
        //泛型类
//        MyClass<String> myClass1 = new MyClass<>();
//        System.out.println(myClass1.getNum());
//        myClass1.setNUm("let's set");
//        System.out.println(myClass1.getNum());
//
//        MyClass<Integer> myClass2 = new MyClass<>();
//        myClass2.setNUm(1523);
//        System.out.println(myClass2.getNum());

        /*再复习一次static方法之间的调用
        * 1. 静态方法调用分非静态和静态。非静态一律对象名. 静态分内外，内直接调，外类名.
        * 2. 非静态方法调用分类内外，内直接名调，外部，静态用类名.，非静态用对象名.*/

        //泛型方法
//        new Day02_Test().myGenericMethod("haha@");
//        //泛型接口
//        MyInterface1Impl1 myImpl1 = new MyInterface1Impl1();
//        myImpl1.add("!@#@1");
//        System.out.println(myImpl1.getE());
//        //泛型接口
//        MyInterface1Impl2<Double> myImpl2 = new MyInterface1Impl2<>();
//        myImpl2.add(2.4);
//        System.out.println(myImpl2.getE());
//
//        //一个方法可以接收任意泛型类型的单列集合并打印【元素1-元素2……】
//        Collection<String> coll1 = new ArrayList<>();
//        coll1.add("@!#4");
//        coll1.add("@!6#4");
//        coll1.add("@!#5");
//        Collection<Integer> coll2 = new ArrayList<>();
//        coll2.add(2);
//        coll2.add(2);
//        coll2.add(3);
//        Collection<Double> coll3 = new HashSet<>();
//        coll3.add(12.3);
//        coll3.add(12.3);//set内不可重复，添加不报错但重复的只保留一个
//        coll3.add(13.3);
//        printColl(coll1);
//        printColl(coll2);
//        printColl(coll3);

//        ① 定义一个只接收数字类的参数的方法并调用
//
//        ②定义一个只接收Number类及其超类的方法并调用
//        Collection<String> coll1 = new ArrayList();
//        Collection<Number> coll2 = new ArrayList();
//        Collection<Integer> coll3 = new ArrayList();
//        Collection<Object> coll4 = new ArrayList();
////        ❌️subNumber(coll1);
//        subNumber(coll2);
//        subNumber(coll3);
////        ❌️subNumber(coll4);//String，Object不属于Number及其子类
////        ❌️superNumber(coll1);
//        superNumber(coll2);
////        ❌️superNumber(coll3);//String和Integer不属于Number及其超类
//        superNumber(coll4);


//测试Collection的随机排序方法
        ArrayList coll = new ArrayList();
        coll.add(123);
        coll.add(123.4);
        coll.add("214^%");
        coll.add(true);

        System.out.println(coll);
        Collections.shuffle(coll);
        System.out.println(coll);




        //     * 二、代码实操题（考察代码编写与问题解决能力）
        //     * 题目 1：Collection 接口方法使用
        //     * 要求：编写代码，使用 Collection 接口的常用方法（add、remove、contains、size、isEmpty、toArray 等）完成以下操作：
        //     * 创建一个 Collection 集合，存储至少 5 个字符串元素；
        //     * 删除其中指定的一个元素；
        //     * 判断集合中是否包含某个特定元素；
        //     * 将集合转换为数组并遍历输出；
        //     * 清空集合并验证集合是否为空。
        Collection coll1 = new ArrayList();
        coll1.add(12);
        coll1.add('#');
        coll1.add("!@#@!4");
        coll1.add(true);
        coll1.add(123.4131);
        System.out.println(coll1);
        coll1.remove(true);
        System.out.println("删除指定true内容的元素" + coll1);
        System.out.println("集合中是否含有'#'" + coll1.contains('#'));
        Object[] arr = coll1.toArray();
        for(Object o : arr){
            System.out.println(o + ",");
        }

//        //     * 题目 2：迭代器遍历与泛型结合
//        //     * 要求：
//        //     * 定义一个自定义类（比如 Student，包含 name、age 属性）；
//        //     * 创建一个存储 Student 对象的 Collection 集合，添加 3 个 Student 实例；
//        //     * 使用 Iterator 迭代器遍历集合，打印每个 Student 的信息；
//        //     * 要求全程使用泛型，避免类型转换异常。
        Collection<Student> coll2 = new ArrayList<>();
        Student s1 = new Student();
        Student s2 = new Student("barbie", 30);
        Student s3 = new Student();
        coll2.add(s1);
        coll2.add(s2);
        coll2.add(s3);
        //System.out.println(coll2);
        System.out.println("用迭代器打印");
        Iterator<Student> iterator = coll2.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next() + ",");
        }

        //     * 题目 3：泛型通配符与上下限
        //     * 要求：编写代码验证泛型上下限的规则，完成以下操作：
        //     * 定义方法printUpper(Collection<? extends Number> coll1)，遍历输出集合元素，
        //     验证只能传入 Number 及其子类（Integer、Double 等）的集合；
        //     * 定义方法printLower(Collection<? super Integer> coll1)，遍历输出集合元素，
        //     验证只能传入 Integer 及其父类（Number、Object）的集合；
        //     * 编写测试代码，分别传入不同类型的集合（如 String、Integer、Number、Object），
        //     观察编译结果并解释原因。


        //     * 题目 4：斗地主案例改造
        //     * 基于文档中的斗地主洗牌发牌案例，完成以下改造：
        //     * 给每张牌增加权重（比如大王 > 小王 > 2>A>K>Q>J>10...），发牌后对每个玩家的牌按权重排序；
        //     * 输出时按 “大王、小王、2、A、K、Q、J、10、9...” 的顺序展示每个玩家的牌；
        //     * 要求代码结构清晰，新增排序逻辑需封装为独立方法。
        //     * 三、面试追问 / 深度思考题（考察理解深度与举一反三能力）
        //     * 使用 Iterator 遍历集合时，如果在遍历过程中调用集合的 remove 方法会发生什么？为什么？迭代器自身的 remove 方法有什么不同？
        //     * 泛型擦除是什么？Java 泛型为什么会存在类型擦除，擦除后如何保证类型安全？
        //     * List 接口的 ArrayList 和 LinkedList 实现类，在遍历、增删操作上的性能差异是什么？适合的场景分别是什么？
        //     * 既然 Collection 接口有 toArray 方法，那数组转集合该如何实现？需要注意哪些问题（比如基本类型数组转集合）？
//     *   假设你需要设计一个通用的集合工具类，用于处理不同类型的集合，如何利用泛型保证工具类的通用性和类型安全？
        //
    }
}
