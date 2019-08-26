package base.algorithm;

import java.util.ArrayList;
import java.util.List;

public class RmRepeatCharWithArrayList {
    static String str = "aabbaaccbdd";

    public static void main(String[] args) {
        char[] chars = str.toCharArray();
        List<String> lst = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <chars.length ; i++) {
            if (lst.contains(String.valueOf(chars[i]))){
                continue;
            }else {
                lst.add(String.valueOf(chars[i]));
                sb.append(String.valueOf(chars[i]));
            }
        }
        System.out.println(sb.toString());
        lst.forEach(i -> System.out.println(i));

    }

}
