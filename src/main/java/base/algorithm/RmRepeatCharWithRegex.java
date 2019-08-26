package base.algorithm;

import java.util.LinkedHashSet;

public class RmRepeatCharWithRegex {
    static String str = "aabbaaccbdd";

    public static void main(String[] args) {
        System.out.println(new RmRepeatCharWithRegex().removeRepeat(str));
    }

    public String removeRepeat(String str) {
        StringBuffer sb = new StringBuffer(str);
        String rs = sb.reverse().toString().replaceAll("(.)(?=.*\\1)", "");
//        StringBuffer out = new StringBuffer(rs);
        return str.replaceAll("(.)(?=.*\\1)", "");
    }

}
