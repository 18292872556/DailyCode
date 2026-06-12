package Advanced.Day02_Collection_泛型.second_Jun12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

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

        //     * 题目 4：斗地主案例改造
        //     * 基于文档中的斗地主洗牌发牌案例，完成以下改造：
        //     * 给每张牌增加权重（比如大王 > 小王 > 2>A>K>Q>J>10...），发牌后对每个玩家的牌按权重排序；
        //     * 输出时按 “大王、小王、2、A、K、Q、J、10、9...” 的顺序展示每个玩家的牌；
        //     * 要求代码结构清晰，新增排序逻辑需封装为独立方法。
        ArrayList<String> card = new ArrayList();
        ArrayList<String> flower = new ArrayList();
        flower.add("♠");
        flower.add("♦");
        flower.add("♣");
        flower.add("♥");
        ArrayList<String> num = new ArrayList<>();
        num.addAll(Arrays.asList("A","2","3","4","5","6","7","8","9","10","J","Q","K"));
        for(int i = 0; i < flower.size(); i++){
            for(int j=0; j < num.size(); j++){
                card.add(flower.get(i) + num.get(j));
            }
        }
        card.add("大王");
        card.add("小王");
        System.out.println(card);

        ArrayList<String> player1 = new ArrayList();
        ArrayList<String> player2 = new ArrayList();
        ArrayList<String> player3 = new ArrayList();
        //for()

        //     * 三、面试追问 / 深度思考题（考察理解深度与举一反三能力）
        //     * 使用 Iterator 遍历集合时，如果在遍历过程中调用集合的 remove 方法会发生什么？为什么？迭代器自身的 remove 方法有什么不同？
        //     * 泛型擦除是什么？Java 泛型为什么会存在类型擦除，擦除后如何保证类型安全？
        //     * List 接口的 ArrayList 和 LinkedList 实现类，在遍历、增删操作上的性能差异是什么？适合的场景分别是什么？
        //     * 既然 Collection 接口有 toArray 方法，那数组转集合该如何实现？需要注意哪些问题（比如基本类型数组转集合）？
        //     * 假设你需要设计一个通用的集合工具类，用于处理不同类型的集合，如何利用泛型保证工具类的通用性和类型安全？
        //     */
    }
}
