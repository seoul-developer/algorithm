import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int[][] coors = new int[num][2];
        String[] input = br.readLine().split(" ");
        for(int i=0;i<num;i++) {
            coors[i][0] = Integer.parseInt(input[i]);
            coors[i][1] = i;
        }
        Arrays.sort(coors, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] -o2[0];
            }
        });

        int[] ans = new int[num];
        int index = 0;
        ans[coors[0][1]] = index;
        for(int k =1;k<num;k++){
            if(coors[k][0]==coors[k-1][0]){
                ans[coors[k][1]] = index;
            }else{
                ans[coors[k][1]] = ++index;
            }
        }
        for(int i=0;i<num;i++)
            bw.write(ans[i]+" ");
        bw.write("\n");
        bw.flush();
    }
}


