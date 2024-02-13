import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        str = str.toUpperCase();
        int[] count = new int[26];

        for (int i =0; i<str.length(); i++){
            count[str.charAt(i)-'A']++;
        }

        int max = -1;
        char maxAlpha ='?';
        for (int i=0; i<26; i++){
            if(count[i]>max) {
                max = count[i];
                maxAlpha = (char) ('A' + i);
            } else if(count[i]==max){
                maxAlpha ='?';
            }
        }
        System.out.println(maxAlpha);
    }
}
