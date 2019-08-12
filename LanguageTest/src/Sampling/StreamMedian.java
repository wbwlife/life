package Sampling;

import java.util.*;

public class StreamMedian {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
       while (in.hasNextInt()){
           int input = in.nextInt();
           //添加输入到堆里
           if(maxHeap.isEmpty() || input<maxHeap.peek()){
               maxHeap.offer(input);
           }else {
               minHeap.offer(input);
           }
           //平衡size,max = min+1
           if(maxHeap.size()-minHeap.size()>1){
               minHeap.offer(maxHeap.poll());
           } else if (minHeap.size()>maxHeap.size()){
               maxHeap.offer(minHeap.poll());
           }
           int size = maxHeap.size()+minHeap.size();
           if (size == 0){
               return;
           }
           if((size & 1) == 1){//奇数
               System.out.println(maxHeap.peek());
           }else {
               System.out.println((minHeap.peek()+maxHeap.peek())/2.0);
           }
       }
    }

}
