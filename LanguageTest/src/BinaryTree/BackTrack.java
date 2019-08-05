//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class BackTrack {
//    private static boolean backtrack(int[] arr, List<Integer> curList, boolean[] isUsed) {
//        boolean flag = false;
//        if(arr.length == curList.size()) {
//            String first = curList.get(0);
//            String last = curList.get(curList.size()-1);
//            return last.charAt(last.length()-1) == first.charAt(0);
//        }
//        for(int i = 0; i < words.length; ++i) {
//            if(isUsed[i]) continue;
//            if(curList.size() == 0) {
//                curList.add(words[i]);
//            } else {
//                String prev = curList.get(curList.size()-1);
//                if(prev.charAt(prev.length()-1) != words[i].charAt(0)) continue;
//                curList.add(words[i]);
//            }
//            isUsed[i] = true;
//            flag = backtrack(words, curList, isUsed);
//            isUsed[i] = false;
//            curList.remove(curList.size()-1);
//            if(flag) break;
//        }
//        return flag;
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int t = in.nextInt();
//            int total = in.nextInt();
//            int[] arr = new int[total];
//            for (int i = 0; i < arr.length; i++) {
//                arr[i] = in.nextInt();
//            }
//
//        }
//    }
//}
//
