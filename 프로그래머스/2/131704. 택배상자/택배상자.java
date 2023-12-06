import java.util.Stack;

class Solution {
    public int solution(int[] order) {

        Stack<Integer> stack = new Stack<>();
        
        int orderIndex = 0;
        for(int box = 1; box <= order.length; box++) {
            if(order[orderIndex] == box) {
                orderIndex ++;
                continue;
            }
            while(!stack.isEmpty() && stack.peek() == order[orderIndex]) {
                stack.pop();
                orderIndex++;
            }
            stack.push(box);
        }
        while(!stack.isEmpty() && stack.peek() == order[orderIndex]) {
            stack.pop();
            orderIndex++;
        }
        return orderIndex;
    }
}