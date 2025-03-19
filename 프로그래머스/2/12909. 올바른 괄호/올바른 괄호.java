import java.util.*;

class Solution {
    boolean solution(String s) {
        System.out.println("Hello Java");

        char[] str = s.toCharArray();
        
        Queue<String> queue = new LinkedList<>();
        
        for(char a: str) {
            if(a=='(' || a==')'){
                queue.offer(String.valueOf(a));
            }
        }
        
        int o = 0;
        int p = 0;
        while(!queue.isEmpty()) {
            if(p>o){
                return false;
            }
            
            String curr = queue.poll();
            if(curr.equals("(")){
                o++;
            }
            if(curr.equals(")")){
                p++;
            }
        }
        
        return o==p;
    }
}