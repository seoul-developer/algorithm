import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] sum = new int[N];
        int sumTotal=0;
        for(int i=0; i<N;i++){
            sumTotal+= sc.nextInt();
            sum[i] = sumTotal;
        }
        for(int i=0;i<M;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int ans;
            if(start==1){
                ans = sum[end-1];
            }else{
                ans = sum[end-1] - sum[start-2];
            }
            System.out.println(ans);
        }

    }
}
