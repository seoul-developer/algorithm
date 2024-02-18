import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int length = words.length;
        int[][] map = new int[length+1][length+1];
        for(int i = 0; i < length; i++) {
            for(int j = i+1; j < length; j++) {
                int count = countDifference(words[i], words[j]);
                if(count == 1) {
                    map[i][j] = 1;
                    map[j][i] = 1;   
                }
            }
        }
        for(int i = 0; i < length; i++) {
            int count = countDifference(words[i], begin);
            if(count == 1) {
                map[i][length] = 1;
                map[length][i] = 1;   
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        boolean[] isVisited = new boolean[length+1];
        Stack<List<Integer>> s = new Stack<>();
        s.push(List.of(length, 0)); //단어, 카운트
        
        while(!s.isEmpty()) {
            List<Integer> pop = s.pop();
            int index = pop.get(0);
            
            if(index != length && Objects.equals(words[index], target)) {
                result.add(pop.get(1));
                continue;
            }
            
            if(isVisited[index]) {
                continue;
            }
            isVisited[index] = true;
            
            for(int i = 0; i < length; i++) {
                if(isVisited[i] || map[i][index] == 0) continue;
                s.push(List.of(i, pop.get(1)+1));
            }
        }
        
        if(result.isEmpty()) {
            return 0;
        }
        Collections.sort(result);
        return result.get(0);
    }
    
    public int countDifference(String str1, String str2) {
        int count = 0;
        for(int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}