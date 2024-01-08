package ch11;

import java.util.*;

public class TreeMapEx1 {
    // 문자의 개수만큼 # bar 만듦. 예를 들어 A, 3이면 ###
    private static String printBar(char ch, int value) {
        char[] bar = new char[value];

        Arrays.fill(bar, ch); // 아래 for문 대체 가능
        /*for (int i = 0; i < bar.length; i++) {
            bar[i] = ch;
        }*/

        return new String(bar);
    }

    static class DescendingComparator implements Comparator {
        public int compare(Object o1, Object o2) {
            if(o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
                Map.Entry e1 = (Map.Entry) o1;
                Map.Entry e2 = (Map.Entry) o2;

                Integer v1 = (Integer) e1.getValue();
                Integer v2 = (Integer) e2.getValue();

                // 아래 두 방법 중 하나 선택
                return  v2 - v1;
//				System.out.println(v1.compareTo(v2));
//				return  v1.compareTo(v2) * -1;
            }
            return -1;
        }
    }	// 	static class ValueComparator implements Comparator

    public static void main(String[] args) {
        String[] data = {"A", "K", "A", "K", "D", "K", "A", "K", "K", "K", "Z", "D"};

        TreeMap<String, Integer> alphabetFreq = new TreeMap<>();

        // TreeMap은 추가하면서 자동 정렬됨
        for (String alphabet : data) {
            if (alphabetFreq.containsKey(alphabet)) { // alphabet이 이미 있으면
                alphabetFreq.put(alphabet, alphabetFreq.get(alphabet) + 1); // 빈도수를 갖고 와 +1
            } else { // alphabet이 없으면
                alphabetFreq.put(alphabet, 1);
            }
        }

        System.out.println("= 기본정렬 =");
        for (Map.Entry<String, Integer> alphabetFreqPair : alphabetFreq.entrySet()) {
            System.out.printf("%s : %s %d%n", alphabetFreqPair.getKey(), printBar('#', alphabetFreqPair.getValue()), alphabetFreqPair.getValue());
        }
        System.out.println();

        System.out.println("= 값의 크기가 큰 순서로 정렬 =");
        // map을 ArrayList로 변환한 다음에 Collectons.sort()로 정렬
        List<Map.Entry<String, Integer>> list = new ArrayList<>(alphabetFreq.entrySet()); // ArrayList(Collection c)
        Collections.sort(list, new DescendingComparator());
        for (Map.Entry<String, Integer> alphabetFreqPair : list) {
            System.out.printf("%s : %s %d%n", alphabetFreqPair.getKey(), printBar('#', alphabetFreqPair.getValue()), alphabetFreqPair.getValue());
        }
    }
}
