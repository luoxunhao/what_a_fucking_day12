package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 游戏网站提供若干升级补丁，每个补丁大小不一，玩家要升级到最新版，如何选择下载哪些补丁下载量最小。
 */
public class UpdateGame {
/*
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ConcurrentPrint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		HashMap<Integer, Integer> ma=new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		map.put(n, 0);
		while(sc.hasNext()){
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			Integer in = map.get(b);
			int t=map.get(a)+c;
			if(in==null||in>t){
				map.put(b, t);
				ma.put(b, a);
			}
		}
		Integer in=m;
		ArrayList<Integer> al=new ArrayList<Integer>();
		while((in=ma.get(in))!=null){
			al.add(in);
		}
		for(int i=al.size()-1;i>=0;i--){
			System.out.print(al.get(i));
			System.out.print("->");
		}
		System.out.print(m);
		System.out.println("("+map.get(m)+")");
		sc.close();
	}

}
 */
}