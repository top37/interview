package base.generictype;

import java.util.HashSet;
import java.util.Set;

public class Gene6_UnionSet {
    // Generic method
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    // Simple program to exercise generic method
    public static void main(String[] args) {
//        Set<String> guys = Set.of({"Tom", "Dick", "Harry"});
//        Set<String> stooges = Set.of("Larry", "Moe", "Curly");
//        Set<String> aflCio = union(guys, stooges);
//        System.out.println(aflCio);
    }
}
