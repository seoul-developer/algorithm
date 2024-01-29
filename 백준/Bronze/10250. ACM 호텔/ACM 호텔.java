import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();
        for (int i=0;i<numTest;i++){
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();
            int yy = (N-1) % H +1;
            int xx = (N-1) / H +1;

            System.out.printf("%d%02d\n",yy,xx);

        }
    }
}
