package Advanced.Day02_Collection_泛型.Review06_Jul07;

import java.util.*;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/07/13/下午10:57
 * @Description:
 */
public class DouDiZhu {
    /*实现创建牌，洗牌，发牌，底牌留3张，发完的牌在玩家手里升序排序*/
    public static void main(String[] args) {
        //如果想写自然排序，可以创建Poker类，然后用TreeSet
        //其中的比较方法，要比较牌的面值直接写起来会比较麻烦
        //因为要跳过花色比较数值，但数值中J,Q,K不是数字比较起来非常麻烦
        //最方便的方法应该是用map来规定牌的权重，或者用List的下标来存储牌值的权重
        /*Map,因为TreeMap要求key是有排序规则的，所以不用这个*/
        HashMap<String, Integer> pokerMap = new HashMap();
        List<String> flower = new ArrayList<>();
        flower.addAll(Arrays.asList("♥️", "♣️", "♦️", "♠️"));
        List<String> number = new ArrayList<>();
        Collections.addAll(number, "3", "4", "5", "6", "7", "8", "9",
                "10", "J", "Q", "K", "A", "2");
        int weight = 0;
        //因为洗牌要用Collections的方法，所以牌还是用List形式存储
        List<String> poker = new ArrayList<>();
        for(int i = 0; i < number.size(); i++){
            for(int j = 0; j < flower.size(); j++){
                pokerMap.put(flower.get(j)+number.get(i), weight++);
                poker.add(flower.get(j)+number.get(i));
            }
        }
        pokerMap.put("小王", weight++);
        poker.add("小王");
        pokerMap.put("大王", weight++);
        poker.add("大王");
        System.out.println("做好的牌及其权重" + pokerMap);
        System.out.println("只有牌的" + poker + "根据牌值看权重");
        for(int i = 0; i < poker.size(); i++){
            System.out.print(poker.get(i) + "-" + pokerMap.get(poker.get(i))+ ",");
        }//确认权重配对没有问题
        //洗牌
        Collections.shuffle(poker);


        List<String> p1 = new ArrayList<>();
        List<String> p2 = new ArrayList<>();
        List<String> p3 = new ArrayList<>();
        List<String> 底牌 = new ArrayList<>();
        //发牌
        for(int i = 0; i < poker.size(); i++){
            if(i >= 51){
                底牌.add(poker.get(i));
            }else if(i%3 == 0){
                p1.add(poker.get(i));
            }else if(i%3 == 1){
                p2.add(poker.get(i));
            }else{
                p3.add(poker.get(i));
            }

        }
        System.out.println("发完牌以后3个玩家的手牌和底牌");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(底牌);
        /*思考怎么把这个权重运用到比较器里,匿名比较器得给三个人都重写非常麻烦，所以还是写成实现类
         * 并且这个实现类还要使用HashMap里的权重对比,只能把HashMap传参传进去*/
        PokerComparator com = new PokerComparator(pokerMap);
        Collections.sort(p1, com);
        Collections.sort(p2, com);
        Collections.sort(p3, com);
        System.out.println("排序后3个玩家的手牌和底牌");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(底牌);

    }
}
