package DFS;

public class PermutationII {//abcd
    public static void solution(String input){
        if(null == input || input.length() == 0){
            return;
        }
        int index = 0;
        char[] arr = input.toCharArray();
        backTrack(arr,index);
    }

    private static void backTrack(char[] arr, int index) {
        //base case
        if(index == arr.length){
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr,index,i);
            backTrack(arr,index+1);
            swap(arr,index,i);
        }

    }

    private static void swap(char[] arr, int index, int i) {
        char temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }

    public static void main(String[] args) {
        solution("abc");
    }
}
