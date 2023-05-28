package class02;


import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xuexuezi
 * @Date: 2023/05/12/15:45
 * @Description:两个队列组成一个栈
 */
public class Code07_TwoQueueImplementStack<T> {
    public static class TwoQueueStack<T>{
        public Queue<T> queue;
        public Queue<T> help;
        public void push(T value){
            queue.offer(value);
        }
        public T pop(){
            while(queue.size() > 1){
                help.offer(queue.poll());
            }
            Queue<T> tmp = help;
            help = queue;
            queue = tmp;
            return help.poll();
        }
        public T peek(){
            while(queue.size() > 1){
                help.offer(queue.poll());
            }
            return queue.peek();
        }
        public boolean isEmpty(){
            return queue.size() == 0;
        }
    }

    public static void main(String[] args){
        System.out.println("test begin");
        TwoQueueStack<Integer> myStack = new TwoQueueStack<>();
        Stack<Integer> test = new Stack<>();
        int testTime = 10000;//测试次数
        int max = 10000;//入队列的最大值
        for (int i = 0; i < testTime; i++) {
            if (!myStack.isEmpty()) {
                if (test.empty()) {
                    System.out.println("Oops0");
                }
            }
            int num = (int) (Math.random() * (max + 1));

            if(Math.random() > 0.75){//入两栈
                test.push(num);
                myStack.push(num);
            }else if(Math.random() > 0.5){//判断两栈顶是否同
                if(test.peek() != myStack.peek()){
                    System.out.println("Oops1");
                }
            }else if(Math.random() > 0.25){//判断出栈是不是同
                if(test.pop() != myStack.pop()){
                    System.out.println("Oops2");
                }
            }else{//判断是否都为空，或都不为
                if(test.empty() != myStack.isEmpty()){
                    System.out.println("Oops3");
                }
            }

        }
        System.out.println("test finish!");
    }
}
