
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();
        int W = sc.nextInt();
        String empty = sc.nextLine();
        String stone = sc.nextLine();
        int rightIndex = 0;
        int bNow = 0;
        int wNow = 0;
        if(stone.charAt(0)=='B') bNow++;
        else wNow++;
        int maxLength =0;

        for(int i=0;i<N;i++){
            while(bNow<=B&&rightIndex<N-1){
                rightIndex++;
                if(stone.charAt(rightIndex)=='B') bNow++;
                else wNow++;
            }
            if(rightIndex<N-1){
                if(wNow>=W){
                    maxLength = Math.max(maxLength,bNow+wNow-1);
                }else{
                    maxLength= Math.max(maxLength,0);
                }
            }else{
                if(wNow>=W) {
                    if(bNow>B){
                        maxLength = Math.max(maxLength,bNow+wNow-1);
                    }else{
                        maxLength = Math.max(maxLength,bNow+wNow);
                    }
                }
                else{
                    maxLength= Math.max(maxLength,0);
                }
                break;
            }
            if(stone.charAt(i)=='B') bNow--;
            else wNow--;
        }
        System.out.println(maxLength);
    }
}
