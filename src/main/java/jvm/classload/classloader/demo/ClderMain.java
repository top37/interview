package jvm.classload.classloader.demo;

public class ClderMain extends Clder{

    @Override
    public Object loadCls(String str) {
        System.out.println(111);
        return null;
    }

    private int i;
    public static void main(String[] args) {

        Clder cl = new Clder(){

            public Object loadCls(String str){
                System.out.println("hhh");
//                return loadCls(str,false);
                return null;
            }
        };

        cl.loadCls("heh");
        System.out.println();
    }
}
