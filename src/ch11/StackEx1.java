package ch11;

import java.util.Stack;

public class StackEx1 {
    // 현재 화면은 backward의 맨 마지막 요소이다.
    private static Stack backward = new Stack();
    private static Stack forward = new Stack();


    public static void printStatus() {
        System.out.println("backward:" + backward);
        System.out.println("forward:" + forward);
        System.out.printf("현재 화면은 '%s'입니다.%n%n", backward.peek());
    }

    // 다른 페이지로 가기: backward에 딤고 forward를 초기화
    public static void goURL(String url) {
        backward.push(url);
        if (!forward.empty())
            forward.clear();
    }

    // 앞으로 가기: forward 마지막 요소를 꺼내 backward에 담기
    public static void goForward() {
        if (!forward.empty())
            backward.push(forward.pop());
    }

    // 뒤로가기: backward 마지막 요소를 꺼내 forward에 담기
    public static void goBackward() {
        if (!backward.empty())
            forward.push(backward.pop());
    }

    public static void main(String[] args) {
        goURL("1.네이트");
        goURL("2.야후");
        goURL("3.네이버");
        goURL("4.다음");

        printStatus();

        goBackward();
        System.out.println("= 뒤로가기 버튼을 누른 후 =");
        printStatus();

        goBackward();
        System.out.println("= '뒤로' 버튼을 누른 후 =");
        printStatus();

        goForward();
        System.out.println("= '앞으로' 버튼을 누른 후 =");
        printStatus();

        goURL("codechobo.com");
        System.out.println("= 새로운 주소로 이동 후 =");
        printStatus();
    }
}
