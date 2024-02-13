import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] numbers = new int[N];
        for(int i=0;i<N;i++){
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);

        int diff = numbers[1]-numbers[0];
        int minLength = 2000000001;
        int rightIndex = 1;
        for(int i=0;i<N-1;i++) {
            if(i>=1){diff +=numbers[i-1]-numbers[i];}
            while(diff<M && rightIndex<N-1){
                diff +=numbers[rightIndex+1]-numbers[rightIndex];
                rightIndex++;
            }
            if(diff>=M){
                minLength=Math.min(minLength,diff);
            }

        }
        System.out.println(minLength);
    }
}
