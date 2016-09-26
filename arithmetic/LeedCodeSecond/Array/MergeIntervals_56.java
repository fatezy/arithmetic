package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/9/25  22:31
 */
/*Given a collection of intervals, merge all overlapping intervals.

        For example,
        Given [1,3],[2,6],[8,10],[15,18],
        return [1,6],[8,10],[15,18].*/
//合并重叠项
public class MergeIntervals_56 {
    public List<Interval> merge(List<Interval> intervals) {
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
        List<Interval> res = new ArrayList<>();
        for (int i = 0; i <intervals.size() ; i++) {
            if (res.size() == 0) {
                res.add(intervals.get(i));
                continue;
            }

            if (res.get(res.size()-1).end>=intervals.get(i).start){
               if (res.get(res.size()-1).end<intervals.get(i).end){
                   res.get(res.size()-1).end = intervals.get(i).end;
               }
            }else {
                res.add(intervals.get(i));
            }


        }


        return res;
    }


}


   class Interval {
      int start;
      int end;
       Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
   }
