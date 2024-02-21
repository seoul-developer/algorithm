import java.util.*;

class Solution {
    
    List<Integer> result = new ArrayList<>();
    int length;
    
    public String[] solution(String[][] tickets) {
        length = tickets.length;
        for(int i = 0; i < length; i++) {
            if(tickets[i][0].equals("ICN")) {
                dfs(i, tickets);   
            }
        }
        
        String[] answer = new String[result.size() + 1];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = tickets[result.get(i)][0];
            if(i == result.size()-1) {
                answer[i+1] = tickets[result.get(i)][1];
            }
        }
        return answer;
    }
    
    public void dfs(int fromIndex, String[][] tickets) {
        Stack<List<Integer>> s = new Stack<>();
        s.push(new ArrayList<>(List.of(fromIndex)));
        
        while(!s.isEmpty()) {
            List<Integer> pop = s.pop();
            int index = pop.get(pop.size()-1);
            if(pop.size() == length) {
                end(pop, tickets);
                continue;
            }
            
            for(int i = 0; i < tickets.length; i++) {
                if(tickets[i][0].equals(tickets[index][1]) && !pop.contains(i)) {
                    List<Integer> newList = new ArrayList(pop);
                    newList.add(i);
                    s.push(newList);
                }
            }
        }
    }
    
    public void end(List<Integer> list, String[][] tickets) {
        if(result.isEmpty()) {
            result = list;
            return;
        }
        for(int i = 0; i < length; i++) {
            int resultIndex = result.get(i);
            int listIndex = list.get(i);
            if(tickets[resultIndex][1].equals(tickets[listIndex][1])) {
                continue;
            }else if(tickets[resultIndex][1].compareTo(tickets[listIndex][1]) > 0) {
                result = list;
            }
            return;
        }
    }
}