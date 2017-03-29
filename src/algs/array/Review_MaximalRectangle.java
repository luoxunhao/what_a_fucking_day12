package algs.array;

/**
 * 最大子矩阵大小
 */
public class Review_MaximalRectangle {
    public static int findMinIndex(int[] arr, int left, int right){
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = left; i < right+1; i++){
            if (arr[i] < min){
                min = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static int getMaxRectangleArea(int[] arr, int left, int right){
        int maxArea = 0;
        if (left <= right){
            int minIndex = findMinIndex(arr, left, right);
            maxArea = (right - left + 1) * arr[minIndex];
            maxArea = Math.max(maxArea, getMaxRectangleArea(arr,left,minIndex-1));
            maxArea = Math.max(maxArea, getMaxRectangleArea(arr,minIndex+1,right));
        }
        return maxArea;
    }

    public static int maxRectInHist(int[] arr){
        int left = 0;
        int right = arr.length-1;
        return getMaxRectangleArea(arr,left,right);
    }

    public static int maxRectSize(int[][] map){
        int[] hist = new int[map[0].length];
        int maxSize = Integer.MIN_VALUE;
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < hist.length; j++){
                hist[j] = map[i][j] == 0 ? 0 : hist[j]+1;
            }
            maxSize = Math.max(maxSize, maxRectInHist(hist));
        }
        return maxSize;
    }
    public static void main(String[] args){
        int[][] map = {{1,1,1,0}};
        System.out.println(maxRectSize(map));
    }
}
