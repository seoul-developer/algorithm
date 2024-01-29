import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); //60466175
        int formation = sc.nextInt(); //36
        String numFormation = "";
        while(num!=0){
            int letter = num % formation;
            if(letter>=10){
                numFormation += (char)(letter+'A'-10);
            }else{
                numFormation += letter;
            }
            num/=formation;
        }
        String reverse = new StringBuilder(numFormation).reverse().toString();
        System.out.println(reverse);
    }
}
