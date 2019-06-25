package jvm.memory.non_heap;

import java.util.ArrayList;
import java.util.List;

/**
 * -XX:MaxMetaspaceSize=2M
 * 编译器最大支持的字符串长度：65534；
 */
public class StringInternMain1 {

    public static String getStr(int num, String str){
        StringBuffer sb = new StringBuffer("");
        for(int i=0;i<num;i++){
            sb.append(str);
            final String s = str;
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        String str2 = new String("str")+new String("01");
        String str1 = "str01";
//        str2.intern();
        System.out.println(str2.intern()==str2);//true 中间两行互换，则为false；
    }

}

