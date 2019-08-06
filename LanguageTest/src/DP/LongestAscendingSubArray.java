package DP;

public class LongestAscendingSubArray {
    public static int solution(int[] arr){
        int max = 0;
        int dp = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>arr[i-1]){
                dp++;
            }else {
                dp = 1;
            }
            max = max<dp ? dp:max;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr ={7,2,3,1,5,8,9,6};
        System.out.println(solution(arr));
    }
}
