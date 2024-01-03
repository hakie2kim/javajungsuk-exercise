package ch9;

public class Exercise9_10 {
    static String format(String str, int length, int alignment) {
		/*
		format메서드를 작성하시오.
		1. length의 값이 str의 길이보다 작으면 length만큼만 잘라서 반환한다.
		2. 1의 경우가 아니면, length 크기의 char 배열을 생성하고 공백으로 채운다.
		3. 정렬조건(alignment)의 값에 따라 문자열(str)을 복사할 위치를 결정한다.
		(System.arraycopy()사용)
		4. 2에서 생성한 char배열을 문자열로 만들어서 반환한다.
		*/

        if (length < str.length())
            return str.substring(0, length); // 1.

        char[] chArr = new char[length]; // 2.

        // 3.
        switch (alignment) {
            case 0:
                System.arraycopy(str.toCharArray(), 0, chArr, 0, str.length());
                break;
            case 1:
                /*
                예1) 좌우 공백이 짝수
                좌우 공백 각 2개 = (length - str.length()) / 2
                시작 인덱스 = 2
                0123456
                  abc
                예2) 좌우 공백이 홀수
                좌우 공백 각 3개 = (length - str.length()) / 2
                시작 인덱스 = 3
                0123456789
                   abcd
                */
                System.arraycopy(str.toCharArray(), 0, chArr, (length - str.length()) / 2, str.length());
                break;
            case 2:
                System.arraycopy(str.toCharArray(), 0, chArr, length - str.length(), str.length());
                break;
        }

        return new String(chArr);
    }

    public static void main(String[] args) {
        String str = "가나다";
        System.out.println(format(str, 7, 0)); // 왼쪽 정렬
        System.out.println(format(str, 7, 1)); // 가운데 정렬
        System.out.println(format(str, 7, 2)); // 오른쪽 정렬

    }
}
