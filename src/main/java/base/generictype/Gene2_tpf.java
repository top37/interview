package base.generictype;

import java.util.ArrayList;
import java.util.List;

public class Gene2_tpf {

    /**
     * 使用 ？ 的弊端：
     * {
     *     1.只能使用get()，不能用add();
     *     2.使原集合包含类型信息丢失;
     * }
     * @param args
     */
    public static void main(String[] args) {
        // ArrayList<Object> arr = new ArrayList<String>(); 编译不通过，arr只能引用包含Object的集合

        ArrayList<String> lstStr = new ArrayList<>();
        lstStr.add("aqiang");
        ArrayList<Integer> lstInt = new ArrayList<>();
        lstInt.add(26);

        ArrayList<?> lst = lstStr;
        System.out.println( lst.get(0) instanceof String );//true
        String s = (String) lst.get(0);
        Object s1 = lst.get(0);

        lst = lstInt;
        System.out.println( lst.get(0) instanceof Integer );//true
    }

    static void getList(List<?> lst,String str){
//        lst.add(str); 编译不通过
    }
}
