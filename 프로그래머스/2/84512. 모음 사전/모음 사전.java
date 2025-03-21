import java.util.*;

class Solution {
    
    List<String> list;
    String[] words = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        int answer = 0;
        list=new ArrayList<>();
        dfs("",0);
        
        int size = list.size();
        for(int i=0; i<size; i++) {
            if(list.get(i).equals(word)) {
                return i;
            }
        }
        
        return answer;
    }
    
    private void dfs(String str, int len){
        list.add(str);
        if(len==5){
            return;
        }
        for(int i=0; i<5; i++){
            dfs(str+words[i], len+1);
        }
    }
}