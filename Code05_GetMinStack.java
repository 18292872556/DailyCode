package class02;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xuexuezi
 * @Date: 2023/05/12/15:44
 * @Description:
 */
public class Code05_GetMinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public class MyStack1 {//最小栈与数据栈同高，最小栈每次只填当前高度最小的值

        public void push(int newNum) {
            //!!注意：此处要考虑是否存在<=情况入最小栈。
            // 存在==情况，因为共同出栈的条件是两栈顶==时最小栈才出栈
            //如果最小栈只填小于栈顶的数的话，

            if (stackData.empty() || newNum < stackMin.peek()) {
                stackMin.push(newNum);
            } else {
                stackMin.push(stackMin.peek());
            }
            stackData.push(newNum);
        }

        public int pop() {
            if (stackData.empty()) {
                throw new RuntimeException("stack is empty");
            }
            if (stackData.peek() == stackMin.peek()) {
                stackMin.pop();
            }
            return stackData.pop();
        }

        public int getMin() {
            return stackMin.peek();
        }

    }

    public class MyStack2 {//新数比当前栈中最小值小时，才进入最小栈。只有最小栈顶与数据栈顶要出栈的数相同时，最小栈才一起出栈

        public void push(int newNum) {
            //!!注意：此处要考虑是否存在<=情况入最小栈。[4,3,8,9,1,1]
            // 存在==情况，因为共同出栈的条件是两栈顶==时最小栈才出栈
            //<如果最小栈只填小于栈顶的数的话，[4,3,1]出栈时4位的1没有对应一起出的。
            // 不算错，但不太严谨，因为最好是代表了最小值的那个数和最小栈顶一起出
            //<=小于等于入栈[4,3,1,1]出栈时4位的1和2位的1一起出栈
            if (stackData.empty() || newNum < stackMin.peek()) {// < 和 <= 都可以
                stackMin.push(newNum);
            }
            stackData.push(newNum);
        }

        public int pop() {
            if (stackData.empty()) {
                throw new RuntimeException("stack is empty");
            }
            stackMin.pop();
            return stackData.pop();
        }

        public int getMin() {
            return stackMin.peek();
        }

    }
    public static void main(String[] args){
        
    }
}
