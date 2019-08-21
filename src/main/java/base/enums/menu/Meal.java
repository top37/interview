package base.enums.menu;

/**
 * 通过从每一个 Course 实例中随机地选择一个 Food，我们便能够生成一份菜单：
 * values()方法是 compile 时自动加入的方法，还有一个valueOf的单参数方法；
 */
public class Meal {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            for(Course course : Course.values()) {
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("***");
        }
    }
}
