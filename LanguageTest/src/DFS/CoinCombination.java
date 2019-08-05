package DFS;

public class CoinCombination {
    public static void solution(int money,int[] coins){
        if(null == coins || coins.length == 0){
            return ;
        }
        int level = 0;
        int[] result = new int[4];
        backTrack(money,coins,level,result);
        return ;
    }

    private static void backTrack(int money, int[] coins, int level, int[] result) {
        //base case
        if(level == 3){
            result[3] = money;
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < money / coins[level]; i++) {
            result[level] = i;
            backTrack(money-(i*coins[level]),coins,level+1,result);
        }
    }

    public static void main(String[] args) {
        int[] coins = {25,10,5,1};
        solution(99,coins);
    }

}
