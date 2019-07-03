package Sorting;

import java.util.Arrays;

public class MergeSort {
    public int[] mergeSort(int[] arr){
        if(arr  == null){
            return arr;
        }
        int[] helper = new int[arr.length];
        int i = 0;
        int j = arr.length - 1;
        mergeHelper(arr,helper,i,j);
        return arr;
    }

    private void mergeHelper(int[] arr, int[] helper,int i,int j){
        if(i >= j){
            return;
        }
        int mid = i + (j-i)/2;
        mergeHelper(arr,helper,i,mid);
        mergeHelper(arr,helper,mid+1,j);
        combine(arr,i,mid,j,helper);
    }
    private void combine(int[] arr,int left,int mid,int right,int[] helper){
        int i = left;//for left
        int j = mid+1;//for right
        int index = 0;
        while(i<=mid && j<=right){
            helper[index++] = arr[i]<=arr[j] ? arr[i++] : arr[j++];
        }
        while (i<=mid){
            helper[index++] = arr[i++];
        }
        while (j<=mid){
            helper[index++] = arr[j++];
        }
        System.arraycopy(helper,0,arr,left,index);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,2,9,8};
        MergeSort mergeSort = new MergeSort();
        System.out.println(Arrays.toString(mergeSort.mergeSort(arr)));
    }
}
