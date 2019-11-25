package systemdesign;

import java.util.*;

/**
 * 一致性hash算法
 * <p>
 * 为了解决这个问题，引入了 micro-shards 的概念，一个更好的算法是这样：
 * <p>
 * 1. 将 360° 的区间分得更细。从 0~359 变为一个 0 ~ n-1 的区间，将这个区间首尾相接，连成一个圆。
 * 2. 当加入一台新的机器的时候，随机选择在圆周中撒 k 个点，代表这台机器的 k 个 micro-shards。
 * 3. 每个数据在圆周上也对应一个点，这个点通过一个 hash function 来计算。
 * 4. 一个数据该属于那台机器负责管理，是按照该数据对应的圆周上的点在圆上顺时针碰到的第一个 micro-shard 点所属的机器来决定。
 * <p>
 * n 和 k在真实的 NoSQL 数据库中一般是 2^64 和 1000。
 * <p>
 * 请实现这种引入了 micro-shard 的 consistent hashing 的方法。主要实现如下的三个函数：
 * <p>
 * 1. create(int n, int k)
 * 2. addMachine(int machine_id) // add a new machine, return a list of shard ids.
 * 3. getMachineIdByHashCode(int hashcode) // return machine id
 *
 * @author 张亚飞
 * @create 2019-11-25 10:48
 **/
public class ConsistentHashingII {
    private static int[] hashToMachine;
    private static int shardsPerMachine;
    private static int maxShards;
    private static int availableShards;


    public static ConsistentHashingII create(int n, int k) {
        ConsistentHashingII solution = new ConsistentHashingII();

        solution.maxShards = n;
        solution.shardsPerMachine = k;
        solution.availableShards = n;
        solution.hashToMachine = new int[n];

        Arrays.fill(hashToMachine, -1);

        return solution;
    }


    public List<Integer> addMachine(int machine_id) {
        //没有可用的分片
        if (shardsPerMachine > availableShards) {
            return new ArrayList<Integer>();
        }

        List<Integer> shards = randomNumber();

        for (Integer i : shards) {
            hashToMachine[i] = machine_id;
        }

        availableShards -= shardsPerMachine;
        Collections.sort(shards);
        return shards;
    }

    public int getMachineIdByHashCode(int hashcode) {
        int ret = hashcode % maxShards;

        while (hashToMachine[ret] == -1) {
            ret = (ret + 1) % maxShards;
        }

        return hashToMachine[ret];
    }

    private static List<Integer> randomNumber() {
        Set<Integer> dupCheck = new HashSet<Integer>();
        List<Integer> ret = new ArrayList<Integer>();
        Random r = new Random();

        while (ret.size() < shardsPerMachine) {
            int candidate = r.nextInt(maxShards);

            if (dupCheck.contains(candidate) || hashToMachine[candidate] != -1) {
                continue;
            }

            ret.add(candidate);
            dupCheck.add(candidate);
        }

        return ret;
    }


}
