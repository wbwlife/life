package Q1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine().trim());
        int[] input = new int[n];
        String[] temp = br.readLine().trim().split(" ");
        for(int i = 0; i <n; i++) {
            input[i] = Integer.parseInt(temp[i]);
        }
        List<Integer> result = new ArrayList<>();
        double[] min = {Double.MAX_VALUE};
        backTrack(input,result,0,min);
        System.out.println(String.format("%.2f",min[0]));
    }
    private static void backTrack(int[] input, List<Integer> list, int index, double[] min){
        if(list.size() == 3 || index == input.length){//base case
            if(list.size() == 3){
                double avg = (list.get(0)+list.get(1)+list.get(2))/3.0;
                double temp = (Math.pow((list.get(0)-avg),2)+Math.pow((list.get(1)-avg),2)+Math.pow((list.get(2)-avg),2))/3.0;
                min[0] = Math.min(min[0],temp);
            }
            return;
        }
        list.add(input[index]);
        backTrack(input,list,index+1,min);
        list.remove(list.size()-1);
        backTrack(input,list,index+1,min);
    }


}
