package review.demo01Sort;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/07/10:08
 * @Description: 冒泡排序 排序两个数组，一个最差。一个普通
 * [9,8,7,6,5,4,3,2,1,0] [1,4,5,3,8,9,2,1,2,0]
 *
 *
 */
public class Code01_BubbleSort {
    public static void bubbleSort(int[] arr){
        int n = arr.length;

        for (int i = n - 1; i > 0 ; i--) {//控制每趟排序末尾的范围[n-1, 1]，每趟排序范围头都为0
            for(int j = 0; j < i; j++){//比较两数，[0, i -1] 是否> [1, i]
                if(arr[j] > arr[j + 1]){
                    Logarithmic.swap(arr, j, j + 1);
                }
            }
        }
    }
}
