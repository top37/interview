package base.algorithm;

import java.util.LinkedHashMap;

/**
 * 若可以调用 Java 内置的数据结构，完全可以使用LinkedHashMap来进行处理：
 * {
 *     1.将字符串转成char[];
 *     2.将每个char -> LinkedHashMap的key；
 *     3.遍历生成新的String；
 * }
 * 重复 可 跳跃
 */
public class RmRepeatCharAndCountWithLinkedHashMap {

    public static void main(String[] args) {

        String str = "aabbaaccbdd";

        char[] src = str.toCharArray();
        LinkedHashMap<Character,Integer> tempMap = new LinkedHashMap<>();

        for(char c : src) {
            if(tempMap.containsKey(c)){
                tempMap.put(c,tempMap.get(c)+1);
            }else{
                tempMap.put(c,0);//init 从0开始 重置；若想统计总数量，可设置为1。
            }
        }

        StringBuilder target = new StringBuilder();
        tempMap.forEach((k,v) -> target.append(k));
        System.out.println("去重后："+target);
        tempMap.forEach((k,v) -> System.out.println("字符 "+k+" 的重复数: "+v));
    }

}
