package leetCode.BinarySearch;

/**
 * author： 张亚飞
 * time：2016/5/7  15:26
 */
//You are a product manager and currently leading a team to develop a new product. Unfortunately
// , the latest version of your product fails the quality check. Since each version is developed based on the previous version,
// all the versions after a bad version are also bad.
//
//        Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
// which causes all the following ones to be bad.
//
//        You are given an API bool isBadVersion(version) which will return whether version is bad.
// Implement a function to find the first bad version. You should minimize the number of calls to the API.
 //产品中第i个是坏的，i以后的都是坏的
    //找到第一个坏的
    //// TODO: 2016/5/7  
public class FirstBadVersion_278 {

    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end-start) / 2;
            if (!isBadVersion(mid)) start = mid + 1;
            else end = mid;
        }
        return start;
    }

    boolean isBadVersion(int version){

        return true;
    }

}
