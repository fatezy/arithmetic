package hashmap;

import java.util.Arrays;

/**
 * author： 张亚飞
 * time：2016/10/25  09:19
 */
/*Given an array of citations (each citation is a non-negative integer) of a researcher, write a function
        to compute the researcher's h-index.

        According to the definition of h-index on Wikipedia: "A scientist has index h if h of " +
        "his/her N papers have at least h citations each, and the other N − h papers have no more" +
        " than h citations each."
        For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers
        in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the
        researcher has 3 papers with at least 3
        citations each and the remaining two with no more than 3 citations each, his h-index is 3.*/
public class HIdex_274 {
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
