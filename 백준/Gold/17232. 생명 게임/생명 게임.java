
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        int K = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        String empty = sc.nextLine();
        int[][] map = new int[N][M];
        for(int i=0;i<N; i++){
            String line = sc.nextLine();
            for(int j=0;j<M;j++){
                if(line.charAt(j)=='*'){
                    map[i][j]=1;
                }else{
                    map[i][j]=0;
                }
            }
        }
        int[][] acc = new int[N+1][M+1];
        while(T-- > 0){
            acc = getSum(N,M, acc, map);
            for(int i =0;i<N;i++){
                for(int j=0;j<M;j++){
                    int nearAlive = getRangeSum(acc,i+1,j+1,K);
                    if(map[i][j] == 1){
                        nearAlive--;
                        if(nearAlive<a||b<nearAlive){
                            map[i][j]=0;
                        }
                    }else{
                        if(a<nearAlive && nearAlive<=b){
                            map[i][j]=1;
                        }
                    }
                }
            }
        }
        for(int i =0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==1){
                    System.out.print("*");
                }else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    public static int[][] getSum(int N,int M, int[][] acc, int[][] map) {
        for (int i = 1; i<= N; i++){
            for(int j = 1; j<=M; j++){
                acc[i][j] = acc[i-1][j]+ acc[i][j-1]- acc[i-1][j-1]+ map[i-1][j-1];
            }
        }
        return acc;
    }

    public static int getRangeSum(int[][] acc, int r, int c, int K){
        int r1 = Math.max(r-K,1);
        int c1 = Math.max(c-K,1);
        int r2 = Math.min(r+K,acc.length-1);
        int c2 = Math.min(c+K,acc[0].length-1);
        return acc[r2][c2] - acc[r1-1][c2]-acc[r2][c1-1]+acc[r1-1][c1-1];
    }
}
