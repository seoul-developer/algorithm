import java.util.Scanner;

public class Main {
    static int[] alphabetFrequency = new int[26];
    static int alphabetCount = 0;

    static void increaseFrequency(char alp){
        if(alphabetFrequency[alp-'a']++==0){
            alphabetCount++;
        }
    }
    static void decreaseFrequency(char alp){
        if(--alphabetFrequency[alp-'a']==0){
            alphabetCount--;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        char[] nyang = sc.next().toCharArray();
        int L = nyang.length;

        int nextIndex = 0;
        int ans =0;
        for(int i=0;i<L;i++){
            while(nextIndex<L){
                increaseFrequency(nyang[nextIndex++]);
                if(alphabetCount>N){
                    decreaseFrequency(nyang[--nextIndex]);
                    break;
                }
            }
            ans =Math.max(ans,nextIndex-i);
            decreaseFrequency(nyang[i]);
        }
        System.out.println(ans);
    }
}
