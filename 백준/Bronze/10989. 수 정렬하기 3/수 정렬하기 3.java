import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int number = Integer.parseInt(br.readLine());
        int[] cnt = new int[10000];
        for (int i=0;i<number;i++){
            cnt[Integer.parseInt(br.readLine())-1]++;
        }

        for (int i=1; i<= 10000; i++){
            for (int j=0; j<cnt[i-1];j++){
                bw.write(i+"\n");
            }
        }
        bw.flush();
    }
}
