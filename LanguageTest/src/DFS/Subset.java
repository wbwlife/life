package DFS;

public class Subset {
    public static void solution(String input){
        if(null == input || input.length() == 0){
            return;
        }
        char[] arr = input.toCharArray();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        backTrack(arr,index,sb);
    }

    private static void backTrack(char[] arr, int index, StringBuilder sb) {
        if(index == arr.length){
            System.out.println(sb);
            return;
        }
        //加当前元素
        sb.append(arr[index]);
        backTrack(arr,index+1,sb);
        //不加当前元素
        sb.deleteCharAt(sb.length()-1);
        backTrack(arr,index+1,sb);
    }

    public static void main(String[] args) {
        solution("abc");
    }
}
