import java.util.*;

class Solution {
    
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        Set<Integer> res = dfs("", numbers, visited);

        int cnt = 0;
        
        for(int number: res){
            if(isPrime(number)){
                cnt++;
            }
        }
        
        return cnt;
    }
    
    private Set<Integer> dfs(String curr, String numbers, boolean[] visited){
        Set<Integer> res = new HashSet<>();
        
        if(!curr.isEmpty()){
            res.add(Integer.parseInt(curr));
        }
        
        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                res.addAll(dfs(curr + numbers.charAt(i), numbers, visited));
                // 복구
                visited[i] = false;
            }
        }
        
        return res;
    }
    
    private boolean isPrime(int num){
        if(num<2) {
            return false;
        }
        
        for(int i=2; i<=num-1; i++){
            if(num % i == 0){
                return false;
            }
        }
        
        return true;
    }
}