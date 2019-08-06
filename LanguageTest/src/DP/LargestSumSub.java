package DP;

public class LargestSumSub {
    //a[i] = max(a[i],a[i]+M[i-1])
    public static int solution(int[] input){
        if(null == input || input.length == 0){
            return 0;
        }
        int[] dp = new int[input.length];
        dp[0] = input[0];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(input[i],input[i]+dp[i-1]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,4,-1,-2,10,-1}));
    }
}
