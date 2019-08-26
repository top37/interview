package base.algorithm;

import java.util.*;

/**
 * 若可以调用 Java 内置的数据结构，完全可以使用LinkedHashMap来进行处理：
 * {
 *     1.将字符串转成char[];
 *     2.将每个char -> LinkedHashMap的key；
 *     3.遍历生成新的String；
 * }
 */
public class RmRepeatCharWithLinkedHashSet {
    static String str = "aabbaaccbdd";

    public static void main(String[] args) {

        char[] src = str.toCharArray();
        StringBuilder target = new StringBuilder();
        LinkedHashSet<Character> tempSet = new LinkedHashSet<>();

        for(char c : src) tempSet.add(c);

        tempSet.forEach((e) -> target.append(e));
        System.out.println(target);
    }

}
