import java.util.Scanner;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String ans = "";

        for (int i=0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (ch>='A' && ch<= 'Z'){
                ans +=(char) (ch +'a'-'A');
            } else{
                ans +=(char)(ch +'A'-'a');
            }
        }
        System.out.println(ans);
    }
}
