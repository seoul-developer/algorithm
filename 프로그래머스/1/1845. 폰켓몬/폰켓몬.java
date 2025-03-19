import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int N = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        return Math.min(N/2, map.keySet().size());
    }
}