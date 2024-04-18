package review.demo01Sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/23/22:51
 * @Description: 快排2.0
 * NetherlandsFlag 分区[< X, == X, > X]，less区 Equal区，more区。X = arr[R]
 * 指针只用less和more，遍历到的index位置数，若arr[index] < X，与++less位交换，index++。
 * 若==X，继续遍历index++，若 > X，与--more区交换，再检查交换过来的是否 > X,index停留。
 * 当index == more时，排序结束。交换R和more 位置
 * 此时[L,less]全 < X, [less+1, more]为全 == X，把这两个边界值按一个长度为2数组的形式返回，
 * [more+1, R]全 > X
 */
public class Code06_NetherlandFlagAndQuickSort02And03 {
    //快排2.0
    public static void quickSort02(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process02(arr, 0, arr.length - 1);
    }
    public static void process02(int[] arr, int L, int R){
        if(L >= R){
            return;
        }
        int[] equalArea = netherLandFlag(arr, L, R);
        process02(arr, L, equalArea[0] - 1);
        process02(arr, equalArea[1] + 1, R);
    }
    public static int[] netherLandFlag(int[] arr, int L, int R){
        if(L > R){
            return new int[]{-1, -1};
        }
        if(L == R){
            return new int[]{L, R};
        }

        int less = L - 1;
        int more = R;
        int X = arr[R];
        int index = L;
        while(index < more){
            if(arr[index] < X){
                Logarithmic.swap(arr, index++, ++less);
            }else if(arr[index] > X){
                Logarithmic.swap(arr, index, --more);
            }else{
                index++;
            }
        }
        //排序结束后，交换X和大于区的第一位。返回equal区间坐标
        Logarithmic.swap(arr, R, more);
        return new int[]{less + 1, more};//等于区的左和等于区的右

    }
    //快排3.0 跟快排2.0一样，都用netherLandFlag 分区
    // 其他都跟快排2.0一样，只有X取得方法是，在[L,R]范围内随机找到一个数跟arr[R]交换
    //以新的arr[R]做X
    public static void quickSort03(int [] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process03(arr, 0, arr.length - 1);
    }
    public static void process03(int[] arr, int L, int R){
        if(L >= R){
            return;
        }
        int random = L + (int)(Math.random()) * (R - L + 1);
        Logarithmic.swap(arr, random, R);

        int[] equalArea = netherLandFlag(arr, L, R);
        process03(arr, L, equalArea[0] - 1);
        process03(arr, equalArea[1] + 1, R);
    }
}
