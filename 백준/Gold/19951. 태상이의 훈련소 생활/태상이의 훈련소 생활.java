import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] delta = new int[N];
        int[] num = new int[N];
        for(int i=0;i<N;i++){
            num[i]=sc.nextInt();
        }
        for(int i=0;i<M;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();
            delta[a-1] +=k;
            if(b!=N){
                delta[b] -=k;
            }
        }

        int sumTotal = 0;
        for(int i=0;i<N;i++){
            sumTotal+=delta[i];
            num[i]+=sumTotal;
            System.out.print(num[i]+" ");
        }
        System.out.println();
    }
}
