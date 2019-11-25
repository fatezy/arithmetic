package systemdesign;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 缓存算法
 * 最近最少使用算法
 *
 * @author 张亚飞
 * @create 2019-11-25 9:49
 **/
public class LRU {
    //get队列
    private LinkedList<Integer> getQueue;
    private Map<Integer,Integer> cache;
    private static final Integer capacity = 2;

    LRU(){
        getQueue = new LinkedList<>();
        cache = new HashMap<>();
    }

    public Integer get(Integer key){
        getQueue.remove(key);
        getQueue.add(key);
        if (!cache.containsKey(key)){
            return -1;
        }
        return cache.get(key);
    }

    public void set(Integer key,Integer val){
        getQueue.add(key);
        if (cache.size() < 2) {
            cache.put(key, val);
        }else {
            Integer removeKey = getQueue.pollFirst();
            cache.remove(removeKey);
            cache.put(key,val);
        }
    }


    public static void main(String[] args) {
        LRU lru = new LRU();
        lru.set(2,1);
        lru.set(1,1);
        System.out.println(lru.get(2));
        lru.set(4,1);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
    }

}
