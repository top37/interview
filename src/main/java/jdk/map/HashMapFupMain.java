package jdk.map;

import jdk.map.utils.ReflectUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 负载因子：loadFactor可以大于1吗？有什么影响？
 *
 * 答：
 * {
 *     可以大于1；
 *     影响扩容阈值，大大增加了hash碰撞的几率：
 *     {
 *         initialCapacity = 4，则有4个槽子（*Cap），但是需要达到扩容阈值（*Thr）【 initialCapacity * loadFactor = 8 】时，才进行扩容；
 *         因此，一定会产生hash冲突；
 *
 *     }
 *     另外说一嘴：之所以默认loadFactor=0.75f,而不是1，,正是因为避免hash冲突；
 * }
 */
public class HashMapFupMain {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//        Map<String,String> m = new HashMap(4,0.75f);
        Map<String,String> m = new HashMap(4,2);
        m.put("1","a");
        m.put("2","b");
        m.put("3","c");
        System.out.println(m);
        int j = 0;
        for(String k:m.keySet()){
            System.out.print(j+ " key:"+k+" 存放在第: "+((4 - 1) & ReflectUtil.getMap_hash(k))+"个槽子|");
            j++;
        }

        System.out.println("\n-----------------");


        j = 0;
        m.put("4","d");
        m.put("5","e");
        System.out.println(m);
        for(String k:m.keySet()){
            System.out.print(j+ " key:"+k+" 存放在第: "+((4 - 1) & ReflectUtil.getMap_hash(k))+"个槽子|");
            j++;
        }
    }
}
