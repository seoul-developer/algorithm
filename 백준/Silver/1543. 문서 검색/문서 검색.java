import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String target = sc.nextLine();
        String newString = str.replace(target,"?");
        int count = 0;
        for(int i=0; i<newString.length();i++){
            if (newString.charAt(i)=='?')
                count++;
        }

        System.out.println(count);
    }
}
