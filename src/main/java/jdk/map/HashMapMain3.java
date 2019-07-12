package jdk.map;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Q：既然Map的本质是数组+链表（jdk8增加了tree），那么为什么遍历的时候是无序的？
 * A：
 */
public class HashMapMain3 {
    public static void main(String[] args) {
        Map hm = new HashMap();
        hm.put(1,"hehe");
        hm.put("hehe",1);
        hm.forEach((k,v) -> System.out.println(k));


        Map hm0;
        for(int i = 0;i < 5;i++){
            System.out.println("-------------------"+i);
            //装载数据
            hm0 = new HashMap();
            hm0.put("d849e6ed-3237-46e5-b9bd-aaa5ffc19418",null);
            hm0.put("a55f0072-7d21-4938-9a17-3eecd2eede01",null);
            hm0.put("e9852943-06cb-4d49-bc36-8ba2b5401588",null);
            hm0.put("80886468-22ea-4aaa-8ad9-c43953573201",null);
            hm0.put("b8e89e44-3b21-4b2d-a45a-50847b281b9a",null);
            hm0.put("9c96fa81-145e-4e8e-8fdf-86e91618457e",null);
            //验证结论
            hm0.forEach((k,v) -> System.out.println(k));
        }
    }

}
