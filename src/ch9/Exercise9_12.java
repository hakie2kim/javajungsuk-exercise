package ch9;

public class Exercise9_12 {
    static int getRand(int from, int to) {
        return (int) (Math.random() * (Math.abs(from - to) + 1)) + Math.min(from, to);
        // 예) from -3부터 to 1까지
        // (int) (Math.random() * (Math.abs(from - to) + 1)) -> 0부터 4(1-(-3))까지
        // (int) (Math.random() * (Math.abs(from - to) + 1)) + Math.min(from, to) -> -3부터 1까지
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++)
            System.out.print(getRand(1, -3) + ",");
    }
}
