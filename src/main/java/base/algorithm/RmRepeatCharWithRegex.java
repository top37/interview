package base.algorithm;

public class RmRepeatCharWithRegex {
    static String str = "aabbaaccbdd";

    public static void main(String[] args) {
        System.out.println(new RmRepeatCharWithRegex().removeRepeat(str));
    }

    public String removeRepeat(String str) {
        //炫技 start 无卵用
        StringBuffer sb = new StringBuffer(str);
        String rs = sb.reverse().toString().replaceAll("(.)(?=.*\\1)", "");
        StringBuffer out = new StringBuffer(rs);
        //炫技 end 无卵用
        return str.replaceAll("(.)(?=.*\\1)", "");
    }

}
