package DP;

public class EditDistance {
    //dp[i][j]代表从s1的前i个字母转化到s2的前j个字母要多少步
    public static int solution(String str1,String str2){
        if(null == str1 || str1.length() == 0 || null == str2 || str2.length() == 0){
            return -1;
        }
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        dp[0][0] = 0;
        for (int i = 1; i <= str1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= str2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j]);
            }
        }
        return dp[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        System.out.println(solution("asdf","sghj"));
    }
}
