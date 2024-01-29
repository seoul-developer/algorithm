import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        double cut = total* 0.05;
        int num = sc.nextInt();
        int count =0;
        int [] alpha = new int[26];
        double [] countAlpha = new double[26];
        for (int i=0;i<26;i++){
            alpha[i] =-1;
        }
        for (int i=0; i<num; i++){
            char letter = sc.next().charAt(0);
            int vote = sc.nextInt();
            if(vote>=cut){
                countAlpha[letter-'A'] = vote;
                alpha[letter-'A']++;
            }
        }
        for (int i=0; i<14;i++){
            int maxIndex=-1;
            double max =-1;
            for(int j=0;j<26;j++){
                if(countAlpha[j]>max){
                    maxIndex = j;
                    max = countAlpha[j];
                }
            }
            alpha[maxIndex]++;
            countAlpha[maxIndex] *= alpha[maxIndex];
            countAlpha[maxIndex]/= (alpha[maxIndex]+1);
        }
        for(int i=0;i<26;i++){
            if(alpha[i]>=0){
                System.out.printf("%c %d",'A'+i,alpha[i]);
                System.out.println();
            }
        }
    }
}
