package jvm.memory.non_heap;

import java.util.ArrayList;
import java.util.List;

/**
 * -XX:MetaspaceSize=8M -XX:MaxMetaspaceSize=8M
 * 编译器最大支持的字符串长度：65534；
 * 初始化的Metaspace大小，控制元空间发生GC的阈值。GC后，动态增加或降低MetaspaceSize。
 * 在默认情况下，这个值大小根据不同的平台在12M到20M浮动。
 * 使用Java -XX:+PrintFlagsInitial命令查看本机的初始化参数
 * 限制Metaspace增长的上限，防止因为某些情况导致Metaspace无限的使用本地内存，影响到其他程序。
 * 在本机上该参数的默认值为4294967295B（大约4096MB）。
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
        System.out.println(str1==str2.intern());//true 中间两行互换，则为false；
    }

}

