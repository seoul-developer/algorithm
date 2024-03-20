import java.util.*;

class Solution {
    char[][] charMap;
    boolean[][] visit;
    
    public int solution(String[] maps) {
        charMap = new char[maps.length][maps[0].length()];
        visit = new boolean[maps.length][maps[0].length()];
        
        int[] start = new int[2];
        int[] lever = new int[2];
        
        for(int i = 0; i < maps.length; i++) {
            String line = maps[i];
            for(int k = 0; k < maps[0].length(); k++) {
                charMap[i][k] = line.charAt(k);
                if(line.charAt(k) == 'S') {
                    start[0] = i;
                    start[1] = k;
                }else if(line.charAt(k) == 'L') {
                    lever[0] = i;
                    lever[1] = k;
                }
            }
        }
        
        Queue<Info> q = new LinkedList<>();
        q.offer(new Info(start, 0));
        int leverTime = -1;
        while(!q.isEmpty()) {
            Info current = q.poll();
            int[] location = current.location;
            if(visit[location[0]][location[1]]) {
                continue;
            }
            visit[location[0]][location[1]] = true;
            
            char type = charMap[location[0]][location[1]];
            if(type == 'X') {
                continue;
            }else if(type == 'L') {
                leverTime = current.time;
                break;
            }

            if(location[0] + 1 < charMap.length) q.offer(new Info(
                new int[]{location[0] + 1, location[1]}, current.time + 1));
            if(location[0] - 1 >= 0) q.offer(new Info(
                new int[]{location[0] - 1, location[1]}, current.time + 1));
            if(location[1] + 1 < charMap[0].length) q.offer(new Info(
                new int[]{location[0], location[1] + 1}, current.time + 1));
            if(location[1] - 1 >= 0 ) q.offer(new Info(
                new int[]{location[0], location[1] - 1}, current.time + 1));
        }
        
        if(leverTime == -1) { //레버를 찾을 수 없음
            return -1;
        }
        
        q.clear();
        visit = new boolean[maps.length][maps[0].length()];
        q.offer(new Info(lever, leverTime));
        
        while(!q.isEmpty()) {
            Info current = q.poll();
            int[] location = current.location;
            if(visit[location[0]][location[1]]) {
                continue;
            }
            //System.out.println(location[0] + ", " + location[1]);
            visit[location[0]][location[1]] = true;
            
            char type = charMap[location[0]][location[1]];
            if(type == 'X') {
                continue;
            }else if(type == 'E') {
                return current.time;
            }

            if(location[0] + 1 < charMap.length) q.offer(new Info(
                new int[]{location[0] + 1, location[1]}, current.time + 1));
            if(location[0] - 1 >= 0) q.offer(new Info(
                new int[]{location[0] - 1, location[1]}, current.time + 1));
            if(location[1] + 1 < charMap[0].length) q.offer(new Info(
                new int[]{location[0], location[1] + 1}, current.time + 1));
            if(location[1] - 1 >= 0 ) q.offer(new Info(
                new int[]{location[0], location[1] - 1}, current.time + 1));
        }
        return -1;
    }
    
    class Info {
        int[] location;
        int time;
        
        public Info(int[] location, int time) {
            this.location = location;
            this.time = time;
        }
    }
}