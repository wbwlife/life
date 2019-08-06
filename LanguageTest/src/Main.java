
import javax.print.DocFlavor;
        import java.util.*;

public class  Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
        int total = in.nextInt();
        List<Integer> mlist  = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            mlist.add(in.nextInt());
        }
        int max = calculateOne(mlist);
        for (int i = 1; i < total; i++) {
          List<Integer> left = mlist.subList(0,i);
          List<Integer> right = mlist.subList(i,mlist.size());
          int profit = calculateOne(left)+calculateOne(right);
          max = Math.max(max,profit);
        }
        System.out.println(max);
    }
    private static int calculateOne(List<Integer> mlist){
        int max = 0;
        for (int i = 0; i < mlist.size(); i++) {
            for (int j = i+1; j < mlist.size(); j++) {
                max = Math.max(max,mlist.get(j) - mlist.get(i));
            }
        }
        return max;
    }

}