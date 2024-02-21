import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] time = new int[book_time.length][2];
        for(int i = 0; i < book_time.length; i++) {
            String[] tmp1 = book_time[i][0].split(":");
            time[i][0] = Integer.parseInt(tmp1[0])*60 + Integer.parseInt(tmp1[1]);
            String[] tmp2 = book_time[i][1].split(":");
            time[i][1] = Integer.parseInt(tmp2[0])*60 + Integer.parseInt(tmp2[1]) + 10;
        }
        
        Arrays.sort(time, (a1, a2) -> a1[0] == a2[0] ? a1[1] - a2[1] : a1[0] - a2[0]);
        
        List<Integer> rooms = new ArrayList<>();
        rooms.add(time[0][1]);
        for(int i = 1; i < time.length; i++) {
            boolean flag = false;
            for(int j = 0; j < rooms.size(); j++) {
                if(rooms.get(j) <= time[i][0]) {
                    rooms.set(j, time[i][1]);
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                rooms.add(time[i][1]);
            }
            Collections.sort(rooms);
        }
        
        return rooms.size();
    }
}