package DFS;


public class Permutation {//括号问题()
    public static void solution(String input){
        if(null == input || input.length() == 0){
            return;
        }
        char[] arr = input.toCharArray();
        int left = 0;//已经加入的左括号
        int right =0;//已经加入的右括号
        StringBuilder sb = new StringBuilder();
        backTrack(arr,left,right,sb);
    }

    private static void backTrack(char[] arr, int left, int right, StringBuilder sb) {
        //base case
        if(left == arr.length/2 && right == arr.length/2){
            System.out.println(sb);
            return;
        }

        if(left<arr.length/2){
            sb.append("(");
            backTrack(arr,left+1,right,sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if(right<left){
            sb.append(")");
            backTrack(arr,left,right+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        solution("()()()()()");
    }
}
