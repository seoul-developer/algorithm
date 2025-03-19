import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> tmp = new ArrayList<>();
        
        for(int index = 0; index < commands.length; index++){
            tmp = new ArrayList<>();
            
            int[] command = commands[index];
            int i = command[0];
            int j = command[1];
            int k = command[2];
            
            for(int x=i; x<=j; x++){
                tmp.add(array[x-1]);
            }
            
            Collections.sort(tmp);
            answer[index] = tmp.get(k-1);
        }
        
        return answer;
    }
}