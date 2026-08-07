package Advanced.Day04_Map.Review01_Aug07;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

        }
    }

//题目5：测试Map键重复特点。
//要求：添加相同key不同value的数据，观察最终value是什么。

//题目6：使用LinkedHashMap保存学生成绩。
//要求：添加数据并遍历，观察输出顺序是否和添加顺序一致。

//题目7：定义Student类作为HashMap的key。
//要求：根据姓名和年龄判断学生是否相同，重写hashCode和equals。

//题目8：使用HashMap存储Student对象。
//要求：key使用Student，value使用学生编号，完成添加和查询。

//题目9：统计字符串出现次数。
//要求：使用HashMap统计"java"、"mysql"、"java"出现次数。

//题目10：使用Map完成联系人管理。
//要求：key为姓名，value为手机号，实现添加和查询功能。

//题目11：完成Map键值对遍历。
//要求：分别使用keySet和entrySet两种方式遍历同一个Map。

//题目12：模拟斗地主准备牌。
//要求：使用Map保存编号和牌面对应关系，创建54张牌。

//题目13：模拟斗地主洗牌。
//要求：使用Map中的牌编号进行洗牌，输出随机后的牌编号。

//题目14：模拟斗地主发牌。
//要求：将洗好的牌按照三个人轮流发牌，每人17张，留3张底牌。

//题目15：斗地主查看牌面。
//要求：根据牌编号，通过Map查询对应牌面并输出玩家手中的牌。

//题目16：自定义对象作为HashMap的key。
//要求：验证不重写hashCode和equals时，相同属性对象是否能覆盖。

//题目17：修改Student类。
//要求：让两个姓名年龄相同的Student对象作为HashMap的key时只能保存一个。

    //题目18：Map综合练习。
//要求：使用HashMap完成学生管理：添加学生、根据姓名查询学生信息。

    public static void main(String[] args) {

    }
}
