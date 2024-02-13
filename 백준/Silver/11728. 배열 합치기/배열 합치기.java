
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        int indexN = 0;
        int indexM = 0;
        String[] str = br.readLine().split(" ");
        String[] str2 = br.readLine().split(" ");

        int[] ans = new int[N+M];
        while(indexN<N && indexM<M){
            Integer nElement = Integer.parseInt(str[indexN]);
            Integer mElement = Integer.parseInt(str2[indexM]);
            if(nElement<mElement){
                ans[indexN+indexM] = nElement;
                indexN++;
            }else{
                ans[indexN+indexM] = mElement;
                indexM++;
            }
        }
        if(indexN ==N){
            while(indexM<M){
                Integer mElement = Integer.parseInt(str2[indexM]);
                ans[indexN+indexM] = mElement;
                indexM++;
            }
        }
        if(indexM ==M){
            while(indexN<N){
                Integer nElement = Integer.parseInt(str[indexN]);
                ans[indexN+indexM] = nElement;
                indexN++;
            }
        }

        for (Integer integer : ans) {
            bw.write(integer+" ");
        }
        bw.write("\n");
        bw.flush();
    }
}
