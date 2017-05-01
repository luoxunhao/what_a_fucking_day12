package test.baidu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lxh on 2017/5/1.
 */
public class Main3 {
    static class Point{
        int x;
        int y;
        int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double distance(Point A, Point B){
            return Math.sqrt(
                    Math.pow(A.x - B.x, 2) + Math.pow(A.y - B.y, 2) + Math.pow(A.z - B.z, 2)
            );
        }
    }

    private static int n;
    private static ArrayList<Point> R = new ArrayList<>();
    private static ArrayList<Point> G = new ArrayList<>();
    private static ArrayList<Point> B = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < n; i++){
                String[] str = sc.nextLine().split(" ");
                int x = Integer.valueOf(str[1]);
                int y = Integer.valueOf(str[2]);
                int z = Integer.valueOf(str[3]);
                if (str[0].equals("R")){
                    R.add(new Point(x,y,z));
                }else if(str[0].equals("G")){
                    G.add(new Point(x,y,z));
                }else {
                    B.add(new Point(x,y,z));
                }
            }
            System.out.printf("%.5f",maxArea());
        }
    }

    public static boolean isTri(Point A, Point B, Point C){
        double dis1 = A.distance(A, B);
        double dis2 = A.distance(A, C);
        double dis3 = A.distance(C, B);
        double min = Math.min(Math.min(dis1, dis2), dis3);
        double mdm = Math.min(Math.max(dis1, dis2), dis3);
        double max = Math.max(Math.max(dis1, dis2), dis3);
        if (min + mdm > max){
            return true;
        }
        return false;
    }

    public static double area(Point A, Point B, Point C){
        double dis1 = A.distance(A, B);
        double dis2 = A.distance(A, C);
        double dis3 = A.distance(C, B);
        double p = (dis1 + dis2 +dis3) / 2;
        return Math.sqrt(p * (p - dis1) * (p - dis2) * (p - dis3));
    }

    public static double maxArea(){
        if (n < 3){
            return 0.0;
        }
        double res = 0.0;
        if (R.size() >= 3){
            for (int i = 0; i < R.size(); i++){
                for (int j = i+1; j < R.size(); j++){
                    for (int k = j+1; k < R.size(); k++){
                        if (isTri(R.get(i), R.get(j), R.get(k))){
                            res = Math.max(res, area(R.get(i), R.get(j), R.get(k)));
                        }
                    }
                }
            }
        }
        if (G.size() >= 3){
            for (int i = 0; i < G.size(); i++){
                for (int j = i+1; j < G.size(); j++){
                    for (int k = j+1; k < G.size(); k++){
                        if (isTri(G.get(i), G.get(j), G.get(k))){
                            res = Math.max(res, area(G.get(i), G.get(j), G.get(k)));
                        }
                    }
                }
            }
        }
        if (B.size() >= 3){
            for (int i = 0; i < B.size(); i++){
                for (int j = i+1; j < B.size(); j++){
                    for (int k = j+1; k < B.size(); k++){
                        if (isTri(B.get(i), B.get(j), B.get(k))){
                            res = Math.max(res, area(B.get(i), B.get(j), B.get(k)));
                        }
                    }
                }
            }
        }
        if (R.size() > 0 && G.size() > 0 && B.size() > 0){
            for (int i = 0; i < R.size(); i++){
                for (int j = 0; j < G.size(); j++){
                    for (int k = 0; k < B.size(); k++){
                        if (isTri(R.get(i), G.get(j), B.get(k))){
                            res = Math.max(res, area(R.get(i), G.get(j), B.get(k)));
                        }
                    }
                }
            }
        }
        return res;
    }
}
