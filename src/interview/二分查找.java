package interview;

/**
 * Created by 张亚飞 on 2019/5/10.
 */
public class 二分查找 {
    public int BinarySearch(int[] arr,int target){

        int length = arr.length;
        int l=0,r=length-1;
        int mid = (l+r)/2;
        while (l<r){
            if (arr[mid] == target){
                return mid;
            }

            if (arr[mid] < target){
                l = mid+1;
                mid = (l+r)/2;
            }

            if (arr[mid] > target){
                r = mid-1;
                mid = (l+r)/2;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}

 