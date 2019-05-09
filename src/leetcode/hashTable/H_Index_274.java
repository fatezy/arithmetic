package leetcode.hashTable;

import java.util.Arrays;

/**
 * author： 张亚飞
 * time：2016/5/12  22:48
 */
//For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5
// citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations
// each, his h-index is 3.
//H-Index的核心计算方法如下：
//
//        1、将某作者的所有文章的引用频次按照从大到小的位置排列
//
//        2、从前到后，找到最后一个满足条件的位置，其条件为：
//
//        此位置是数组的第x个，其值为y，必须满足 y >= x;
    //貌似和Hashmap并没有关系
public class H_Index_274 {
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        int result = 0;
        Arrays.sort(citations);
        int len = citations.length;
        for (int i = len - 1; i >= 0; i--) {
            if (result >= citations[i]) {
                return result;
            }
            result++;
        }

        return result;
    }

}
