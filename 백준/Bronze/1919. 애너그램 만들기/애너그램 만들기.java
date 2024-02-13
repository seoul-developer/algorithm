import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        int[] countA = new int[26];
        int[] countB = new int[26];

        for(int i=0; i<str1.length();i++){
            char c = str1.charAt(i);
            int index = (int) (c -'a');
            countA[index]++;
        }
        for(int i=0; i<str2.length();i++){
            char c = str2.charAt(i);
            int index = (int) (c -'a');
            countB[index]++;
        }
        int num = 0;
        for (int i=0; i<26;i++){
            if(countA[i]>countB[i]){
                num += countA[i]-countB[i];
            }
            else{
                num += countB[i]-countA[i];
            }
        }
        System.out.println(num);
    }
}
