package ch11;

import java.util.*;

public class TreeSetLotto {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();

        while (set.size() < 6) {
            int num = (int) (Math.random() * 45) + 1;
            set.add(num); // auto-boxing
        }

        // HashSet에 담았을 때와 달리 TreeSet은 저장할 때 이미 정렬함
//      List<Integer> list = new LinkedList<>(set); // LinkedList(Collection c)
//      Collections.sort(list);
        System.out.println(set);
    }
}
