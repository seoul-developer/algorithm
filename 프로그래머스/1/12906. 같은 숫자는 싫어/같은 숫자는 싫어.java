import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<arr.length; i++){
            int a = arr[i];
            if(stack.isEmpty()){
                stack.push(a);
            }
            if(!stack.isEmpty()){
                int b = stack.pop();
                if(a==b){
                    stack.push(a);
                }
                if(a!=b){
                    stack.push(b);
                    stack.push(a);
                }
            }
        }
        
        return stack.stream().mapToInt(i->i).toArray();
    }
}