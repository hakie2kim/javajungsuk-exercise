package ch9;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise9_14 {
    public static void main(String[] args) {
        String[] phoneNumArr = {"012-3456-7890", "099-2456-7980", "088-2346-9870", "013-3456-7890"};

        ArrayList<String> list = new ArrayList<>();

        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.print(">>");
            String input = s.nextLine().trim();
            if (input.equals("")) {
                continue;
            } else if (input.equalsIgnoreCase("Q")) {
                System.exit(0);
            }

            for (String phoneNum : phoneNumArr) {
                // "-" 삭제한 후 input 앞뒤로 아무 숫자나 와도 되는 패턴이랑 매치하는지 확인
                Matcher m = Pattern.compile(".*" + input + ".*").matcher(phoneNum.replace("-", ""));
                if (m.matches())
                    list.add(phoneNum);
            }

            if (!list.isEmpty()) {
                System.out.println(list);
                list.clear();
            } else {
                System.out.println("일치하는 번호가 없습니다.");
            }
        }
    }
}
