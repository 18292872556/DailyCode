package Advanced.Day03_List_Set;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/06/17/下午7:33
 * @Description:
 */
public class Main {


        //复习自然排序的接口2种用法和比较器的3种
        //首先有一些引用对象是内部有排序规则的，比如String,自动调用集合内元素排序规则的
        // 方法主要是TreeSet,TreeMap，和Collections.sort(List<?> list)
        //问题1：使用自然排序中的方法，比较所有包装类型，并考虑参数的可用类型

        //问题2：给自定义类继承重写自然排序，要求自定义Student类属性有id，姓名，用id升序排序
        //并且用TreeSet,TreeMap和Collections.sort()检查排序结果

        //比较器排序
        //问题1：在自定义类中继承重写，要求Puppy类属性有姓名，主人和年龄。用姓名降序排序，
        // 姓名相等的情况下用主人名字排序。姓名String类型直接用String自带的排序规则
        //问题2：在TreeSet,Map和Collections.sort()创建时传入写好比较器的Puppy类？
        //还是传入已经重写了比较器的类对象？
        //问题3：在TreeSet,Map和Collections.sort()创建时传入匿名的比较器实现类





}
