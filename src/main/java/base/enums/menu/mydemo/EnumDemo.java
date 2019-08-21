package base.enums.menu.mydemo;

public enum EnumDemo {

    INSTANCE(10),
    INSTANCE2(11);

    private int i;

    EnumDemo(int i) {
        this.i = i;
    }

    public int getI(){
        return i;
    }
}
