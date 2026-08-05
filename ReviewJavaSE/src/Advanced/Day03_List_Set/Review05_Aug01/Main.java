package Advanced.Day03_List_Set.Review05_Aug01;

import java.util.*;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/01/下午6:10
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
    private static void printfList(List<?> list){
        for(Object o : list){
            System.out.print(o + ",");
        }

    }
    private static void demo01(){
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(Arrays.asList("张三", "李四", "王五"));

        list.add(1, "赵六");
        list.remove(2);
        list.set(0, "张三丰");

        for(int i = 0; i < list.size(); i++){
            System.out.printf(list.get(i) + ",");
        }
        System.out.println("\n增强for遍历");
        for(String str : list){
            System.out.printf(str + "-");
        }

    }


//题目2：List元素操作
//创建List<String>，添加：
//Java、MySQL、Spring、Java。
//要求：
//1. 判断是否存在Java
//2. 获取Java第一次出现索引
//3. 删除一个Java
//
    private static void demo02(){
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Java", "MySQL", "Spring", "Java");
        System.out.println("list:" + list);
        System.out.println("是否存在Java:" + list.contains("Java"));
        System.out.println("Java第一次出现索引的位置：" + list.indexOf("Java"));
        list.remove("Java");
        System.out.println("删除一个Java后：" + list);
    }
//题目3：ArrayList存储对象
//定义Student(name,age)，创建ArrayList<Student>。
//要求：
//1. 添加5个学生
//2. 遍历学生
//3. 删除年龄小于18的学生
//
    private static void demo03(){
        List<Student> list = new ArrayList<Student>();
        Student stu1 = new Student("张三", 10);
        Student stu2 = new Student("李四", 13);
        Student stu3 = new Student("王五", 19);
        Student stu4 = new Student("李明", 18);
        Student stu5 = new Student("王蕾蕾", 20);
        list.addAll(Arrays.asList(stu1, stu2, stu3, stu4, stu5));
        for(Student stu : list){
            System.out.printf(stu.toString());
        }
        System.out.println("删除18岁以下的后学生为：");
        for(int i = 0; i<list.size(); i++){
            if(list.get(i).age < 18){
                list.remove(i);
            }
        }

        printfList(list);
    }
//题目4：学生查询
//定义Student(id,name,age)，使用ArrayList保存学生。
//输入学生姓名，如果存在输出学生信息，不存在输出未找到。
//
    private static void demo04(){
        List<Student04> list = new ArrayList<>();
        Student04 stu1 = new Student04(03, "张三", 30);
        Student04 stu2 = new Student04(01, "李四", 3);
        Student04 stu3 = new Student04(02, "王五", 23);
        Student04 stu4 = new Student04(04, "小明", 15);
        Student04 stu5 = new Student04(05, "小红", 25);
        list.addAll(Arrays.asList(stu1, stu2, stu3, stu4, stu5));
           Scanner sc = new Scanner(System.in);
           System.out.println("\n**输入学生姓名：**");
           String name = sc.next();
           int flag = 0;
           for(Student04 stu : list){
               if(stu.name.equals(name)){
                   System.out.println("学生信息为：" + stu);
                   flag = 1;
               }
           }
           if(flag == 0){
               System.out.println("未找到");
           }
    }
//题目5：LinkedList模拟栈
//使用LinkedList实现栈。
//添加：
//Java、MySQL、Spring。
//要求弹出顺序：
//Spring、MySQL、Java。
//使用push和pop。

    private static void demo05(){
        LinkedList<String> stack = new LinkedList<>();
        stack.push("Java");
        stack.push("MySQL");
        stack.push("Spring");

        System.out.println("弹出：" + stack.pop() + stack.pop() + stack.pop());
    }
//题目6：LinkedList模拟队列
//使用LinkedList实现队列。
//添加：
//A、B、C。
//要求按照先进先出输出。
    private static void demo06(){
        //也就是说，每次新添加的都在头，每次删除的都在尾
        LinkedList<String> queue = new LinkedList<>();
        queue.addFirst("A");
        queue.addFirst("B");
        queue.addFirst("C");
        System.out.println("出队列：" + queue.removeLast() + queue.removeLast() + queue.removeLast());
    }
//题目7：HashSet字符串去重
//创建HashSet<String>。
//添加：
//java、mysql、java、spring、mysql、redis。
//输出去重后的结果。
    private static void demo07(){
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, "java", "mysql", "java", "spring",
                "mysql", "redis");
        System.out.println("直接输出HashSet,我记得有自动不重复：" + set);
    }
//题目8：HashSet对象去重
//定义Student(name,age)，使用HashSet存储：
//张三18
//李四20
//张三18
//要求最终只有两个对象。
//重写equals和hashCode。
    private static void demo08(){
        Student08 stu1 = new Student08("张三", 18);
        Student08 stu2 = new Student08("李四", 20);
        Student08 stu3 = new Student08("张三", 18);

        HashSet<Student08> set = new HashSet<>();
        set.add(stu1);
        set.add(stu2);
        set.add(stu3);
        System.out.println("HashSet<Student08>" + set);

    }
