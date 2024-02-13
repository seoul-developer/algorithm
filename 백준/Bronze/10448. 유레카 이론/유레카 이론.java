import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i=0;i<num;i++){
            int validNum =sc.nextInt();
            System.out.println(valid(validNum));
        }
    }
    public static int triangleNumber(int n){
        int sum =0;
        for(int i=1;i<=n;i++){
            sum+=i;
        }
        return sum;
    }
    public static int valid(int n){
        for (int i=1;i<=45;i++){
            for(int j=1;j<=45;j++){
                for(int k=1;k<=45;k++){
                    if(triangleNumber(i)+triangleNumber(j)+triangleNumber(k)==n){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

}
