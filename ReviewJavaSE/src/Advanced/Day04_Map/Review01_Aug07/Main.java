package Advanced.Day04_Map.Review01_Aug07;

import java.util.*;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/07/下午10:53
 * @Description:
 */
public class Main {
    //题目1：创建HashMap<String,String>保存学生信息。
//要求：添加3组姓名和手机号，并使用get查询指定姓名的手机号。
    private static void demo01(){
        HashMap<String, String> map = new HashMap<>();
        map.put("Barbie", "123123");
        map.put("Ken", "123125733");
        map.put("Esther", "986123123");
        System.out.println("查询Barbie的手机号：" + map.get("Barbie"));
    }
//题目2：使用Map保存商品信息。
//要求：key为商品编号，value为商品名称，实现添加、查询、删除。
    private static void demo02(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "牛奶");
        map.put(2, "猪肉");
        map.put(3, "零食");
        System.out.println("查询编号1的商品是什么" + map.get(1));
        map.remove(1);


    }
//题目3：使用keySet遍历Map。
//要求：创建HashMap<String,Integer>保存学生姓名和成绩，并遍历输出。
    private static void demo03(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("张三", 14);
        map.put("李四", 94);
        map.put("王五", 64);
        map.put("赵六", 84);

        Set<String> key = map.keySet();
        for (String s : key) {
            System.out.println(s + "->" + map.get(s));
        }
    }

//题目4：使用entrySet遍历Map。
//要求：获取Map中的所有键值对并输出key和value。
    private static void demo04(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("张三", 14);
        map.put("李四", 94);
        map.put("王五", 64);
        map.put("赵六", 84);

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }

//题目5：测试Map键重复特点。
//要求：添加相同key不同value的数据，观察最终value是什么。
    private static void demo05(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Barbie", 12);
        map.put("Barbie", 30);

        System.out.println(map);
    }

//题目6：使用LinkedHashMap保存学生成绩。
//要求：添加数据并遍历，观察输出顺序是否和添加顺序一致。
    private static void demo06(){
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Barbie", 100);
        map.put("Ken", 80);
        map.put("Cindy", 60);
        map.put("esther", 100);
        System.out.println("map顺序：" + map);

    }

//题目7：定义Student类作为HashMap的key。
//要求：根据姓名和年龄判断学生是否相同，重写hashCode和equals。
    private static void demo07(){
        Student stu1 = new Student(null, 13);//由此看出String的属性是有可能为null的
        Student stu2 = new Student("Barbie", 20);//由此看出String的属性是有可能为null的
        Student stu3 = new Student("Ken", 18);//由此看出String的属性是有可能为null的
        Student stu4 = new Student("Esther", 30);//由此看出String的属性是有可能为null的
        Student stu5 = new Student("Esther", 30);//由此看出String的属性是有可能为null的

        HashMap<Student, String> map = new HashMap<>();
        map.put(stu1, "一班");
        map.put(stu2, "二班");
        map.put(stu3, "一班");
        map.put(stu4, "四班");
        map.put(stu5, "三班");

        System.out.println("查看重写hashCode后的map:" + map);
    }

//题目8：使用HashMap存储Student对象。
//要求：key使用Student，value使用学生编号，完成添加和查询。
    private static void demo08(){
        Student stu1 = new Student(null, 13);//由此看出String的属性是有可能为null的
        Student stu2 = new Student("Barbie", 20);
        Student stu3 = new Student("Ken", 18);
        Student stu4 = new Student("Esther", 30);
        Student stu5 = new Student("Esther", 3);

        Map<Student, Integer> temp =  Map.of(
                stu1, 1,
                stu2, 2,
                stu3, 3,
                stu4, 4,
                stu5, 5
        );
        //temp.put(stu1, 1);错，这种添加方式temp内key不可重复而且不可修改自然也不能增添
        HashMap<Student, Integer> map = new HashMap<>(temp);
        System.out.println("查询stu3,key:" + stu3 + map.get(stu3));
    }

//题目9：统计字符串数组中每个单词出现次数。
////要求：使用HashMap完成，例如{"java","mysql","java","spring","mysql"}。
    private static void demo09(){
        //理解题目错误了String str = "javawrmysqedfmysqljavajavsmysql )4713$#=_jajavamysq323mysql";
        HashMap<String, Integer> map = new HashMap<>();
        //思路：把字符串转为字符数组，然后遍历。读到j和m的时候做特殊判断，
        // 把出现的次数记录到map中

        //理解错题目了，题目要统计的是字符串数组，直接比较就可以
        String[] arr = {"java","mysql","java","spring","mysql", "java"};
        for(String s : arr){
            if(map.containsKey(s)){//map中存在这个字符串的key的话，说明已经统计过至少1次+1即可
                map.put(s, map.get(s) + 1);
            }else{
                map.put(s, 1);
            }
        }
        System.out.println("每个字符串的出现次数：" + map);
    }

//题目10：Map集合嵌套
////要求：使用Map保存班级对应学生列表。
////要求：查询指定班级，并遍历该班级所有学生。例如：
// 一班 -> [
//    张三18,
//    李四19
//]

    private static void demo10(){
        HashMap<String, Map<String, Integer>> map = new HashMap<>();
        map.put("一班", Map.of("张三", 15, "李四", 20, "王五", 34));
        map.put("二班", Map.of("Barbie", 18, "Ken", 20,"Esther", 23));
        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("学生1",1);
        map2.put("学生2",2);
        map2.put("学生3",3);
        map.put("三班",map2);

        System.out.println("1班->" + map.get("一班"));
    }

