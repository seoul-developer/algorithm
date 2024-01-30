import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String empty = sc.nextLine();
        String[] words = new String[num];
        for(int i=0;i<num;i++){
            String str = sc.nextLine();
            words[i] = str;
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()==o2.length()){
                    return o1.compareTo(o2);
                }
                else
                    return o1.length()-o2.length();
            }
        });
        System.out.println(words[0]);
        for(int i=1;i<num;i++){
            if(words[i].equals(words[i-1])){

            }else{
                System.out.println(words[i]);
            }
        }
    }
}
