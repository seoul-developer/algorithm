import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        int X = Integer.parseInt(firstLine[2]);
        Integer[] need = new Integer[N];
        Set<Integer> needSet = new HashSet<>(Arrays.asList(need));
        Integer[] have = new Integer[M];
        Set<Integer> haveSet = new HashSet<>(Arrays.asList(have));

        String[] secondLine = br.readLine().split(" ");
        String[] thirdLine = br.readLine().split(" ");

        for(int i=0;i<N;i++)
            need[i] = Integer.parseInt(secondLine[i]);
        for(int j=0;j<M;j++)
            have[j]= Integer.parseInt(thirdLine[j]);

        int l = 0;
        int r = Math.min(M,N);
        int ans = 0;

        Arrays.sort(need);
        Arrays.sort(have);

        while(l<=r){
            int m = (l+r)/2 ;
            if(calcMinSupport(need,have,m)<=X){
                ans = m;
                l=m+1;
            }
            else r =m-1;
        }
        System.out.println(ans);

    }

    private static long calcMinSupport(Integer[] need, Integer[] have, int m) {
        long needDiff = 0;
        for(int i=0;i<m;i++){
            needDiff += Math.max(need[i]-have[have.length-m+i],0);
        }
        return needDiff;
    }
}
