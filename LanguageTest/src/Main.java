
import java.util.*;

public class  Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int t = in.nextInt();
            int total = in.nextInt();
            if(total<3){
                System.out.println("NO");
            }
            int[] arr = new int[total];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            if(arr[total-1] > arr[total-2] + arr[total-3]){
                System.out.println("NO");
            }
            System.out.println("NO");

        }
    }
}