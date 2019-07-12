package jdk.map;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.HashMap;

//朋友问我更改已存入   hashmap中的数据更改了field值那么，由于其在map中的位置是由更改field之前的hashcode计算出来的，那么，再去获取时就得不到原来的那个数据了，这样就造成了内存泄露。
//问题的关键不在于此，而是能将hashmap的存储原理整明白。
//不过，因为强大的反射，加上hashmap内部组成原理是一个链表数组，所以，还是可以得到任意值的，没有细思高层的方法，直接反射写了写，还行能得到，不过，核心原理说反射获取不可见字段的基础是没有管理器监管，不知道那些所以，就算练练反射了，还是有点难度的吧。
//代码基于hashmap内部实现原理，来访问的，不明白原理的朋友，先去看看网上的解析，再结合源码就看看hashmap的putval方法和内部类Node的组成，当然其余hashmap运作原理和反射各原理，也要仔细分析缕清。
//大体思路：先获取 hashmap 类 的table字段，因为他是Node<K,V>[] node，而node是链表，即它含有一个next字段，结合hashmap存储原理：按照K.hashcode(K)值存入table中，但不保证hashcode不重复，即hashcode同而k不同，这时，会将其放在原table[hashcode(k)].next位置上，即链表数组存储，所以获取table字段后，对其遍历时，不仅要获取每个位置上的链表的头元素，还要反射获取内部类HashMap.Node的next字段，遍历每一个链表，才能获取全体数据。

public class HashMapMain2 {
    public static void main(String[] args) {
        HashMap m = new HashMap<Integer, String>();
        m.put(1, "nihao");
        // 利用反射,获取内部字段 "table"
        Class clsHashMap = null;
        Class clsHashMap$Node = null;
        Field[] f = null;
        Field t = null, fNode = null;
        try {
            clsHashMap = Class.forName("java.util.HashMap");
            clsHashMap$Node = Class.forName("java.util.HashMap$Node");
            f = clsHashMap.getDeclaredFields();
            AccessibleObject.setAccessible(f, true);
            for (Field field : f) {
                // System.out.println(field.getName());
                if (field.getName() == "table")
                    t = field;
            }
            Object[] O = ((Object[]) t.get(m));
            for (Object o : O) {
                if (o != null) {
                    System.out.println(o);
                    // Object e = clsHashMap$Node..newInstance();
                    fNode = clsHashMap$Node.getDeclaredField("next");
                    fNode.setAccessible(true);
                    while ((o = fNode.get(o)) != null) {
                        System.out.println(o);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        // System.out.println(f.getName());
        catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }





}
