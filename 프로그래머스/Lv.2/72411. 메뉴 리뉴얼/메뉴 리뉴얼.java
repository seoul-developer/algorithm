import java.util.*;

class Solution {
        String[][] split;
    List<String> result = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        split = new String[orders.length][10];
        
        for(int i = 0; i < orders.length; i++) {
            split[i] = orders[i].split("");
            Arrays.sort(split[i]);
        }
        
        for(int i = 0; i < course.length; i++) {
            createCourse(course[i]);
        }
        
        Collections.sort(result);
        String[] answer = new String[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    private void createCourse(int courseSize) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int row = 0; row < split.length; row++) {
            int columnMax = split[row].length;
            if(courseSize > columnMax) continue;
            combination(map, 0, courseSize, row, columnMax, new StringBuilder());
        }
        
        int max = 2;
        Set<String> maxs = new HashSet<>();
        for (String s : map.keySet()) {
            int tmp = map.get(s);
            if(max < tmp) {
                max = tmp;
                maxs.clear();
                maxs.add(s);
            }else if(max == tmp){
                maxs.add(s);
            }
        }
        
        for (String s : maxs) {
            result.add(s);
        }
    }
    
    private void combination(Map<String, Integer> map, int turn, int leftSize, int rowNumber, int columnMax, StringBuilder sb) {
        if(leftSize == 0) {
            String k = sb.toString();
            int count = map.getOrDefault(k, 0);
            map.put(k, count + 1);
            return;
        }
        
        if(leftSize + turn > columnMax) return;
        
        StringBuilder newSb = new StringBuilder(sb);
        newSb.append(split[rowNumber][turn]);
        combination(map, turn+1, leftSize-1, rowNumber, columnMax, newSb);
        combination(map, turn+1, leftSize, rowNumber, columnMax, sb);
    }

}