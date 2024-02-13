import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] wifi = new int[N];
        for(int i=0; i<N; i++){
            wifi[i] = sc.nextInt();
        }

        Arrays.sort(wifi);
        System.out.println(getDistance(wifi,C));


    }
    public static int getDistance(int[] array, int C){
        int left = 1;
        int right = 1000000000;
        int ans = -1;

        while (left <= right) {
            int count = 1;
            int nowIndex = 0;
            int mid = (left+right)/2;
            for(int i=0;i< array.length;i++){
                if(array[i]>=array[nowIndex]+mid){
                    nowIndex = i;
                    count++;
                    if(count>=C){
                        ans = mid;
                        left = mid+1;
                        break;
                    }
                }
            }
            if(count<C){
                right = mid-1;
            }
        }
        return ans;
    }
}
