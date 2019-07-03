package Sorting;


import java.util.Arrays;

public class QuickSort {
    public int[] quickSort(int[] arr){
        if(arr == null || arr.length == 0){
            return arr;
        }
        quickHelper(arr,0,arr.length-1);
        return arr;
    }
    private void quickHelper(int[] arr,int left,int right){
        if (left>=right) return;
        int pivotPos = partition(arr,left,right);
        quickHelper(arr,left,pivotPos-1);
        quickHelper(arr,pivotPos+1,right);
    }

    private int partition(int[]arr,int left,int right){
        int pivotIndex = left+ (int) (Math.random()*(right-left+1));
        int pivot = arr[pivotIndex];
        swap(arr,pivotIndex,right);
        int i = left;
        int j = right-1;
        while(i<=j){
            if(arr[i]<pivot){
                i++;
            }else if (arr[j]>=pivot){
                j--;
            }else {
                swap(arr,i++,j++);
            }
        }
        swap(arr,i,right);
        return i;
    }
    private void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,5,2,9,8};
        QuickSort quickSort = new QuickSort();
        System.out.println(Arrays.toString(quickSort.quickSort(arr)));
    }
}
