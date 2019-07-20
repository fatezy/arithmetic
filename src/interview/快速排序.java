package interview;

import java.util.Arrays;

/**
 * Created by 张亚飞 on 2019/5/9.
 */
public class 快速排序 {

    public int[] quickSort(int[] arr){
        int length = arr.length;
//        partition(arr,0,length-1);
        partition2(arr,0,length-1);

        return arr;
    }

    /**
     * 将arr[l]放入正确的位置
     * @param arr
     * @param l
     * @param r
     * @return
     */
    public int[] partition(int[] arr,int l,int r){
        if (l<r){
            int i =l,j=r,x=arr[l];

            while (i<j){
                while (arr[j]>=x&&i<j){
                    j--;
                }
                if (i<j){
                    arr[i++] = arr[j];
                }
                while (i<j&&arr[i]<x){
                    i++;
                }
                if (i<j){
                    arr[j--] = arr[i];
                }
            }

            arr[i] = x;
            partition(arr,l,i-1);
            partition(arr,i+1,r);


        }
        return arr;
    }


    public int[] partition2(int[] arr,int l,int r){
        if(l<r){
            int i=l,j=r,x = arr[l];
            while (i<j){
                while (i<j&&arr[j]>=x){
                    j--;
                }
                if (i<j){
                    arr[i++] = arr[j];
                }
                while (i<j&&arr[i]<x){
                    i++;
                }
                if (i<j){
                    arr[j--] = arr[i];
                }
            }
            arr[i] = x;
            partition2(arr,l,i-1);
            partition2(arr,i+1,r);
        }
        return arr;
    }






    public static void main(String[] args) {
        快速排序 test = new 快速排序();
        int[] arr ={2,3,1,7,6};
        System.out.println(Arrays.toString(test.quickSort(arr)));
    }
}

 