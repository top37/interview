package base.algorithm;

import java.util.LinkedHashSet;

public class RmRepeatCharWithCharAtAndIndexOf {
    static String str = "aabbaaccbdd";

    public static void main(String[] args) {
        System.out.println(new RmRepeatCharWithCharAtAndIndexOf().removeRepeatChar(str));
    }

    public String removeRepeatChar(String str) {

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length(); i ++) {
            char charWord = str.charAt(i);
            int firstPosition = str.indexOf(charWord);
            int lastPosition = str.lastIndexOf(charWord);
            if (firstPosition  == lastPosition || firstPosition == i) {
                sb.append(charWord);
            }
        }
        return sb.toString();
    }


}
