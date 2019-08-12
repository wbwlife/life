//package String;
//
//public class KMP {
//    public static boolean solution(String input,String sub){
//        char[] str1 = input.toCharArray();
//        char[] str2 = sub.toCharArray();
//
//        int[] next = new int[sub.length()];
//        next[0] = -1;
//        next[1] = 1;
//        for (int j = 2; j < next.length; j++) {
//            int k = next[j-1];
//            while (k != -1) {
//                if (sub.charAt(k) == sub.charAt(j - 1)) {
//                    next[j] = k + 1;
//                    break;
//                }else {
//                    k = next[k];
//                }
//            }
//            if(k == -1){
//                next[j] = 0;
//            }
//        }
//        int i = 0;
//        int j = 0;
//
//        while(i<=)
//
//    }
//
//}