//题目9：HashSet去重规则
//修改Student类，使姓名和年龄相同的对象认为重复。
//实现equals和hashCode。
    private static void demo09(){
       Student09 stu1 = new Student09("Barbie", 20);
       Student09 stu2 = new Student09("Barbie", 18);
       Student09 stu3 = new Student09("Ken", 20);
       Student09 stu4 = new Student09("Barbie", 20);
       Set<Student09> set = new HashSet<>();
       Collections.addAll(set, stu1, stu2, stu3, stu4);
       System.out.println("HashSet<Student09>:" + set);
    }
//题目10：LinkedHashSet保持顺序
//创建LinkedHashSet<String>。
//添加：
//bbb、aaa、ccc、bbb。
//要求输出：
//bbb、aaa、ccc。
    private static void demo10(){
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("bbb");
        set.add("aaa");
        set.add("ccc");
        set.add("bbb");
        System.out.println("LinkedHashSet<String>:" + set);
    }

//题目11：可变参数求和
//定义sum方法。
//要求支持：
//sum(1,2,3)
//sum(10,20,30,40)
//返回总和。
    private static int sum(int... intArr){
        int sum = 0;
        for(int i = 0; i < intArr.length; i++){
            sum += intArr[i];
        }
        return sum;
    }

    private static void demo11(){
        System.out.println("sum(1,2,3)结果：" + sum(1,2,3));
        System.out.println("sum(10,20,30,40)结果：" + sum(10,20,30,40));
    }
//题目12：Collections.addAll
//创建ArrayList<Integer>。
//使用Collections.addAll添加：
//5、3、8、1、6。

//题目13：Collections.sort排序
//使用Collections.sort对：
//5、3、8、1、6
//进行升序排序。
    private static void demo12_13(){
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 5,3,8,1,6);
        System.out.println("list:" + list);
        Collections.sort(list);
        System.out.println("排序后的list:" + list );
    }

//题目14：Comparator字符串排序
//创建ArrayList<String>：
//cba、aba、sba、nba。
//使用Comparator按照第一个字符降序排序。
    private static void demo14(){
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("cba", "aba", "sba", "nba"));
        System.out.println("list:" + list);
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return o2.charAt(0) - o1.charAt(0);
            }
        });
        System.out.println("list按首字母降序排序后:" +list);
    }
//题目15：Comparator学生排序
//定义Student(name,age)。
//使用Comparator按照年龄升序排序。
    private static void demo15(){
        TreeSet<Student> set = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.age - o2.age;
            }
        });
        Student stu1 = new Student("Barbie", 10);
        Student stu2 = new Student("Barbie", 12);
        Student stu3 = new Student("Barbie", 15);
        Student stu4 = new Student("Barbie", 10);
        set.add(stu1);
        set.add(stu2);
        set.add(stu3);
        set.add(stu4);
        System.out.println("TreeSet年龄升序:" + set);




    }
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
    private static void demo16(){
        List<Student> list = new ArrayList<>();
        Student stu1 = new Student("rose", 18);
        Student stu2 = new Student("jack16", 16);
        Student stu3 = new Student("abc16", 16);
        Student stu4 = new Student("ace17", 17);
        Student stu5 = new Student("mark", 16);

        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        list.add(stu4);
        list.add(stu5);
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int result = o2.age - o1.age;
                if(result == 0){
                    result = o1.name.charAt(0) - o2.name.charAt(0);
                }
                return result;
            }
        });
        System.out.println("list双层条件排序后：" + list);
    }
//题目17：Comparable自然排序
//让Student实现Comparable<Student>。
//要求Collections.sort按照年龄升序。
    private static void demo17(){
        List<Student17> list = new ArrayList<>();
        Student17 stu1 = new Student17("rose", 18);
        Student17 stu2 = new Student17("rose", 30);
        Student17 stu3 = new Student17("rose", 19);
        Collections.sort(list);

    }
