package jvm.classload;

public class FinallyMain {

    public static void main(String[] args) {
//        System.out.println(new FinallyMain().inc());
        System.out.println(new FinallyMain().fun());
    }


    public String fun(){
        String s = new String("Hello");
        try
        {
            //doing something
            s = s + "Word";

            return s;
        }catch(Exception e){
            return s;
        }finally{
            s = s + "finally";
        }
    }

    public int inc(){
        int x;
        try{
            x = 1;
            return x;
        }catch (Exception e){
            x = 2;
            return x;
        }finally {
            x = 3;
        }
    }
}
