import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(br.readLine());
                //sc.nextInt();
        while(T-->0){
            String[] num = br.readLine().split(" ");
            int N = Integer.parseInt(num[0]);
            int M = Integer.parseInt(num[1]);

            int[] a = new int[N];
            int[] b = new int[M];
            String[] numA = br.readLine().split(" ");
            String[] numB = br.readLine().split(" ");
            for(int i=0;i<N;i++){
                a[i] = Integer.parseInt(numA[i]);
            }
            for(int i=0;i<M;i++){
                b[i] = Integer.parseInt(numB[i]);
            }
            Arrays.sort(a);
            Arrays.sort(b);
            int ans = 0;
            for(int i=a.length-1;i>=0;i--){
                for(int j=b.length-1;j>=0;j--){
                    if(a[i]>b[j]){
                        ans+=j+1;
                        break;
                    }
                }
            }
            /**
             * for(int i=0;i<a.length;i++){
             *                 for(int j=0;j<b.length;j++){
             *                     if(a[i]>b[j]){
             *                         ans+=b.length-j;
             *                         break;
             *                     }
             *                 }
             *             }
             */

            bw.write(ans+"\n");
        }
        bw.flush();
    }
}
