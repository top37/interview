package base.nestedclass;

public class LocalClass {
    private String str = "hello";
    void getNewStr(){
        String lstr = new String("hhh");
        class Lcls{
            void m(){
                System.out.println(str);
                System.out.println(lstr);
            }
        }
        new Lcls().m();
    }

    public static void main(String[] args) {
        new LocalClass().getNewStr();
    }
}
