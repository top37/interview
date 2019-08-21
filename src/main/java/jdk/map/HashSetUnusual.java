package jdk.map;

import java.util.HashSet;

public class HashSetUnusual {
    public static void main(String[] args) {
//        HashSet<StringBuilder> hs=new HashSet<StringBuilder>();
//        StringBuilder sb1=new StringBuilder("aaa");
//        StringBuilder sb2=new StringBuilder("aaabbb");
//        hs.add(sb1);
//        hs.add(sb2);    //这时候HashSet里是{"aaa","aaabbb"}
//        StringBuilder sb3=sb1;
//        sb3.append("bbb");  //这时候HashSet里是{"aaabbb","aaabbb"}
//        System.out.println(hs);

        HashSet<StringBuilder> hs=new HashSet<StringBuilder>();
        StringBuilder sb1=new StringBuilder("aaabbb");
        StringBuilder sb2=new StringBuilder("aaabbb");
        hs.add(sb1);
        hs.add(sb2);    //这时候HashSet里是{"aaa","aaabbb"}
        StringBuilder sb3=sb1;
//        sb3.append("bbb");  //这时候HashSet里是{"aaabbb","aaabbb"}
        System.out.println(hs);
    }
}
