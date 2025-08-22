import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {   // EOF까지 반복
            line = line.trim();
            if (line.isEmpty()) continue;  

            StringTokenizer st = new StringTokenizer(line);
            // 문제 보장상 한 줄에 두 정수 A B가 주어짐
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(A + B).append('\n');         // 개행 필수
        }

        System.out.print(sb.toString());
    }
}
