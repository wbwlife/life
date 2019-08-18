package DP;

public class LongestAscendingSubArray {
    public static void solution(int[] arr){
        int max = 0;
        int dp = 1;
        int left = 1;
        int right = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>arr[i-1]){
                dp++;
            }else {
                dp = 1;
            }
            if(max<=dp){
                max = dp;
                right = i;
                left = i-dp+1;
            }
        }
        for (int i = left; i <= right ; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        solution(new int[]{1,2,3,2,3,4,1});
    }
}
