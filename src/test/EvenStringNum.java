package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by lxh on 2017/3/25.
 */
public class EvenStringNum {
    /**
     * 这个函数判断子串是不是偶串
     * 因为偶串的长度必须是偶数，所以先判断一下子串长度
     * 每个字符出现的次数：
     *    这是一个常用的思路，利用哈希表来统计词频，哈希表的查询时间复杂度是O(1)，但是要耗费一定的内存空间，典型的空间换时间的方法
     *    具体思路：
     *    每来遍历到位置i，判断相应的字符是不是在哈希表中，如果在，就把该字符的词频加一；如果不在，直接把<该字符，1>放到表里面
     * @param s
     * @param start  子串开始位置
     * @param end 子串结束位置
     * @return
     */
    public static boolean isEven(String s, int start, int end){
        int len = end - start + 1;
        if ((len & 1) == 1){ //这句话其实就是if((len % 2) == 1)判断长度是不是偶数，用位运算来做一个代码层次的优化
            return false;
        }
        //哈希表key=字符，value=字符出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = start; i < end + 1; i++){
            //判断相应的字符是不是在哈希表中
            if (map.containsKey(s.charAt(i))){  //存在
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }else { //不存在
                map.put(s.charAt(i), 1);
            }
        }
        //去哈希表里面逐个查询
        for (Map.Entry kv : map.entrySet()){
            if (((Integer) kv.getValue() & 1) == 1){ //如果字符出现次数是奇数
                return false;
            }
        }
        return true;
    }

    public static int evenStringNumber(String s){
        int num = 0;
        //查询思路：暴力枚举，目前还想不到更好的思路，时间复杂度O(n^2/4)
        for (int i = 0; i < s.length(); i++){  //从字符串的0位置开始，逐个构造偶串
            int start = i;
            for (int j = 1; start + j < s.length() ;j += 2){ //这里的结尾指针步长设置为2，是因为只有偶数长度的字符串才有可能是偶串，查询范围直接缩小一半
                int end = start + j;
                if (end < s.length() && isEven(s, start, end)){
                    num++;
                }
            }
        }
        return num;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(evenStringNumber(s));
        }
    }
}
