import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            if (curr < min) {
                min = curr;
            }
            if (curr > max) {
                max = curr;
            }
        }

        System.out.printf("%d %d", min, max);
    }
}
