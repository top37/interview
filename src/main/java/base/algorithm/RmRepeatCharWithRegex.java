package base.algorithm;

public class RmRepeatCharWithRegex {
    static String str = "aabbaaccbdd";

    public static void main(String[] args) {
        System.out.println(new RmRepeatCharWithRegex().removeRepeat(str));
    }

    public String removeRepeat(String str) {
        //非炫技 start 有用 保证顺序
        StringBuffer sb = new StringBuffer(str);
        String rs = sb.reverse().toString().replaceAll("(.)(?=.*\\1)", "");
        StringBuffer out = new StringBuffer(rs);
        //非炫技 end 有用 保证顺序
//        return str.replaceAll("(.)(?=.*\\1)", "");
        return out.reverse().toString();
    }

}
