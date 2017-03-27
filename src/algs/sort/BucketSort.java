package algs.sort;

/**
 * 给定n个整数x1,x2,...,xn,求这n个整数在实轴上相邻2个数之间的最大差值M,要求设计线性的时间算法

 典型的最大间隙问题。
 要求线性时间算法。需要使用桶排序。
 对于这个题，最关键的一步是：由抽屉原理知：最大差值M>= (Max(V[n])-Min(V[n]))/(n-1)
 所以，假如以(Max(V[n])-Min(V[n]))/(n-1)为桶宽的话，答案一定不是属于同一个桶的两元素之差。
 因此，这样建桶，每次只保留桶里面的最大值和最小值即可。
 */
public class BucketSort {

    public static int bucket(long num, long len, long max, long min){
        return (int) ((num - min) * len / (max - min));
    }

    public static int maxGap(int[] nums){
        if (nums == null || nums.length < 2){
            return 0;
        }
        int len = nums.length;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++){
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] mins = new int[len + 1];
        int[] maxs = new int[len + 1];
        for (int i = 0; i < len; i++){
            int bid = bucket(nums[i], len, max, min);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int gap = 0;
        int lastMax = 0;
        int i = 0;
        while (i <= len){
            if (hasNum[i++]){
                lastMax = maxs[i - 1];
                break;
            }
        }
        for (; i <= len; i++){
            if (hasNum[i]){
                gap = Math.max(gap, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return gap;
    }
}
