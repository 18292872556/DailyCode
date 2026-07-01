package Advanced.Day02_Collection_泛型.Review04_Jun30;

import java.util.*;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/06/23/下午5:59
 * @Description:
 */


public class MainTest {
    ////进阶Day02_Collection_泛型
    //    /*一、基础概念题（考察对核心概念的理解）
    //     * 请简述 Java 中集合与数组的核心区别？
    /*集合长度不固定可变，可以存储不同类型的对象*/
    //     * Collection 接口是单列集合的根接口，它的两个核心子接口 List 和 Set 有哪些关键区别？
    /*List有序不可重复（可以排序也是按照添加顺序存储的元素，Set无序可重复*/
    //     * 什么是迭代器（Iterator）？迭代器遍历集合的核心方法有哪些，分别作用是什么？
    /*Iterator 一个接口，hasNext()和next()*/
    //     * 泛型的核心作用是什么？使用泛型相比不使用泛型有哪些优势？
    /*① 规定集合中元素的类型，可以等到使用时再指定实际类型
    * ② 编译期安全，可以先不指定集合元素类型，代码复用
    * 将类型作为参数，实现通用编程，提供编译期类型检查。
    * 优势：编译类型安全、省去强制转换、代码复用、可读性更好。
*/

    //     * 增强 for 循环（for-each）的底层实现原理是什么？遍历集合时使用增强 for 有哪些注意事项？

    /*是迭代器，注意不能对遍历的集合进行增删改的操作只能遍历查看*/
    public static void main(String[] args) {

        //     * 二、代码实操题（考察代码编写与问题解决能力）
        //     * 题目 1：Collection 接口方法使用
        //     * 要求：编写代码，使用 Collection 接口的常用方法（add、remove、contains、size、isEmpty、toArray 等）完成以下操作：
        //     * 创建一个 Collection 集合，存储至少 5 个字符串元素；
        //     * 删除其中指定的一个元素；
        //     * 判断集合中是否包含某个特定元素；
        //     * 将集合转换为数组并遍历输出；
        //    判断集合长度
        //     * 清空集合并验证集合是否为空。

        Collection coll1 = new ArrayList();
        coll1.add("rew");
        coll1.add(true);
        coll1.add(12.23);
        coll1.add('^');
        coll1.add(123.2f);
        System.out.println(coll1);
        coll1.remove(12.23);
        coll1.remove(0);
        System.out.println("是否有\"rew\"" + coll1.contains("rew"));
        System.out.println("集合长度" + coll1.size());
        Object[] objArr = coll1.toArray();
        //打印数组
        System.out.println(Arrays.toString(objArr));
        //正常遍历
        for(int i = 0; i < objArr.length; i++){
            System.out.println(objArr[i]);
        }
        //for each遍历
        System.out.println("foreach-----");
        for(Object obj : objArr){
            System.out.println(obj);
        }
        coll1.clear();
        System.out.println(coll1.isEmpty() ? "集合为空" : "集合不为空");




        //     * 题目 2：迭代器遍历与泛型结合
        //     * 要求：
        //     * 定义一个自定义类（比如 Student，包含 name、age 属性）；
        //     * 创建一个存储 Student 对象的 Collection 集合，添加 3 个 Student 实例；
        //     * 使用 Iterator 迭代器遍历集合，打印每个 Student 的信息；
        //     * 要求全程使用泛型，避免类型转换异常。
        Student stu1 = new Student("学生1", 10);
        Student stu2 = new Student("学生2", 20);
        Student stu3 = new Student("学生3", 30);
        Student stu4 = new Student("学生4", 40);
        Student stu5 = new Student("学生5", 50);
        Collection<Student> coll2 = new ArrayList();
        Collections.addAll(coll2, stu1, stu2, stu3, stu4, stu5);
        Iterator it1 = coll2.iterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }

        //     * 题目 3：泛型通配符与上下限
        //     * 要求：编写代码验证泛型上下限的规则，完成以下操作：
        //     * 定义方法printUpper(Collection<? extends Number> coll)，遍历输出集合元素，验证只能传入 Number 及其子类（Integer、Double 等）的集合；
        //     * 定义方法printLower(Collection<? super Integer> coll)，遍历输出集合元素，验证只能传入 Integer 及其父类（Number、Object）的集合；
        //     * 编写测试代码，分别传入不同类型的集合（如 String、Integer、Number、Object），观察编译结果并解释原因。
        Collection<String> coll11 = new ArrayList<>();
        Collection<Integer> coll22 = new ArrayList<>();
        Collection<Object> coll3 = new ArrayList<>();
        Collection<Number> coll4 = new ArrayList<>();
        //预判一下，printUpper是Number和子类，就只能接收Integer,Number。
        //printLower参数是Integer及其超类，就是只有Object,Number
        //错new MainTest().printUpper(coll11);
        new MainTest().printUpper(coll22);
        //错new MainTest().printUpper(coll3);
        new MainTest().printUpper(coll4);

        //错new MainTest().printLower(coll11);
        new MainTest().printLower(coll22);
        new MainTest().printLower(coll3);
        new MainTest().printLower(coll4);

