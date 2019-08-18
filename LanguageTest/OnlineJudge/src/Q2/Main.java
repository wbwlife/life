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

    }
}
