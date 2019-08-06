package DP;

public class JumpGame {
    public static boolean solution(int[] input){
        if(input == null || input.length == 0){
            return false;
        }
        boolean [] dp = new boolean[input.length];
        dp[dp.length-1] = true;
        for (int i = input.length-2; i >=0 ; i--) {//倒序
            for (int j = input.length-1; j >i ; j--) {
                dp[i] = dp[j] && (input[i] >= (j - i));
                if (dp[i]) break;
            }
        }
        return dp[0];
    }

    //举一反三：求最小步数跳到终点
    public static int solution1(int[] input){
        if(input == null || input.length == 0){
            return -1;
        }
        int[] dp = new int[input.length];
        dp[dp.length-1] = 0;
        for (int i = dp.length-2; i >=0 ; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = dp.length-1; j >i ; j-- ) {
                if(input[i]>= (j-i) && (dp[j]!=Integer.MAX_VALUE)){
                    dp[i] = Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(solution1(new int[]{4,2,1,1,4}));
    }
}