//题目18：集合选择
//需求1：
//保存大量用户数据，需要频繁通过索引获取用户：
//User user = list.get(index);
//需求2：
//需要频繁在集合头部添加和删除元素。
//分别选择ArrayList还是LinkedList，并写创建代码。
//分别选择ArrayList还是LinkedList，并写创建代码。
    private static void demo18(){
        Student stu1 = new Student("rose", 18);
        Student stu2 = new Student("jack16", 16);
        Student stu3 = new Student("abc16", 16);
        Student stu4 = new Student("ace17", 17);
        Student stu5 = new Student("mark", 16);
        Student stu6 = new Student("mark", 19);
        //假设用户是Student类型，
        //根据索引查询用户获取，就是遍历？
        //1.ArrayList，头部添加可以直接add(0)，删除的话就是remove(0)
        List<Student> list = new ArrayList<>();
        list.addAll(Arrays.asList(stu1, stu2, stu3, stu4, stu5, stu6));
        //多存储一些元素才能频繁获取
        for(int i = 0; i < 1000; i++){
            list.add(new Student("学生" + i, i));
        }
        System.out.println("ArrayList学生集合：");

        //频繁读取，但不是遍历所以使用随机数的方式
        int flag = 1;
        int count = 0;

        long begin = System.currentTimeMillis();
        while(flag != 0){
            //也就是当随机到0的时候就停止
            //获取随机的学生
            flag = new Random().nextInt(1006);//这样随机数的范围就是[0,1000)
            System.out.print(list.get(flag) +",");
            count++;
        }
        long end = System.currentTimeMillis();
        System.out.println("\nArrayList频繁访问共访问了" + count + "次。" +
                "用时：" + (end - begin) + "ms");

        //频繁头部添加删除
        for(int i = 0; i < 1000; i++){
            //因为走到这flag已经随机到0了，所以换一个随机数//因为不知道要添加什么学生属性所以把while改成for
            list.add(0, new Student("学生头部" + i, i));
        }
        System.out.println("ArrayList频繁头部添加后：" + list + "\n"
        + "长度为： " + list.size());
        for(int i = 0; i < 1000; i++){
            list.remove(0);
        }
        System.out.println("ArrayList频繁头部删除后：" + list + "\n"
        + "长度为：" + list.size());



        //2.LinkedList
        LinkedList<Student> linkedList = new LinkedList<>();
        linkedList.addAll(list);
        //频繁访问
        count = 0;
        begin = System.currentTimeMillis();
        while(flag != 1){
            flag = new Random().nextInt(1006);
            System.out.print(linkedList.get(flag) +",");
            count++;
        }
        end = System.currentTimeMillis();
        System.out.println("\nLinkedList共频繁访问：" + count + "次。"
        + "用时：" + (end - begin) + "ms");
        //频繁头部添加和删除
        for(int i = 0; i < 1000; i++){
            linkedList.addFirst(new Student("头部学生" + i, i));
        }
        for(int i = 0; i < 1000; i++){
            linkedList.remove(0);
        }

    }

//题目19：HashSet统计学生数量
//学生：
//张三18
//李四19
//王五20
//张三18
//使用HashSet统计学生数量。
    private static void demo19(){
        HashSet<Student> set = new HashSet<>();
        Student stu1 = new Student("张三", 18);
        Student stu2 = new Student("李四", 19);
        Student stu3 = new Student("王五", 20);
        Student stu4 = new Student("张三", 18);

        set.add(stu1);
        set.add(stu2);
        set.add(stu3);
        set.add(stu4);
        System.out.println("HashSet存储的学生数为：" + set.size());
    }
//题目20：学生管理系统
//使用ArrayList<Student>完成：
//1. 添加学生
//2. 删除学生
//3. 修改学生
//4. 查询学生
//5. 遍历学生
    private static void demo20(){
        ArrayList<Student> list = new ArrayList<>();
        Student stu1 = new Student("rose", 40);
        Student stu2 = new Student("barbie", 18);
        Student stu3 = new Student("esther", 34);
        Student stu4 = new Student("linda", 28);

        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        list.add(stu4);

        list.remove(2);
        list.remove(stu1);
        System.out.println("查询linda" );
        Student find = null;
        for(Student stu : list){
            if("linda".equals(stu.name)){
                find = stu;
                break;
            }
        }
        if(find != null){
            System.out.println("查到的学生为：" + find);
        }

        System.out.println("遍历：");
        for(Student stu : list){
            System.out.print(stu + ",");
        }


    }
    //自己之前编写的问题
    //Comparable和Comparator有什么区别？
    //:复习自然排序的接口的2用法和比较器的3种
    //首先有一些引用对象是内部有排序规则的，比如String,自动调用集合内元素排序规则的
    // 方法主要是TreeSet,TreeMap，和Collections.sort(List<?> list)
    //题目21：使用自然排序中的方法，比较所有包装类型大小，并考虑参数的可用类型

    //问题22：给自定义类继承重写自然排序，要求自定义Student类属性有id，姓名，用id升序排序
    //并且用TreeSet,TreeMap和Collections.sort()检查排序结果

    //比较器排序
    //问题23：在自定义类中继承重写，要求Puppy类属性有id，姓名，主人和年龄。用年龄降序排序，
    // 年龄相等的情况下用id升序。
    //问题24：在TreeSet,Map和Collections.sort()创建时传入写好比较器的Puppy类？
    //还是传入已经重写了比较器的类对象？
    //问题25：在TreeSet,Map和Collections.sort()创建时传入匿名的比较器实现类

    public static void main(String[] args) {
//        demo01();
//        demo02();
//        demo03();
//        demo04();
//        demo05();
//        demo06();
//        demo07();
//        demo08();
//        demo09();
//        demo10();
//        demo11();
//        demo12_13();
//        demo14();
//        demo15();
//        demo16();
//        demo17();
//        demo18();
        demo19();
        demo20();
    }
}
