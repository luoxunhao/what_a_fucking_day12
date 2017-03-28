package test;

/**
 * 2017网易实习数据挖掘工程师
 *
 * 易老师购买了一盒饼干，盒子中一共有k块饼干，但是数字k有些数位变得模糊了，看不清楚数字具体是多少了。
 * 易老师需要你帮忙把这k块饼干平分给n个小朋友，易老师保证这盒饼干能平分给n个小朋友。
 * 现在你需要计算出k有多少种可能的数值
 *
 输入描述:
 输入包括两行：
 第一行为盒子上的数值k，模糊的数位用X表示，长度小于18(可能有多个模糊的数位)
 第二行为小朋友的人数n


 输出描述:
 输出k可能的数值种数，保证至少为1

 输入例子:

 9999999999999X
 3

 输出例子:

 4
 */

/*
思路：通过手动写除法我们发现，1个数在除以一个数的过程中，是从前往后一位一位除的，能否除的尽，
要看前面的余数和当前的数的组合能否除的尽，所以要记录前面一位所有的余数可能性。比如 ：
X2
2
X除2的余数可能是0 ，1，是0的可能性为0,2,4,6,8 五种，取1的可能性为1 3 5 7 9 也是五种，
这个时候再看2，2和前面的余数0,1,的组合为02，或者12，
也就是说到了这一位余数为0的可能性为上一位余数为0,1可能性的和，因为02,12对2的余数都是为0,k=5+5=10;
 */
public class AllotCookies {
    public static long allotCookies(String s, int n){
        char[] ch = s.toCharArray();
        long[][] dp = new long[s.length()][n];
        dp[0][0] = 1;
        for (int i = 0; i < ch.length; i++){
            for (int j = 0; j < n; j++){ //所取值余数的可能性
                for (int k = 0; k < 10; k++){ //这一位所能取的数
                    if(ch[i-1]-'0' != k && ch[i-1] <= '9' && ch[i-1] >= '0') { //若是x计算所有可能取值，若不是就计算当前这一种取值
                        continue;
                    }
                    int t= (j*10+k)%n;//计算当前值和前一位余数的取值组合所产生的余数
                    dp[i][t] += dp[i-1][j];//迭代为下一位做准备
                }
            }
        }
        return dp[ch.length][0];
    }
}
