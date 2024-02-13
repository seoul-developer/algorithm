import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while(N-->0){
            String word = br.readLine();
            int l = 0;
            int r = word.length()-1;
            int ans=0;
            while(l<=r){
                if(word.charAt(l)!=word.charAt(r)){
                    if(validPalindrome(word,l,r-1) || validPalindrome(word,l+1,r)) ans =1;
                    else{
                        ans =2;
                    }
                    break;
                }
                l++;
                r--;
            }
            System.out.println(ans);
        }
    }
    public static boolean validPalindrome(String str,int left, int right){
        while(left<=right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
