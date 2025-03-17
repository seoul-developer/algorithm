import java.util.*;

class Solution {
    private boolean[] used;
    private List<String> routes;
    
    public String[] solution(String[][] tickets) {
        int cnt = 0;
        routes = new ArrayList<>();
        used = new boolean[tickets.length];

        dfs("ICN", "ICN", tickets, cnt);
        
        Collections.sort(routes);
        return routes.get(0).split(" ");
    }
    
    private void dfs(String start, String route, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            routes.add(route);
        }
        
        for (int i=0; i<tickets.length; i++) {
            String dep = tickets[i][0];
            String dest = tickets[i][1];
            if(start.equals(dep) && !used[i]) {
                used[i] = true;
                dfs(dest, route + " " + dest, tickets, cnt+1);
                used[i] = false;
            }
        }
    }
}