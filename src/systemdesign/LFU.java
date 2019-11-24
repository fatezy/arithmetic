package systemdesign;

import lombok.Data;
import lombok.experimental.Accessors;
import offer.findInPartiallySortedMatrix_03.FindTest;
import sun.applet.resources.MsgAppletViewer;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 缓存算法
 * 最近最少被使用算法
 *
 * @author 张亚飞
 * @create 2019-11-24 21:36
 **/
public class LFU {
    private static Map<Integer,LFU.Entry> cache;
    private static PriorityQueue<Entry> priorityQueue;
    private final static Integer size = 3;
    LFU(){
        cache = new HashMap<>();
        priorityQueue = new PriorityQueue<>();
    }

    public void set(Integer key,Integer val){
        if (cache.size() >=3){
           Entry entry =  priorityQueue.poll();
           cache.remove(entry.getKey());
        }
        Entry e = new Entry(key,val);
        cache.put(key,e);
        priorityQueue.add(e);
    }

    public Integer get(Integer key){
        Entry e = cache.get(key);
        if (e == null){
            return -1;
        }
        return e.get(key);
    }

    //cache实体
    class Entry implements Comparable<LFU.Entry>{
        private Integer key;
        private Integer val;
        private Integer userTime;
        Entry(Integer key,Integer val){
            this.key = key;
            this.val = val;
            userTime = 0;
        }

        public Integer getUserTime() {
            return userTime;
        }

        public Integer getKey() {
            return key;
        }

        public void setUserTime(Integer userTime) {
            this.userTime = userTime;
        }

        @Override
        public int compareTo(Entry o) {
            if (this.userTime .equals(o.getUserTime())){
                return 0;
            }else if (this.userTime > o.getUserTime()){
                return 1;
            }else {
                return -1;
            }
        }

        public Integer get(Integer key){
            userTime += 1;
            return val;
        }

    }


    public static void main(String[] args) {
        LFU lfu = new LFU();
        lfu.set(2,2);
        lfu.set(1,1);
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(2));
        lfu.set(3,3);
        lfu.set(4,4);
        System.out.println(lfu.get(3));

    }

}

