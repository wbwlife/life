package JianZhiOffer;


import java.util.ArrayList;
import java.util.List;

public class JumpStairs {
    public static int solution(int number){
        if(number <= 0) {
            return 0;
        }
        if(number == 1) {
            return 1;
        }
        if(number == 2) {
            return 2;
        }
        int first = 1, second = 2;
        for (int i = 2; i < number; i++) {
            second+=first;
            first = second - first;
        }
        return second;
    }

    public static void solution2(int number){
       backTrack(number,new ArrayList<>(),0);
    }

    private static void backTrack(int number,List<Integer> list,int k) {
        int i = 1;
        while (i<3){
            if(k+i<=number){
                List<Integer> mlist = new ArrayList<>(list);
                mlist.add(i);
                if(k+i == number){
                    for(Integer integer:mlist){
                        System.out.print(integer+" ");
                    }
                    System.out.println();
                }else {
                    backTrack(number,mlist,k+i);
                }
            }
            i++;
        }

    }

    public static void main(String[] args) {
        solution2(4);
    }
}
