import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String empty = sc.nextLine();
        Set<String> set = new HashSet<>();
        for(int i=0;i<N;i++){
            String str = sc.nextLine();
            set.add(str);
        }
        String[] numArray = set.toArray(new String[N]);
        Arrays.sort(numArray);
        int count =0;
        for(int i=0;i<M;i++) {
            String str = sc.nextLine();

            if (binarySearch(numArray,str)==true){
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean binarySearch(String[] array,String target){
        int left = 0;
        int right = array.length-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(target.compareTo(array[mid])<0){
                right = mid-1;
            }else if(target.compareTo(array[mid])>0){
                left = mid+1;
            }else{
                return true;
            }
        }
        return false;
    }
}
