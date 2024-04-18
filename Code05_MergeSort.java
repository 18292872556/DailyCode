package review.demo01Sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/15/18:53
 * @Description:
 */
public class Code05_MergeSort {
    public static void mergeSort(int[] arr) {
        if(arr == null || arr.length < 2){
            return;
        }
        process(arr, 0, arr.length-1 );
    }

    //递归
    public static void process(int[] arr, int L, int R){
        if(L == R){//说明当前区间必然有序，可以开始递归返回
            return;
        }
        int M = L + (R - L) / 2;
        process(arr, L, M);
        process(arr, M+1, R);
        merge(arr, L, M, R);
    }
    //合并左右
    public static void merge(int[] arr, int L, int M, int R){//两个数组一个[L,M]一个[M+1,R]
        int n = R - L + 1;
        int[] help = new int[n];
        int left = L;//遍历左组
        int right = M + 1;//遍历右组
        int i = 0;
        while(left <= M || right <= R){//两数组有一个没遍历完
            //先填左组进help的情况，1.右组遍历完2.左组<=右组数
            if(right > R || ( left <= M && (arr[left] <= arr[right]))){
                help[i++] = arr[left++];
            }else {//先填右组进help的情况1.左组遍历完2.左组>右组。
                /* 思考这里要不要加if条件还是直接else*/
                help[i++] = arr[right++];
            }
        }
        i = 0;
        for (i = 0; i < help.length; i++) {
            arr[L++] = help[i];
        }
    }
}
