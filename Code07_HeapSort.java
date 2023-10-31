package review.demo01Sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/15/18:53
 * @Description: 建立根堆和堆排序
 * 按堆的下标从0 开始，左孩子 2 * i + 1， 右孩子 2 * i + 2 父结点 （i - 1)/2
 * 按堆的下标从1 开始，左孩子 2 * i，右孩子 2 * i + 1 父节点 i/2。统一用这个，更快
 * i << 1 ,i << 1 + 1, i >> 1 位运算更快，扩展写
 */
 
public class Code07_HeapSort {
    // 上升看
    // 定义heapSize即表达已经收集了多少个，又表达新数位置。新数`i`位置不停往上看，
    // 即`i/2`若比父节点大则交换，若小或无父节点停止。以此来调整每一个新添加进堆的数
    public static void heapInsert(int[] arr, int index, int heapSize){//将heapSize位排入堆，并++
       //相当于默认index为新要加入堆的结点下标，这个结点前的结点都符合堆。
        // index必然==heapSize。但凡index < heapSize 说明新加的结点向上看不符合堆的同时，也可能向下看也不符合
        // index 若 > heapSize 不能保证heapSize~index之间的结点是否符合堆
       if(index != heapSize ){
           System.out.println("插入结点下标错误");
           return;
       }
        while(arr[index] > arr[(index - 1) / 2]){
            Logarithmic.swap(arr, index, (index - 1)/2);
            index = (index - 1) / 2;
        }

    }
    //下沉看
    //只有头不符合大根堆，所以下沉看
    public static void heapify(int[] arr, int index, int heapSize){//通常这里的index都是0
        int left = index * 2 + 1;
        while(index < heapSize && left < heapSize){//左孩子存在才有下沉的可能
            int right = (left + 1) < heapSize ? (left + 1) : left;//不存在的话都默认是左孩子
            int largest = arr[left] > arr[right] ? left : right;
            //此处等于时默认右孩子更大
            if(arr[index] > arr[largest]){
                break;
            }else{
                Logarithmic.swap(arr, index, largest);//与大孩子交换，下沉
                index = largest;
                left = index * 2 + 1;
            }
        }
    }
    public static void heapSort(int[] arr){
        if(arr == null || arr.length <2){
            return;
        }
        //1.先将数组调整成堆
        for(int i = 0; i < arr.length; i++){
           heapInsert(arr, i, i);//逐渐建立堆的过程，heapSize始终在已经排好的堆的后一位，
            // 即确定了堆长度，又标明了下一个新数要进入的位置
        }

        //2.弹出max最大值堆头，交换堆头尾,原堆头max填入heapSize,堆长度--，
        //调整新的头满足堆
        int heapSize = arr.length;//开始堆排时，范围为整个数组
        while(heapSize > 0){//此处heapSize代表了需要排序范围下标右界
            Logarithmic.swap(arr, 0, --heapSize);//第一次拿到最大值与尾交换
            //因为heapSize的值应该是堆后第一个的，不包含在堆内部，下沉写法和上升都是这样看待的
            heapify(arr, 0, heapSize);
        }

    }

    public static void main(String[] args) {
        int[] arr = {45,0,69,87,93};
        heapSort(arr);
        Logarithmic.printArray(arr);
    }


}
