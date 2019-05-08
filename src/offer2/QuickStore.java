package offer2;

/**
 * Created by 张亚飞 on 2019/4/10.
 */
public class QuickStore {
    public static int[] quickSort(int[] arr,int l,int r){

        if(l<r){
            // x用来记录当前会被派到中间的值
            int i= l,j=r,x = arr[l];
            while (i<j){
                while (i<j && arr[j]>=x){
                    j--;
                }
                if(i<j){
                    arr[i++] = arr[j];
                }

                while (i<j&&arr[i]<x){
                    i++;
                }
                if (i<j){
                    arr[j--] = arr[i];
                }
                arr[i] = x;
                quickSort(arr,l,i-1);
                quickSort(arr,i+1,r);
            }
        }

        return arr;

    }



    public static int[] quickSorts(int[] arr,int l,int r){
        if(l<r){
            int i = l,j=r,x=arr[l];
            while (i<j){
                while (arr[j]>=x&&i<j){
                    j--;
                }
                if(i<j){
                    arr[i++] = arr[j];
                }


                while (i<j&&arr[i]<x){
                    i++;
                }
                if(i<j){
                    arr[j--] = arr[i];
                }
                arr[i] = x;
                quickSorts(arr,l,i-1);
                quickSorts(arr,i+1,r);
            }
        }

    return arr;
    }


    public static void main(String[] args) {
        int[] arr  = {3,2,5,1,4,6,3,5};
        quickSorts(arr,0,7);
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }


    }
}

 