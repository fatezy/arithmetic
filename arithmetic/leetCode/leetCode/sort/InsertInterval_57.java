package leetCode.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/8/4  11:42
 */
//Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//
//        You may assume that the intervals were initially sorted according to their start times.
//
//        Example 1:
//        Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
//
//        Example 2:
//        Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
//
//        This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
public class InsertInterval_57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
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
}
