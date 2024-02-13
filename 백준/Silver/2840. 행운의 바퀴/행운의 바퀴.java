import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int rotate = sc.nextInt();
        char[] plate = new char[num];
        boolean[] exist = new boolean[26];
        for(int i=0; i<num; i++){
            plate[i]='?';
        }
        int now=0;
        for(int i=0; i<rotate; i++){
            int rotateNum = sc.nextInt();
            char letter = sc.next().charAt(0);
            String empty = sc.nextLine();
            now += rotateNum;
            now %= num;

            if(plate[now]=='?'){
                if(exist[letter-'A']){
                    System.out.println("!");
                    return;
                }else{
                    plate[now]=letter;
                    exist[letter-'A'] = true;
                }
            }else if(plate[now]==letter){

            } else {
                System.out.println("!");
                return;
            }
        }
        for(int i=0;i<num;i++){
            int index = (now - i+num) % num;
            System.out.print(plate[index]);
        }

        System.out.println();

    }
}
