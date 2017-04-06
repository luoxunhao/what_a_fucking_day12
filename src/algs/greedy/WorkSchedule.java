package algs.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 工作调度
 * 有n项工作，每项工作分别在si时间开始，在ti时间结束。
 * 对于每项工作，你都可以悬着参加与否。如果选择参与，
 * 那么必须全程参与。此外，参与工作的时间段不能重叠，
 * 包括开始和结束的瞬间都不行。目标是参与尽可能多的工作。
 *
 * 贪心：在可选的工作中，每次选取结束时间最早的工作。
 */
public class WorkSchedule {

    private static class Pair implements Comparable{
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Object o) {
            Pair tmp = (Pair)o;
            if (this.end < tmp.end){
                return -1;
            }else if (this.end == tmp.end){
                return 0;
            }else {
                return 1;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            Pair[] pairs = new Pair[n];
            int s = 0, t = 0;
            for (int i = 0; i < n; i++){
                s = sc.nextInt();
                t = sc.nextInt();
                pairs[i] = new Pair(s,t);
            }
            System.out.println(solve(pairs,n));
        }
    }

    public static int solve(Pair[] pairs, int n){
        Arrays.sort(pairs); //按结束时间升序
        int res = 0, t = 0;
        for (int i = 0; i < n; i++){
            if (t < pairs[i].start){
                res++;
                t = pairs[i].end;
            }
        }
        return res;
    }
}
