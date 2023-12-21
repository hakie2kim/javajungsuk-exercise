package ch6;

public class Exercise6_23 {

    public static void main(String[] args) {
        int[] data = {3, 2, 9, 4, 7};
        System.out.println(java.util.Arrays.toString(data));
        System.out.println("최대값:" + max(data));
        System.out.println("최대값:" + max(null));
        System.out.println("최대값:" + max(new int[]{})); // 크기가 0인 배열
    }

    private static int max(int[] arr) {
        if (arr == null || arr.length == 0)
            return -999999;

        int max = arr[0];
        // 배열을 돌면서 기존 설정한 값보다 큰 값을 갖고 있는 요소가 나오면 max 값을 바꿔준다.
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        return max;
    }
}
