package base.enums.menu.mydemo;

import static base.enums.menu.mydemo.EnumDemo.INSTANCE;
import static base.enums.menu.mydemo.EnumDemo.INSTANCE2;

public class MainEnum {

    public static void main(String[] args) {

        System.out.println(INSTANCE.hashCode());
        System.out.println(INSTANCE2.hashCode());

        for (EnumDemo s: EnumDemo.values()) {
            System.out.println(s + ", ordinal " + s.ordinal() + "  getI()="+s.getI());
        }
    }
}
