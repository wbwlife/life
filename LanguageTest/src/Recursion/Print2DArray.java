package Recursion;


public class Print2DArray {
    public static void solution(int[][] arr){
        int offset = 0;
        int size = 5;
        printHelper(arr,offset,size);
    }

    private static void printHelper(int[][] arr, int offset, int size) {
        if(size <= 1){//奇数打印，偶数不打印直接返回
            if(size == 1){
                System.out.println(arr[offset][offset]);
            }
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            System.out.println(arr[offset][i+offset]);
        }
        for (int i = 0; i < size - 1; i++) {
            System.out.println(arr[i+offset][arr[0].length-1-offset]);
        }
        for (int i = size-1; i >= 1; i++) {
            System.out.println(arr[offset][i-offset]);
        }
        for (int i = 0; i < size - 1; i++) {
            System.out.println(arr[offset][offset]);
        }
    }


}
