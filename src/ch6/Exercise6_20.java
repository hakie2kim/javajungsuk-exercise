package ch6;

public class Exercise6_20 {
    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(java.util.Arrays.toString(original));
        shuffle(original);
        System.out.println(java.util.Arrays.toString(original));
    }

    private static void shuffle(int[] arr) { // 침조형 매개 변수이기 때문에 읽기 쓰기 둘 다 가능
        // 배열을 순차적으로 돈다.
        for (int i = 0; i < arr.length; i++) {
            // 랜덤 인덱스를 생성한다.
            int randomIndex = (int) (Math.random() * arr.length);

            // 해당 요소를 랜덤으로 생성한 인덱스의 요소와 바꾼다.
            int tmp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = tmp;
        }
    }
}
