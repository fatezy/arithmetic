package leetcode.hashTable;

import java.util.*;

/**
 * author： 张亚飞
 * time：2016/5/11  22:27
 */

//Given a non-empty first.leetCode.array of integers, return the k most frequent elements.
//
//        For example,
//        Given [1,1,1,2,2,3] and k = 2, return [1,2].
    //优先队列，小的在队首
public class TopKFrequentElements_347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                int val = map.get(nums[i]);
                map.replace(nums[i],++val);

            }
        }

        return null;
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        //实现comparator接口
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (pq.size() < k) {
                //加入优先队列
                pq.offer(entry);
            } else if (entry.getValue() > pq.peek().getValue()) {
                //弹出队列
                pq.poll();
                pq.offer(entry);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : pq) {
            result.add(entry.getKey());
        }

        return result;
    }

}
