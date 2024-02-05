import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] liquid = new int[N];
        String[] numbers = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            liquid[i] = Integer.parseInt(numbers[i]);
        }
        Arrays.sort(liquid);
        int[] two = twoLiquid(liquid);
        bw.write(two[0]+" "+two[1]);
        bw.flush();

    }
    public static int[] twoLiquid(int[] liquid){
        int[] two = new int[2];
        int min = 2000000000;
        int left = 0;
        int right = liquid.length-1;
        while(left<right){
            int sum = liquid[left]+liquid[right];
            if(sum>0){
                if(sum<min){
                    two[0] = liquid[left];
                    two[1] = liquid[right--];
                    min = sum;
                }else{
                    right--;
                }
            }else if(sum<0){
                if(Math.abs(sum)<min){
                    two[0] = liquid[left++];
                    two[1] = liquid[right];
                    min = Math.abs(sum);
                }else{
                    left++;
                }
            }else{
                two[0] = liquid[left];
                two[1] = liquid[right];
                break;
            }
        }
        return two;
    }
}
