package review.demo01Sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/15/18:52
 * @Description:
 */
public class Code02_SelectSort {
    public static void selectSort(int[] arr){

        for (int i = 0; i <= arr.length - 2; i++) {//确定头边界，到length-2时是最后一个头，length-1被比较过必然有序。无需当头
            int minIndex = i;//开始错误，把这句写在外面了。
            for (int j = i; j <= arr.length - 1; j++) {
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            Logarithmic.swap(arr, minIndex, i);//交换这趟的最小值，和这趟的头

        }
    }
}
