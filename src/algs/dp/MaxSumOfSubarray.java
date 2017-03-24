package algs.dp;

/**
 * 连续子数组最大和
 */
public class MaxSumOfSubarray {

    public static int maxSumOfSubarray(int[] array){
        int dp = array[0], max = Integer.MIN_VALUE;
        //dp[i]表示必须以i结尾的子数组的最大和
        for (int i = 0; i < array.length; i++){
            if (dp < 0){
                dp = array[i];
            }else {
                dp = dp + array[i];
            }
            max = Math.max(max, dp);
        }
        return max;
    }

    public static void main(String[] args){
        int [] array = {1,-2,3,5,-2,6,-1};
        System.out.print(maxSumOfSubarray(array));
    }
}