//题目11：完成Map键值对遍历。
//要求：分别使用keySet和entrySet两种方式遍历同一个Map。
    private static void demo11(){
        Student stu1 = new Student(null, 13);//由此看出String的属性是有可能为null的
        Student stu2 = new Student("Barbie", 20);
        Student stu3 = new Student("Ken", 18);
        Student stu4 = new Student("Esther", 30);
        Student stu5 = new Student("Esther", 3);
        Map<Student, Integer> temp =  Map.of(
                stu1, 1,
                stu2, 2,
                stu3, 3,
                stu4, 4,
                stu5, 5
        );

        Set<Student> keySet = temp.keySet();
        System.out.println("keySet遍历：");
        for (Student s : keySet) {
            System.out.println(s + "->" + temp.get(s));
        }
        System.out.println("entrySet遍历：");
        Set<Map.Entry<Student, Integer>> entrySet = temp.entrySet();
        for(Map.Entry<Student, Integer> entry: entrySet){
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }


    }

//题目12：模拟斗地主准备牌。
//要求：使用Map保存编号和牌面对应关系，创建54张牌。
//题目13：模拟斗地主洗牌。
//要求：使用Map中的牌编号进行洗牌，输出随机后的牌编号。
//题目14：模拟斗地主发牌。
//要求：将洗好的牌按照三个人轮流发牌，每人17张，留3张底牌。
//题目15：斗地主查看牌面。
//要求：根据牌编号，通过Map查询对应牌面并输出玩家手中的牌
// 按照斗地主规则对玩家手中的牌进行排序并输出。
    private static void demo12_15(){
        //编号按照牌的面值大小从小到大排序
        Set<String> flower = new HashSet<>();//因为花色不分大小顺序所以用set
        flower.addAll(Arrays.asList("♥️", "♣️", "♦️", "♠️"));
        List<String> number = new ArrayList<>();
        Collections.addAll(number, "3", "4", "5", "6", "7", "8", "9", "10" ,"J", "Q", "K", "A", "2");
        Map<Integer, String> map = new HashMap<>();//存储牌的编号和对应牌，其中编号顺便对应牌的权重即大小
        int count = 0;
        for(String s : number){
            for(String f : flower){
                map.put(++count, f+s);
            }
        }
        map.put(++count, "小王");
        map.put(++count, "大王");
        System.out.println("牌编号权重及对应的牌" + map);

        //再把所有的key，权重取出来进行洗牌
        Set<Integer> keySet = map.keySet();
        List<Integer> weight = new ArrayList<>(keySet);
        Collections.shuffle(weight);//洗牌
        System.out.println("随机后的牌编号" + weight);
        List<Integer> p1 = new ArrayList<>();
        List<Integer> p2 = new ArrayList<>();
        List<Integer> p3 = new ArrayList<>();
        List<Integer> dipai = new ArrayList<>();

        for(int i = 0; i < weight.size(); i++){
            if(i >= 51){
                dipai.add(weight.get(i));
            }else if(i % 3 == 0){
                p1.add(weight.get(i));
            }else if(i % 3 == 1){
                p2.add(weight.get(i));
            }else if(i % 3 == 2){
                p3.add(weight.get(i));
            }
        }
        //根据权重查看每个人手里的牌
        System.out.println("\n玩家1的牌：");
        for(Integer i : p1){
            System.out.print(map.get(i));
        }
        System.out.println("\n玩家2的牌：");
        for(Integer i : p2){
            System.out.print(map.get(i));
        }
        System.out.println("\n玩家3的牌：");
        for(Integer i : p3){
            System.out.print(map.get(i));
        }
        System.out.println("\n底牌:");
        for(Integer i : dipai){
            System.out.print(map.get(i));
        }

        //想排序，因为三个牌都要排序所以最好是包装成类创建对象传入
        //三个玩家要排序的都是Integer类型的值而已，应该可以直接排序？
        Collections.sort(p1);
        Collections.sort(p2);
        Collections.sort(p3);
        System.out.println("排序后：");
        System.out.println("玩家1的牌：");
        for(Integer i : p1){
            System.out.print(map.get(i));
        }
        System.out.println("\n玩家2的牌：");
        for(Integer i : p2){
            System.out.print(map.get(i));
        }
        System.out.println("\n玩家3的牌：");
        for(Integer i : p3){
            System.out.print(map.get(i));
        }
        System.out.println("\n底牌:");
        for(Integer i : dipai){
            System.out.print(map.get(i));
        }
    }
//题目16：自定义对象作为HashMap的key。
//要求：验证不重写hashCode和equals时，相同属性对象是否能覆盖。
    /*答：不会覆盖，因为此时的判定equals和HashCode都是继承自Object的，只有地址一样才认为是同一个对象*/
    private static void demo16(){
        HashMap<Person, String> map = new HashMap<>();
        Person p1 = new Person(1, "Barbie", 20);
        Person p2 = new Person(1, "Barbie", 20);
        Person p3 = new Person(2, "Barbie", 20);
        map.put(p1,"地址1");
        map.put(p2,"地址2");
        map.put(p3,"地址3");
        System.out.println("没有重写hashCode的HashMap:" + map);

    }


    public static void main(String[] args) {
        demo01();
        demo02();
        demo03();
        demo04();
        demo05();
        demo06();
        demo07();
        demo08();
        demo09();
        demo10();
        demo11();
        demo12_15();
        demo16();

    }
}
