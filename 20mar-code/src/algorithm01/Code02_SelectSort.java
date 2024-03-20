package algorithm01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/03/20/22:16
 * @Description:
 */
public class Code02_SelectSort {
    public static void selectSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){//i控制左边界
            int minIndex = i;
            for(int j = i; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    //为了稳定性，所以没有<=
                    minIndex = j;
                }
            }
            MainTest.swap(arr, i, minIndex);//最小位置和该趟的头位置交换
        }
    }
}