        //     * 题目 4：斗地主案例改造
        //     * 基于文档中的斗地主洗牌发牌案例，完成以下改造：
        //     * 给每张牌增加权重（比如大王 > 小王 > 2>A>K>Q>J>10...），发牌后对每个玩家的牌按权重排序；
        //     * 输出时按 “大王、小王、2、A、K、Q、J、10、9...” 的顺序展示每个玩家的牌；
        //      将最后3张牌直接存放于底牌
        //     * 要求代码结构清晰，新增排序逻辑需封装为独立方法。
        /*思路分析，之前排序考虑过用List集合的下标来表示权重，可行，就是要写一个专门的List集合来存储权重大小，
        在排序时查看核心方法indexOf(元素值)*/
        /*最方便常用的方法就是使用Map<Integer,String>*/
        //记录牌,因为洗牌要使用shuffle()随机打乱集合顺序，有顺序就是属于List的方法，那么对于方法是运行看左，使用看右。
        //所以不能继续用接口构造而是直接ArrayList
        System.out.println("----------------题4：斗地主案例，List下标记录权重");
        /*用List的下标来记录权重*/
        List<String> weight = new ArrayList<>();
        List<String> flower = new ArrayList<>();
        List<String> number = new ArrayList<>();
        flower.addAll(Arrays.asList("♥️",  "♦️", "♣️","♠️"));
        Collections.addAll(number,"3", "4", "5", "6", "7", "8", "9"
        , "10", "J", "Q", "K", "A", "2");
        //因为要按List的下标来做大小，所以数字也是按升序写的，
        //构造牌的时候也要按从小到大的顺序，所以同一个数字不同花色应该算是同一个大小
        //顺序也是紧挨着，所以双层嵌套构造时应该数字是外循环，花色是内循环
        for(int i = 0; i < number.size(); i++){
            for(int j = 0; j < flower.size(); j++){
                weight.add(flower.get(j) + number.get(i));
            }
        }
        weight.add("小王");
        weight.add("大王");
        //System.out.println("升序创建好的扑克牌为：" + weight);
        /*创建牌值的记录*/
        List<String> poker = new ArrayList<>();
        poker.addAll(weight);
        /*？疑问： 确定了addAll可以多次添加多个同类集合*/
        //poker.addAll(flower);
        //System.out.println(poker);

        /*洗牌*/
        Collections.shuffle(poker);
        System.out.println("洗完牌后：" + poker);
        System.out.println("牌值由小到大为：" + weight);

        /*发牌*/
        List<String> person1 = new ArrayList<>();
        List<String> person2 = new ArrayList<>();
        List<String> person3 = new ArrayList<>();
        List<String> kitty = new ArrayList<>();
        for(int i = 0; i < poker.size(); i++){
            if(i >= 51){//因为总共是13*4+2=54张牌，底牌需要留3张
                kitty.add(poker.get(i));
            }else if(i%3 == 0){
                person1.add(poker.get(i));
            }else if(i%3 == 1){
                person2.add(poker.get(i));
            }else if(i%3 == 2){
                person3.add(poker.get(i));
            }
        }
        System.out.println("发完牌3人的牌和底牌：" + person1 + "\n" + person2
                + "\n" + person3 + "\n" + kitty);
        /* ● 核心：对每个玩家手里的牌排序，这里第一次使用weight来排序
        * 核心方法集合.indexOf(元素)通过元素来找到对应下标，然后比较器规则里就比较这个*/
        Collections.sort(person1,new WeightComparator<String>(weight));
        Collections.sort(person2,new WeightComparator<String>(weight));
        Collections.sort(person3,new WeightComparator<String>(weight));
        Collections.sort(kitty,new WeightComparator<String>(weight));

        System.out.println("排序后的三人牌和底牌" + person1 + "\n" + person2
                + "\n" + person3 + "\n" + kitty);




        //     * 三、面试追问 / 深度思考题（考察理解深度与举一反三能力）
        //     * 使用 Iterator 遍历集合时，如果在遍历过程中调用集合的 remove 方法会发生什么？为什么？迭代器自身的 remove 方法有什么不同？
        //     * 泛型擦除是什么？Java 泛型为什么会存在类型擦除，擦除后如何保证类型安全？
        //     * List 接口的 ArrayList 和 LinkedList 实现类，在遍历、增删操作上的性能差异是什么？适合的场景分别是什么？
        //     * 既然 Collection 接口有 toArray 方法，那数组转集合该如何实现？需要注意哪些问题（比如基本类型数组转集合）？
        //     * 假设你需要设计一个通用的集合工具类，用于处理不同类型的集合，如何利用泛型保证工具类的通用性和类型安全？
        //     */
    }
    public void printUpper(Collection<? extends Number> coll){
        //要求是接收Number及其子类
        Iterator<? extends Number> it = coll.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    public void printLower(Collection< ? super Integer> coll){
        //要求是接收Integer类及其超类
        Iterator<? super Integer> it = coll.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }


}
