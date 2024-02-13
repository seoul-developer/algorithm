import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        String[] membersLog = new String[num];
        for(int i=0;i<num;i++){
            String element = br.readLine();
            membersLog[i] = element;
        }
        Arrays.sort(membersLog, Comparator.reverseOrder());
        int lv =0;
        if (membersLog[0].split(" ")[1].equals("leave")){
            lv = 1;
        }else{
            lv =-1;
        }
        for (int i=1;i<num;i++){
            if(membersLog[i].split(" ")[0].equals(membersLog[i-1].split(" ")[0])){
                if(membersLog[i].split(" ")[1].equals("leave")){
                    lv++;
                }else{
                    lv--;
                }
            }else{
                if(lv==-1){
                    System.out.println(membersLog[i-1].split(" ")[0]);
                }
                if(membersLog[i].split(" ")[1].equals("leave")){
                    lv = 1;
                }else{
                    lv =-1;
                }
            }
        }
        if(lv==-1){
            System.out.println(membersLog[num-1].split(" ")[0]);
        }

    }
}
