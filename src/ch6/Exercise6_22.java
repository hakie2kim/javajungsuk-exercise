package ch6;

public class Exercise6_22 {

    public static void main(String[] args) {
        String str = "123";
        System.out.println(str + "는 숫자입니까? " + isNumber(str));
        str = "1234o";
        System.out.println(str + "는 숫자입니까? " + isNumber(str));
    }

    private static boolean isNumber(String str) {
        // null이거나 빈 문자열이면 false 리턴
        if (str == null || str.equals(""))
            return false;

        // 한 글자씩 검사한다.
        for (char letter : str.toCharArray()) {
            if (!('0' <= letter && letter <= '9')) { // 숫자가 아니면 false 리턴
                return false;
            }
        }
        return true;
    }
}
