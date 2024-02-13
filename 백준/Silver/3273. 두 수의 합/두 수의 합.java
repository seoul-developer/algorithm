import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int number = Integer.parseInt(br.readLine());
        String[] element = br.readLine().split(" ");
        //5 12 7 10 9 1 2 3 11
        int target = Integer.parseInt(br.readLine());
        boolean[] exist = new boolean[1000001];

        for(int i=0; i<number;i++) {
            int a = Integer.parseInt(element[i]);
            exist[a] = true;
        }

        int count =0;
        for(int i=0; i<number;i++){
            int part1 = Integer.parseInt(element[i]);
            int part2 = target - part1;
            if(0<=part2 && part2<=1000000){
                if(exist[part2]){
                    count++;
                    if(part1 ==part2)
                        count --;
                }
            }
        }
        System.out.println(count/2);
    }
}
