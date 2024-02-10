import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int P = sc.nextInt();
        String empty = sc.nextLine();
        String password = sc.nextLine();
        int A = sc.nextInt();
        int C = sc.nextInt();
        int G = sc.nextInt();
        int T = sc.nextInt();
        int[] dna = new int[4];
        for(int i=0; i<P;i++){
            countDNA(password, i, dna);
        }

        int count =0;
        for(int i=0;i<S+1-P;i++){
            if(i==0){
                if(dna[0]>=A && dna[1]>=C && dna[2]>=G && dna[3]>=T){
                    count++;
                }
            }else{

                countDNA2(password,i,P,dna);
                if(dna[0]>=A && dna[1]>=C && dna[2]>=G && dna[3]>=T){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void countDNA(String password, int i, int[] dna) {
        if(password.charAt(i)=='A'){
            dna[0]++;
        }else if(password.charAt(i)=='C'){
            dna[1]++;
        }else if(password.charAt(i)=='G'){
            dna[2]++;
        }else {
            dna[3]++;
        }
    }
    private static void countDNA2(String password, int i, int P, int[] dna) {
        if(password.charAt(i-1)=='A'){
            dna[0]--;
        }else if(password.charAt(i-1)=='C'){
            dna[1]--;
        }else if(password.charAt(i-1)=='G'){
            dna[2]--;
        }else {
            dna[3]--;
        }
        if(password.charAt(i+P-1)=='A'){
            dna[0]++;
        }else if(password.charAt(i+P-1)=='C'){
            dna[1]++;
        }else if(password.charAt(i+P-1)=='G'){
            dna[2]++;
        }else {
            dna[3]++;
        }
    }
}
