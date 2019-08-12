package Q2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().trim().split(" ");
        int l = Integer.parseInt(temp[0]);
        int n = Integer.parseInt(temp[1]);
        String[] line = br.readLine().trim().split(" ");
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(line[i]);
        }
        int count = 0;
        int left = 0;
        int right = 0;
        for (int i = 1; i < input.length-1; i++) {
            int min = Math.min(input[i] - input[i-1]+1,input[i+1]-input[i]+1);
            if((input[i] - input[i-1]+1)<(input[i+1]-input[i]+1)){
                left++;
            }else {
                right++;
            }
            count += min;
        }
        int start = input[0];
        int end = input[input.length-1];
        count+= (l-end-1)*(right+1)+(start)*(left+1);
        System.out.println(count);
    }
}
