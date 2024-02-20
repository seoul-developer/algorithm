import java.util.*;

class Solution {
    
    List<Integer> list = new ArrayList<>();
    int minCount = Integer.MAX_VALUE;
    int length;
    boolean[] remain;

    public int solution(String name) {
        length = name.length();
        remain = new boolean[length];
        
        int first = -1;
        int last = -1;
        for(int i = 0; i < length; i++) {
            if(name.charAt(i) != 'A') {
                remain[i] = true;
                if(first == -1) first = i;
                if(last < i) last = i;
            }
        }
        
        if(first != -1) {
            remain[first] = false;
            moveLeft(new ArrayList<>(List.of(first)), first);
            moveRight(new ArrayList<>(List.of(first)), first);
            remain[first] = true;
        }
        if(last != -1) {
            remain[last] = false;
            moveRight(new ArrayList<>(List.of(last)), length - last);
            moveLeft(new ArrayList<>(List.of(last)), length - last);
            remain[last] = true;   
        }

        if(minCount == Integer.MAX_VALUE) return 0;
        
        int answer = minCount;
        for(int c : list) {
            int difference = name.charAt(c) - 'A';
            if(difference > 13) difference = 26 - difference;
            answer += difference;
        }

        return answer;
    }

    public void moveLeft(List<Integer> orders, int count) {
        for(int i = 0; i < remain.length; i++) {
            if(remain[i]) break;
            if(i == remain.length-1) {
               if(minCount > count) {
                    list = new ArrayList<>(orders);
                    minCount = count;
                }
                return; 
            }
        }

        int last = orders.get(orders.size()-1);
        for(int i = 1; i < length; i++) {
            int index = last-i;
            if(index < 0) index = index + length;
            if(remain[index]) {
                remain[index] = false;
                orders.add(index);
                moveLeft(orders, count + i);
                moveRight(orders, count + i);
                orders.remove(orders.size()-1);
                remain[index] = true;
                break;
            }
        }
    }

    public void moveRight(List<Integer> orders, int count) {
        for(int i = 0; i < remain.length; i++) {
            if(remain[i]) break;
            if(i == remain.length-1) {
                if(minCount > count) {
                    list = new ArrayList<>(orders);
                    minCount = count;
                }
                return; 
            }
        }
        int last = orders.get(orders.size()-1);
        for(int i = 1; i < length; i++) {
            int index = last+i;
            if(index >= length) index = index - length;
            if(remain[index]) {
                remain[index] = false;
                orders.add(index);
                moveLeft(orders, count + i);
                moveRight(orders, count + i);
                orders.remove(orders.size()-1);
                remain[index] = true;
                break;
            }
        }
    }
}
