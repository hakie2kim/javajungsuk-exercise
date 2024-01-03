package ch9;

public class Exercise9_9 {
    static String delChar(String src, String delCh) {
        // 주석 처리한 방식은 char 하나씩 지울 때 검사할 다음 인덱스가 앞으로 당겨지는 문제가 생김 -> 검사 못하는 인덱스가 존재
		/*StringBuffer deletedChar = new StringBuffer(src);
		for (int i = 0; i < delCh.length(); i++) {
			int indexToDelete = deletedChar.indexOf(delCh.charAt(i) + "");
			if (indexToDelete != -1)
				deletedChar.deleteCharAt(indexToDelete);
		}*/

        StringBuffer deletedChar = new StringBuffer(src.length());

        for(int i = 0; i < src.length(); i++) {
            if (delCh.indexOf(src.charAt(i)) == -1)
                deletedChar.append(src.charAt(i));
        }

        return deletedChar.toString();
    }

    public static void main(String[] args) {
        System.out.println("(1!2@3^4~5)"+" -> "
                + delChar("(1!2@3^4~5)","~!@#$%^&*()"));
        System.out.println("(1 2 3 4\t5)"+" -> "
                + delChar("(1 2 3 4\t5)"," \t"));

    }
}
