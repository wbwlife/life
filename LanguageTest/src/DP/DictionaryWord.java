package DP;

import java.util.HashSet;
import java.util.Set;

public class DictionaryWord {
    public static boolean solution(String input, HashSet<String> dictionary){
        if(input == null || input.length() == 0 || dictionary == null || dictionary.isEmpty()){
            return false;
        }
        boolean[] dp = new boolean[input.length()];
        dp[input.length()-1] = dictionary.contains(input.substring(input.length()-1));
        for (int i = input.length()-2; i >=0 ; i--) {
            //不切
            if(dictionary.contains(input.substring(i))){
                dp[i] = true;
                continue;
            }
            //从右开始切
            for (int j = input.length()-1; j >=0 ; j--) {
                if(dp[j] && dictionary.contains(input.substring(i,j))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("bob");
        set.add("ac");
        System.out.println(solution("abob",set));
    }
}
