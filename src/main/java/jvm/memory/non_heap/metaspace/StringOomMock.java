package jvm.memory.non_heap.metaspace;

import java.util.ArrayList;
import java.util.List;

public class StringOomMock {
    static String base = "String";
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i=0;i< Integer.MAX_VALUE;i++){
            String str = base + i;
            list.add(str.intern());
            System.out.println(str);
        }
    }
}
