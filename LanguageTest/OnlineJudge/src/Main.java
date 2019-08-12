
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().trim().split(" ");
        int n = Integer.parseInt(temp[0]);
        int s = Integer.parseInt(temp[1]);
        long count = 0;
        int first = 1;
        if(first * n +(n*(n-1)/2) > s){
            System.out.println(0);
            return;
        }
        if(n == 2){
            int result = 0;
            if(s%2 == 1){
                result = s/2;
            }else {
               result = s/2 - 1;
            }
            System.out.println(result%1000000007);
            return;
        }
        while(first * n +(n*(n-1)/2) <= s){
            int i = 1;
            int sum = first;
            while(i<n-1) {
                if (s - sum > first + i) {
                    sum+=first;
                    i++;
                }else {
                    break;
                }
            }
            first++;
        }
        System.out.println(count%1000000007);
    }

}
