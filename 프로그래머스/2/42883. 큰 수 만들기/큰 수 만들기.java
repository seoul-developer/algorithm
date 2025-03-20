import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        
        int length = number.length();
        int pickNumber = length - k;
        
        for(char num: number.toCharArray()) {
            while(!stack.isEmpty() && k>0 && stack.peekLast()<num) {
                stack.pollLast();
                k--;
            }
            stack.addLast(num);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<pickNumber; i++) {
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
}