package algorithm01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/03/20/22:24
 * @Description:
 */
public class Code03_InsertSort {
    public static void insertSort(int[] arr){
        if(arr == null){
            return;
        }
        for(int i = 1; i < arr.length; i++){//[0,i-1]范围上有序
            for(int j = i; j > 0; j--){//要跟前一位比较，j不取0位
                if(arr[j - 1] > arr[j]){
                    MainTest.swap(arr, j,j-1);
                }else{
                    break;//防止，已经不比前一位小了，依然j--判断前几位，但是就算判断了也不影响结果，只是多跑几步而已。因为前几位一定有序
                }
            }
        }
    }
}
