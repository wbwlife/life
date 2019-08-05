package String;

import java.util.ArrayList;
import java.util.List;

public class CharReplace {//replace s with t in input
    public static String solution(String input,String s,String t){
        char[] array  = input.toCharArray();
        if(s.length()>t.length()){
            return replaceShorter(array,s,t);
        }else {
            return replaceLonger(array,s,t);
        }
    }

    private static String replaceLonger(char[] input, String s, String t) {
        List<Integer> matches = getAllMatches(input,s);//返回匹配的字符串的末尾index
        char[] result = new char[input.length+((t.length()-s.length())*matches.size())];
        int fast = input.length-1;
        int slow = result.length-1;
        int lastIndex = matches.size()-1;
        while(fast>=0){
            if((lastIndex>=0) && (matches.get(lastIndex) == fast)){
                for (int i = 0; i <t.length(); i++) {
                    result[slow-i] = t.charAt(i);
                }
                slow -= t.length();
                fast -= s.length();
                lastIndex--;
            }else{
                result[slow--] = input[fast--];
            }
        }
        return new String(result);
    }

    private static List<Integer> getAllMatches(char[] input, String s) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length-s.length()+1; i++) {
            if(isSubString(input,i,s)){
                result.add(i+s.length()-1);
            }
        }
        return result;
    }

    private static String replaceShorter(char[] input, String s, String t) {
        int slow = 0;
        int fast = 0;
        while (fast<input.length){
            if((fast<=input.length-s.length())&& isSubString(input,fast,s)){
                for (int i = 0; i < t.length(); i++) {
                    input[slow+i] = t.charAt(i);
                }
                slow += t.length();
                fast += s.length();
            }else{
                input[slow++] = input[fast++];
            }
        }
        return new String(input,0,slow);
    }

    private static boolean isSubString(char[] input, int index, String s) {
        for (int i = 0; i < s.length(); i++) {
            if(input[index+i] != s.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "student";
        System.out.println(replaceLonger(s.toCharArray(),"den","xxxxxx"));
    }

}
