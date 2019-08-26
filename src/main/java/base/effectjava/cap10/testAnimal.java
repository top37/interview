package base.effectjava.cap10;

public class testAnimal {
    public static void main(String[] args) {
        Animal dog = Animal.create("dog", 4);
        System.out.println(dog.name());
//        assertEquals("dog", dog.name());
//        assertEquals(4, dog.numberOfLegs());
//
//        // You probably don't need to write assertions like these; just illustrating.
//        assertTrue(Animal.create("dog", 4).equals(dog));
//        assertFalse(Animal.create("cat", 4).equals(dog));
//        assertFalse(Animal.create("dog", 2).equals(dog));
//
//        assertEquals("Animal{name=dog, numberOfLegs=4}", dog.toString());
    }
}
