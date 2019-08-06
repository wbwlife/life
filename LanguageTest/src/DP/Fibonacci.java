package DP;

import java.util.Scanner;

public class Fibonacci {//dp
    public static int solution(int n){
        if(n<2){
            return n;
        }
        int pre = 0;
        int cur = 1;
        int index = 2;
        while (index <= n){
            cur += pre;
            pre = cur-pre;
            index++;
        }
        return cur;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(solution(in.nextInt()));
    }
}
