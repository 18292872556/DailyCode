package class02;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xuexuezi
 * @Date: 2023/05/12/15:44
 * @Description:
 */
public class Code04_RingArray {
    public static class MyQueue{
        public int[] arr;
        int pushi;//队尾进数
        int polli;//队头出数
        int size;
        final int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            int pushi = 0;
            int polli = 0;
            int size = 0;
            this.limit = limit;
        }

        public void push(int value){
            if(size == limit){
                throw new RuntimeException("队列满了，不可入");
            }
            arr[pushi] = value;
            size++;
            pushi = nextIndex(pushi);
        }

        public int pop(){
            if(size == 0){
                throw new RuntimeException("队列空了，不可出");
            }
            int poll = arr[polli];
            size--;
            polli = nextIndex(polli);
            return poll;
        }
        public boolean isEmpty(){
            return size == 0;
        }
        public int nextIndex(int i){//判断坐标是否合法
            return i > limit-1?0:i+1;
        }
    }

}
