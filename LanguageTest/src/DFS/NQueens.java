package DFS;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    private static List<List<Integer>> solution(int n){
        List<List<Integer>> result = new ArrayList<>();
        //作为遍历条件index
        List<Integer> col = new ArrayList<>();
        backTrack(n,col,result);
        return result;
    }

    private static void backTrack(int n, List<Integer> col, List<List<Integer>> result) {
        //base case
        if(col.size() == n){
            result.add(col);
            return;
        }
        for (int i = 0; i < n; i++) {//
            if(vaild(col,i)){
                col.add(i);
                backTrack(n,col,result);
                col.remove(col.size()-1);
            }
        }
    }

    private static boolean vaild(List<Integer> col, int column) {//插入的位置 row，column
        int row = col.size();

        for (int j = 0; j < col.size(); j++) {
            if(col.get(j) == column || Math.abs(row-j) == Math.abs(column - col.get(j))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> col = new ArrayList<>();
        col.add(1);
        col.add(2);
        col.add(3);
        List<List<Integer>> result = new ArrayList<>();
        result.add(col);
        result.add(new ArrayList<>(col));
        System.out.println(result);
    }
}
