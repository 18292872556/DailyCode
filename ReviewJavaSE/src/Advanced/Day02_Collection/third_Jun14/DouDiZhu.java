package Advanced.Day02_Collection_泛型.third_Jun14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/06/13/上午12:04
 * @Description:
 */
public class DouDiZhu {

    //排序逻辑思考？如果不用map设置元素的权重，要怎么设置排序？
    //首先考虑String的本身的排序Arrays.sort(),但只能排序数组
    //又出现问题，就是方法参数明明接收的是ArrayList<String>类型的集合
    //但转数组toArray()后，还是类型不匹配还是显示Object类不能被String类型数组接收
    public static void cardSort(ArrayList<String> arrList){
        //String[] arr = arrList.toArray();//说是这个方法的原因，会擦除什么什么类型？
        //先不用了，老老实实回忆CompareTo吧
        //Arrays.sort(arrList.toArray());

    }

    public static void main(String[] args) {
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
        num.addAll(Arrays.asList("3","4","5","6","7","8","9","10","J","Q","K","A","2"));
        //num.addAll(flower);
        ArrayList<String> weight = new ArrayList();
        int flag = 0;
        for(int i = 0; i < num.size(); i++){
            for(int j=0; j < flower.size(); j++){
                card.add(flower.get(j) + num.get(i));
                //调整以后在创建过程的牌权重大小就是从小到大的
                weight.add(card.get(flag++));
            }
        }
        card.add("小王");
        card.add("大王");
        weight.add("小王");
        weight.add("大王");
        System.out.println("权重集合weight" + weight);
        System.out.println(card);

        Collections.shuffle(card);
        ArrayList<String> player1 = new ArrayList();
        ArrayList<String> player2 = new ArrayList();
        ArrayList<String> player3 = new ArrayList();
        ArrayList<String> dipai = new ArrayList();
        for(int i = 0; i < card.size(); i++){
            if(i >= 51){
                dipai.add(card.get(i));
            }else{
                if(i%3 == 0){
                    player1.add(card.get(i));
                }else if(i%3 == 1){
                    player2.add(card.get(i));
                }else if(i%3 == 2){
                    player3.add(card.get(i));
                }

            }
        }
        System.out.println("玩家1的牌：" + player1);
        System.out.println("玩家2的牌：" + player2);
        System.out.println("玩家3的牌：" + player3);

        //定义排序规则，使用Comparator比较器，暂时不考虑CompareTo方法
        //大王、小王、2、A、K、Q、J、10、9...” 的顺序降序排序
        //排序之前一定要确定权重
        //这里想尝试把权重作为集合元素下标来放，比如3最小，那么♠3, ♦3, ♣3, ♥3就应该在权重最低的
        //集合位置[0][1][2][3]上，最后填入的大王所在索引就是53



        Collections.sort(player1, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return weight.indexOf(o2) - weight.indexOf(o1);
            }
        });
        System.out.println("排序后的玩家1的牌" + player1);//成功！！



        //     * 三、面试追问 / 深度思考题（考察理解深度与举一反三能力）
        //     * 使用 Iterator 遍历集合时，如果在遍历过程中调用集合的 remove 方法会发生什么？为什么？迭代器自身的 remove 方法有什么不同？
        //     * 泛型擦除是什么？Java 泛型为什么会存在类型擦除，擦除后如何保证类型安全？
        //     * List 接口的 ArrayList 和 LinkedList 实现类，在遍历、增删操作上的性能差异是什么？适合的场景分别是什么？
        //     * 既然 Collection 接口有 toArray 方法，那数组转集合该如何实现？需要注意哪些问题（比如基本类型数组转集合）？
        //     * 假设你需要设计一个通用的集合工具类，用于处理不同类型的集合，如何利用泛型保证工具类的通用性和类型安全？
        //     */

    }
}
