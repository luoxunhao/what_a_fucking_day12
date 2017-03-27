package algs.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 实现一个数据结构，其中包含两个函数，1.插入一个数字，2.获得中位数
 *
 * 维护一个最大堆和一个最小堆， 首先先将前两个元素中较大的加入最小堆，较小的加入最大堆。
 * 然后每次添加新元素的时候，先将其与最大堆和最小堆的堆顶进行对比，
 如果其大于最小堆堆顶则插入最小堆，如果其小于最大堆堆顶则插入最大堆，否则选择元素数量
 较小的一堆。 在插入与向上调整结束后， 如果两堆的元素数量差大于 1（即为 2），则从元素数量
 较多的一堆中取出堆顶插入另一堆，两堆相应进行向下向上调整，这样可以保证两堆元素数量始
 终是平衡的。 在这种情况下，选取中位数只需要选取元素数量多 1 的一堆的堆顶，或者两堆元素
 数量相同的时候选择两堆堆顶的平均数即可。

 利用这种最大堆和最小堆实现的数据结构——优先队列
 在可以直接使用jdk类库的情况下，可以利用优先队列类来完成设计

 解决方法，创建一个最大值优先的优先队列，将其记为左队列ql，创建一个最小值优先的优先队列，将其记为右队列qr，

 我们规定ql不为空时，ql.peek()为中位值,记为mid，对于push(k)，如果k>mid，则将k压入右边优先队列qr，如果k<=mid则将其压入

 左边优先队列ql，然后将左右两个队列做平衡处理。pop()则只需将ql.top()的值弹出后做平衡处理即可。这种方法和快排算法中将

 一个序列分成大于mid的和小于等于mid的两部分的做法相似。
 */
public class MedianContainer {

    public static PriorityQueue<Integer> ql = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > o2){
                return -1;
            }else {
                return 1;
            }
        }
    });
    public static PriorityQueue<Integer> qr = new PriorityQueue<Integer>();
    public static int ls = 0;
    public static int rs = 0;

    public static void push(int k){
        if (ls == 0){
            ql.add(k);
            ls++;
            return;
        }
        int mid = ql.peek();
        if (k > mid){
            qr.add(k);
            rs++;
        }else {
            ql.add(k);
            ls++;
        }
        balance();
    }

    public static double peek(){
        if (ls == rs){
            return (ql.peek() + qr.peek()) / 2.0;
        }else {
            return ql.peek();
        }
    }

    public static int pop(){
        if (ls <= 0){
            throw new RuntimeException("No Element.");
        }
        int res = ql.peek();
        ql.poll();
        ls--;
        balance();
        return res;
    }

    public static void balance(){
        int idx = (ls + rs + 1) / 2;
        while (ls < idx){
            int k = qr.peek();
            ql.add(k);
            qr.poll();
            ls++;
            rs--;
        }
        while (ls > idx){
            int k = ql.peek();
            qr.add(k);
            ql.poll();
            ls--;
            rs++;
        }
    }

    public static void main(String[] args){
        MedianContainer.push(3);
        MedianContainer.push(1);
        MedianContainer.push(5);
        //MedianContainer.push(2);
        //MedianContainer.push(4);
        System.out.println(MedianContainer.peek());
    }
}
