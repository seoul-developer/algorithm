import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); //3
        while(num-->0){
            int testNum = sc.nextInt();
            boolean isTrue = false;
            for(int i=2;i<=64;i++){
                if(toFormation(testNum,i)==1){
                    isTrue = true;
                    break;
                }
            }
            if(isTrue)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
    private static int toFormation(int num, int formation) {
        String numFormation = "";
        while(num !=0){
            int letter = num % formation;
            if(letter>=10){
                numFormation += (char)(letter+'A'-10);
            }else{
                numFormation += letter;
            }
            num /= formation;
        }
        if(numFormation.equals(new StringBuilder(numFormation).reverse().toString())){
            return 1;
        }else{
            return 0;
        }
    }
}