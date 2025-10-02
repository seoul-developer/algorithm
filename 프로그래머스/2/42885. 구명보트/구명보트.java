import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1; // pointer
        
        int answer = 0;

        while (l <= r) {
            int light = people[l];
            int heavy = people[r];
            
            if (light + heavy <= limit) {
                answer++;
                l++;
                r--;
            } else {
                answer++;
                r--;
            }
        }
        
        return answer;
    }
}