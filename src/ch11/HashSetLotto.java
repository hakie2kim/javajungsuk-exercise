package ch11;

import java.util.*;

public class HashSetLotto {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        while (set.size() < 6) {
            int num = (int) (Math.random() * 45) + 1;
            set.add(num); // auto-boxing
        }

        List<Integer> list = new LinkedList<>(set); // LinkedList(Collection c)
        Collections.sort(list);
        System.out.println(list);
    }
}
