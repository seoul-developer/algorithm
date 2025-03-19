import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] numbers = new int[n];
        for(int i=0; i<n; i++){
            numbers[i] = 1;
        }
        for(int l: lost) {
            numbers[l-1]--;
        }
        for(int r: reserve) {
            numbers[r-1]++;
        }
        
        int cnt = n-lost.length;
        
        for(int i=0; i<n; i++) {
            if(i-1>=0 && numbers[i-1]>=2 && numbers[i]==0) {
                numbers[i-1]--;
                numbers[i]++;
            } else if(i+1<n && numbers[i]==0 && numbers[i+1]>=2) {
                numbers[i]++;
                numbers[i+1]--;
            }
        }
    
        return (int) Arrays.stream(numbers).filter(i->i>=1).count();
    }
}