package String;


import java.util.HashMap;
import java.util.Map;

public class PrintOneTwoThree {
        public static String englishToNumber(String arr) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        String message = "";

        while (!"".equals(arr)) {
            if (arr.startsWith("on") || arr.startsWith("tw") || arr.startsWith("si")) {
                message += map.get(arr.substring(0, 3));
                arr = arr.substring(3, arr.length());
            }
            if (arr.startsWith("ze") || arr.startsWith("fo") || arr.startsWith("fi") || arr.startsWith("ni")) {
                message += map.get(arr.substring(0, 4));
                arr = arr.substring(4, arr.length());
            }
            if (arr.startsWith("th") || arr.startsWith("se") || arr.startsWith("ei")) {
                message += map.get(arr.substring(0, 5));
                arr = arr.substring(5, arr.length());
            }
        }
        return message;
    }

    public static void main(String[] args) {
        String str = "onefiveeighttwothreeninesixfourseven";
        String s = englishToNumber(str);
        System.out.println(s);
    }
}
