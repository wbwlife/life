package DP;

public class CuttingRope {
    public static int DFS(int n){
        if(n == 1){
            return 1;
        }
        int max = 0;
        for (int i = n-1; i >=1; i--) {
            int result = Math.max(DFS(i),i) * (n-i);//注意考虑一刀都不切的情况
            max = Math.max(max,result);
        }
        return max;
    }
    public static int DP(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {//i 表示绳子有多长,dp[i]表示当前最大值
            for (int j = i-1; j >= 1; j--) {//不同的切法
                dp[i] = Math.max(dp[i], Math.max(dp[j],j) * (i-j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(DFS(5));
        System.out.println(DP(5));
    }
}
