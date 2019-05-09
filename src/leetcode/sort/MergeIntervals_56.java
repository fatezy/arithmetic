package leetcode.sort;

import java.util.*;

/**
 * author： 张亚飞
 * time：2016/8/4  10:59
 */
//Given a collection of intervals, merge all overlapping intervals.
//
//        For example,
//        Given [1,3],[2,6],[8,10],[15,18],
//        return [1,6],[8,10],[15,18].
public class MergeIntervals_56 {
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
               if ((o1.start-o2.start)>0){
                   return 1;
               }else if ((o1.start-o2.start)<0){
                   return -1;
               }else {
                   return 0;
               }

            }
        });
        for (int i = 0; i <intervals.size() ; i++) {
            if (list.isEmpty()){
                list.add(intervals.get(i));
            }else if (list.get(list.size()-1).end>=intervals.get(i).start){
                if (list.get(list.size()-1).end<intervals.get(i).end) {
                    list.get(list.size() - 1).end = intervals.get(i).end;
                }
            }else {
                list.add(intervals.get(i));
            }
        }
        return list;

    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1,3));
        list.add(new Interval(5,6));
        list.add(new Interval(2,6));
        list.add(new Interval(3,6));

        List<Interval> list2 = merge(list);
        System.out.println(1);
    }
}


 class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

 }


