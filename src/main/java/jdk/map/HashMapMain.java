package jdk.map;

import jdk.map.utils.ReflectUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * 我们知道数组定义下来后就长度确定了，那么Hash在进行扩容的时候，是否切换了对象？
 * 答：肯定变了，因为数组长度是固定的，一旦长度发生变换，一定不是原数组
 */
public class HashMapMain {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        //已知：jdk8默认初始容量为16，负载为0.75f，容量于12时进行扩容；
        //这里将负载因子设置成1
        HashMap<String,String> hm = new HashMap(17,1);
        int j = 1;

        for(int i = 0; i < 15;i++  ){
            hm.put("key_"+i,null);
        }

        for(String k:hm.keySet()){
            System.out.print(j+ " key:"+k+" 存放在第: "+((16 - 1) & ReflectUtil.getMap_hash(k))+"个槽子|");
            j++;
        }
        System.out.println();
        System.out.println("-----------------");

        for(int i = 15; i < 31;i++  ){
            hm.put("key_"+i,null);
        }
        j=1;
        for(String k:hm.keySet()){
            System.out.print(j+ " "+k+" : "+((32 - 1) & ReflectUtil.getMap_hash(k))+"|");
            j++;
        }

        System.out.println("观察key_13");

    }
}
