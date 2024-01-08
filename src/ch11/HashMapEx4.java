package ch11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapEx4 {
    // 문자의 개수만큼 # bar 만듦. 예를 들어 A, 3이면 ###
    private static String printBar(char ch, int value) {
        char[] bar = new char[value];

        Arrays.fill(bar, ch); // 아래 for문 대체 가능
        /*for (int i = 0; i < bar.length; i++) {
            bar[i] = ch;
        }*/

        return new String(bar);
    }

    public static void main(String[] args) {
        String[] data = {"A", "K", "A", "K", "D", "K", "A", "K", "K", "K", "Z", "D"};

        HashMap<String, Integer> alphabetFreq = new HashMap<>();

        for (String alphabet : data) {
            if (alphabetFreq.containsKey(alphabet)) { // alphabet이 이미 있으면
                alphabetFreq.put(alphabet, alphabetFreq.get(alphabet) + 1); // 빈도수를 갖고 와 +1
            } else { // alphabet이 없으면
                alphabetFreq.put(alphabet, 1);
            }
        }

        for (Map.Entry<String, Integer> alphabetFreqPair : alphabetFreq.entrySet()) {
            System.out.printf("%s : %s %d%n", alphabetFreqPair.getKey(), printBar('#', alphabetFreqPair.getValue()), alphabetFreqPair.getValue());
        }
    }
}
