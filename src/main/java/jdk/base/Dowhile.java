package jdk.base;

public class Dowhile {

    public static void main(String[] args) {
        int i = 0;
        while(i < 10){
            System.out.println("--->"+i);
            i++;
        }
        System.out.println("======效果一样======");
        i = 0;
        do{
            System.out.println("--->"+i);
            i++;
        }while(i < 10);


    }
}
