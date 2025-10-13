import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long x3 = Long.parseLong(st.nextToken());
        long y3 = Long.parseLong(st.nextToken());
        long x4 = Long.parseLong(st.nextToken());
        long y4 = Long.parseLong(st.nextToken());

        if (isIntersect(x1, y1, x2, y2, x3, y3, x4, y4))
            System.out.println(1);
        else
            System.out.println(0);
    }

    static boolean isIntersect(long x1, long y1, long x2, long y2,
                               long x3, long y3, long x4, long y4) {
        int ab = ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4);
        int cd = ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2);

        if (ab == 0 && cd == 0) { // 일직선 상
            if (Math.min(x1, x2) <= Math.max(x3, x4) && Math.min(x3, x4) <= Math.max(x1, x2)
                    && Math.min(y1, y2) <= Math.max(y3, y4) && Math.min(y3, y4) <= Math.max(y1, y2))
                return true;
            else
                return false;
        }
        return ab <= 0 && cd <= 0;
    }

    static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long res = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
        if (res > 0) return 1;
        if (res < 0) return -1;
        return 0;
    }
}
