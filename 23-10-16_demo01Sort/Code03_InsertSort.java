package review.demo01Sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/15/18:52
 * @Description:
 */
public class Code03_InsertSort {
    public static void insertSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            for(int j = i; j > 0; j--){
                if(arr[j] < arr[j-1]){
                     Logarithmic.swap(arr, j, j - 1);
                }else{
                    break;//这趟i位数插入结束
                }
            }
        }
    }
}
