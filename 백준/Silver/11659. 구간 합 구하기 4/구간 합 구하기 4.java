import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int n = Integer.parseInt(stringTokenizer.nextToken());
        final int m = Integer.parseInt(stringTokenizer.nextToken());

        long[] sum = new long[n + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int count = 0; count < m; count++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            final int i = Integer.parseInt(stringTokenizer.nextToken());
            final int j = Integer.parseInt(stringTokenizer.nextToken());

            final long result = sum[j] - sum[i - 1];
            System.out.println(result);
        }
    }
}
