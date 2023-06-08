package class03;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xuexuezi
 * @Date: 2023/06/01/15:37
 * @Description: 小和，一个数组中，一个数左边比他小的数的和为这个数的小和，数组的小和为所有数的小和相加
 * 核心思路：1.不求单个数的小和，直接求数组的小和，比如数组[4,5,1,2,3]中比较1比右侧的，2,3,小则产生两个为1的小和
 * 2.用归并排序的方法，在每一次排序比较数字时顺便产生小和，每次两指针都在组头向后走进行比较，
 * 3.若左右组的数字比较相等的情况下例如左组3记为a,右组3记为b，先拷贝b到help数组
 * （即以左组为基准，1）即相同情况保留左组数先拷贝右数组那个数出去2）并且右边有多少个数比她大，就产生几个这个较小数作为小和）
 * ，保留a继续与右组后续数产生比较，
 * **因为右组往后走可能出现比a更大的从而产生小和，但是b比他小的已经在左组的a之前全部与b比较过产生过小和了**
 *
 * 大和，指针从组尾开始比较，以右组为基准
 * （即 1）相同情况保留右组数先拷贝左数组那个数出去2）左边有多少个数比她小，就产生几个这个较大数作为大和**
 */
public class Code02_SmallSum {
    public static int smallSum(int[] arr){

    }
    //递归排序并加返回值的小和
    public static int process (int[] arr, int l, int r){
        if(null == arr || arr.length < 2){
            return 0;//一个数没有小和
        }
        if(l == r){
            return 0;//小和
        }
        int m = l + ((r - l) >> 1);
        return process(arr, l, m) +
                process(arr, m+1, r) +
                merge(arr,l,m,r);//左侧内部排序和小和+右侧内部排序和小和+归并当前长度和算当前长度小和
    }
    //归并排序统计小和，[l,M]有序[M+1,R]上有序
    public static int merge(int[] arr, int L, int M, int R){
        if(L > M || L > R || M > R){
            throw new RuntimeException ("下标错误");

        }
        int mergeSize = 1;//单组长
        int p1 = L;
        int p2 = M+1;
        int i = 0;
        int[] help = new int[arr.length];
        int sum = 0;
        while(p1 <= M && p2 <= R){
            if(arr[p1] < arr[p2]){
                //产生R-p2+1个小和arr[p1]
                sum += (R-p2+1)*arr[p1];
                help[i++] = arr[p1++];
            }else{//相等的情况先拷贝右组，因为左组这个数还要与右组后序其他数产生小和
                help[i++] = arr[p2++];
            }
        }
        while(p1 <= M){//说明直接拷剩下的左组
            //考虑其中一指针越界，还会不会产生小和：不会
            help[i++] = arr[p1++];
        }
        while(p2 <= R){
            help[i++] = arr[p2++];
        }
        return sum;
    }
    //--------------fot test----------------------
    public static int comparator(int[] arr){

    }
    public static int[] generateRandomArray(int maxSize, int maxValue){

    }
}