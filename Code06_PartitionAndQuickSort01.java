package review.demo01Sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/23/22:50
 * @Description: 快排1.0 分区用Partition,1次只能确定1个X的位置
 * 排序范围[L,R]
 * 1、Partition的分区是[<= X, > X的自然剩余]，
 * 比较时<= X区域的标志lessEqual初始L-1， <= lessEqual的左侧下标为小于等于区
 * 2、取arr[R]为X，用index遍历数组[L,R]时，若<=X，则与lessEqual的后一位交换，再lessEqual++
 * 使小于等于区右扩。若 > X 继续遍历
 * 3、直到index遍历到R位置，结束划分，将X与 <= 区后一位交换，则X这1位排序完成。
 * 4、通过递归使排序整个数组，每次先排序整体[L,R]，返回X 排好的位置，以这个值作为中值
 * 再分别排序两侧数，直到进入递归时只有一个数说明其他位已经排序好，只剩这一位在这个位置，递归返回。
 */
public class Code06_PartitionAndQuickSort01 {

    public static void quickSort01(int arr[]){
        if(arr == null || arr.length < 2){
            return;
        }
        process01(arr, 0, arr.length - 1);
    }
    public static void process01(int[] arr, int L, int R){
        if(L >= R){
            return;
        }
        int M = partition(arr, L, R);
        process01(arr, L, M - 1);
        process01(arr, M + 1, R);
    }
    public static int partition(int[] arr, int L, int R){
        if(L > R){
            return -1;//返回一个不存在的下标
        }
        if(L == R){//有序，返回
            return L;
        }
        int lessEqual = L - 1;
        int X = arr[R];
        for (int i = L; i < R; i++) {
            if(arr[i] <= X){
                Logarithmic.swap(arr, ++lessEqual, i);
            }
        }
        Logarithmic.swap(arr, R, ++lessEqual);
        return lessEqual;
    }


}
