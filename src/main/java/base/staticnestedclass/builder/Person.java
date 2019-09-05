package base.staticnestedclass.builder;

import base.enums.menu.Food;

/**
 * @author 单强 2019年7月16日14:41:15
 *         Java Builder模式
 */
public class Person {
    private String name;
    private int age;
    private boolean sex;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isSex() {
        return sex;
    }

    private static class Builder {
        private String name;
        private int age;
        private boolean sex;

        public Builder name(String n) {
            name = n;
            return this;
        }

        public Builder age(int a) {
            age = a;
            return this;
        }

        public Builder sex(boolean s) {
            sex = s;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    private Person(Builder builder) {
        name = builder.name;
        age = builder.age;
        sex = builder.sex;
    }

    public static void main(String[] args) {
        Person person = new Person.Builder().name("StephenHe").age(20).sex(true).build();
        System.out.println(person.getName() + "\n" + person.getAge() + "\n" + person.isSex());
    }
}
