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

//day03 List、Set 集合面试题

//题目1：ArrayList基本操作
//创建ArrayList<String>，添加：张三、李四、王五。
//要求：
//1. 索引1位置添加赵六
//2. 删除索引2元素
//3. 修改索引0为张三丰
//4. 使用普通for和增强for遍历


//题目2：List元素操作
//创建List<String>，添加：
//Java、MySQL、Spring、Java。
//要求：
//1. 判断是否存在Java
//2. 获取Java第一次出现索引
//3. 删除一个Java
//
//题目3：ArrayList存储对象
//定义Student(name,age)，创建ArrayList<Student>。
//要求：
//1. 添加5个学生
//2. 遍历学生
//3. 删除年龄小于18的学生
//
//题目4：学生查询
//定义Student(id,name,age)，使用ArrayList保存学生。
//输入学生姓名，如果存在输出学生信息，不存在输出未找到。
//
//题目5：LinkedList模拟栈
//使用LinkedList实现栈。
//添加：
//Java、MySQL、Spring。
//要求弹出顺序：
//Spring、MySQL、Java。
//使用push和pop。
//
//题目6：LinkedList模拟队列
//使用LinkedList实现队列。
//添加：
//A、B、C。
//要求按照先进先出输出。
//
//题目7：HashSet字符串去重
//创建HashSet<String>。
//添加：
//java、mysql、java、spring、mysql、redis。
//输出去重后的结果。
//
//题目8：HashSet对象去重
//定义Student(name,age)，使用HashSet存储：
//张三18
//李四20
//张三18
//要求最终只有两个对象。
//重写equals和hashCode。
//
//题目9：HashSet去重规则
//修改Student类，使姓名和年龄相同的对象认为重复。
//实现equals和hashCode。
//
//题目10：LinkedHashSet保持顺序
//创建LinkedHashSet<String>。
//添加：
//bbb、aaa、ccc、bbb。
//要求输出：
//bbb、aaa、ccc。
//
//题目11：可变参数求和
//定义sum方法。
//要求支持：
//sum(1,2,3)
//sum(10,20,30,40)
//返回总和。
//
//题目12：Collections.addAll
//创建ArrayList<Integer>。
//使用Collections.addAll添加：
//5、3、8、1、6。
//
//题目13：Collections.sort排序
//使用Collections.sort对：
//5、3、8、1、6
//进行升序排序。
//
//题目14：Comparator字符串排序
//创建ArrayList<String>：
//cba、aba、sba、nba。
//使用Comparator按照第一个字符降序排序。
//
//题目15：Comparator学生排序
//定义Student(name,age)。
//使用Comparator按照年龄升序排序。
//
//题目16：Comparator多条件排序
//Student(name,age)。
//排序规则：
//1. 年龄降序
//2. 年龄相同按照姓名首字母升序
//
//数据：
//rose18
//jack16
//abc16
//ace17
//mark16
//
//题目17：Comparable自然排序
//让Student实现Comparable<Student>。
//要求Collections.sort按照年龄升序。
//
//题目18：集合选择
//需求1：大量查询用户，根据索引获取。
//需求2：大量头部添加删除元素。
//分别选择ArrayList还是LinkedList，并写创建代码。
//
//题目19：HashSet统计学生数量
//学生：
//张三18
//李四19
//王五20
//张三18
//使用HashSet统计学生数量。
//
//题目20：学生管理系统
//使用ArrayList<Student>完成：
//1. 添加学生
//2. 删除学生
//3. 修改学生
//4. 查询学生
//5. 遍历学生
//
    //Comparable和Comparator有什么区别？
        //:复习自然排序的接口的2用法和比较器的3种
        //首先有一些引用对象是内部有排序规则的，比如String,自动调用集合内元素排序规则的
        // 方法主要是TreeSet,TreeMap，和Collections.sort(List<?> list)
        //题目20：使用自然排序中的方法，比较所有包装类型大小，并考虑参数的可用类型

        //问题21：给自定义类继承重写自然排序，要求自定义Student类属性有id，姓名，用id升序排序
        //并且用TreeSet,TreeMap和Collections.sort()检查排序结果

        //比较器排序
        //问题22：在自定义类中继承重写，要求Puppy类属性有id，姓名，主人和年龄。用年龄降序排序，
        // 年龄相等的情况下用id升序。
        //问题23：在TreeSet,Map和Collections.sort()创建时传入写好比较器的Puppy类？
        //还是传入已经重写了比较器的类对象？
        //问题24：在TreeSet,Map和Collections.sort()创建时传入匿名的比较器实现类












}
