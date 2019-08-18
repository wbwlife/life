package JianZhiOffer;


import javax.management.loading.MLet;
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
            list.remove(list.size()-1);
        }

    }

    public static void solution3(int number){
        List<Integer> result = new ArrayList<>();
        DFS(number,result);
    }
    private static void DFS(int number,List<Integer> list){
        if(number == 0){
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
            return;
        }
        if(number>=1){
            list.add(1);
            DFS(number-1,list);
            list.remove(list.size()-1);
        }
        if(number>=2){
            list.add(2);
            DFS(number-2,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        solution3(4);
    }
}
