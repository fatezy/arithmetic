package systemdesign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 简单的一致性hash算法
 * 一般的数据库进行horizontal shard的方法是指，把 id 对 数据库服务器总数 n 取模，然后来得到他在哪台机器上。这种方法的缺点是，
 * 当数据继续增加，我们需要增加数据库服务器，将 n 变为 n+1 时，几乎所有的数据都要移动，这就造成了不 consistent。为了减少这种 naive 的 hash方法(%n)
 * 带来的缺陷，出现了一种新的hash算法：一致性哈希的算法——Consistent Hashing。这种算法有很多种实现方式，这里我们来实现一种简单的 Consistent Hashing。
 * <p>
 * 将 id 对 360 取模，假如一开始有3台机器，那么让3台机器分别负责0119, 120239, 240~359 的三个部分。那么模出来是多少，查一下在哪个区间，就去哪台机器。
 * 当机器从 n 台变为 n+1 台了以后，我们从n个区间中，找到最大的一个区间，然后一分为二，把一半给第n+1台机器。
 * 比如从3台变4台的时候，我们找到了第3个区间0119是当前最大的一个区间，那么我们把0119分为059和60119两个部分。059仍然给第1台机器，60119给第4台机器。
 * 然后接着从4台变5台，我们找到最大的区间是第3个区间120239，一分为二之后，变为 120179, 180~239。
 * 假设一开始所有的数据都在一台机器上，请问加到第 n 台机器的时候，区间的分布情况和对应的机器编号分别是多少？
 * <p>
 * <p>
 * 假定一开始有360台机器
 *
 * @author 张亚飞
 * @create 2019-11-24 20:40
 **/
public class ConsistentHashing {
    private static int shardCount = 360;

    /**
     * 一共有多少台服务器
     *
     * @param n
     * @return
     */
    public static List<List<Integer>> consistentHashing(int n) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        res.add(Arrays.asList(0, 359, 1));
        for (int i = 2; i <= n; i++) {
            //遍历处理最多shard的机器
            int maxShard = -1;
            int maxShardIndex = -1;
            for (int j = 0; j < res.size(); j++) {
                List<Integer> lineList = res.get(j);
                if (lineList.get(1) - lineList.get(0) > maxShard) {
                    maxShard = lineList.get(1) - lineList.get(0);
                    maxShardIndex = j;
                }
            }
            List<Integer> lineList = res.get(maxShardIndex);
            int start = lineList.get(0);
            int end = lineList.get(1);
            int mid = (lineList.get(0) + lineList.get(1)) / 2;
            res.remove(maxShardIndex);
            res.add(maxShardIndex, Arrays.asList(start, mid, maxShardIndex));
            res.add(maxShardIndex + 1, Arrays.asList(mid + 1, end, maxShardIndex+1));
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(consistentHashing(5));

    }


}
