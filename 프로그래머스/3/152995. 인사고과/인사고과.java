import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int wonho = scores[0][1] + scores[0][0];
        List<Integer> higherThanWonho = new ArrayList<>();
        for(int i = 1; i < scores.length; i++) {
            if(scores[0][1] < scores[i][1] && scores[0][0] < scores[i][0]) {
                return -1;
            }else if(wonho < scores[i][1] + scores[i][0]) {
                higherThanWonho.add(i);
            }
        }
        Collections.sort(higherThanWonho, (n1, n2) -> scores[n1][0] == scores[n2][0] ? scores[n2][1] - scores[n1][1] : scores[n2][0] - scores[n1][0]);

        Set<Integer> noIncentive = new HashSet<>();
        for(int i = 0; i < higherThanWonho.size(); i++) {
            int index = higherThanWonho.get(i);
            if(i >= 1 && scores[index][0] == scores[higherThanWonho.get(i-1)][0]) continue;
            if(noIncentive.contains(index)) continue;
            for(int k = i+1; k < higherThanWonho.size(); k++) {
                int index2 = higherThanWonho.get(k);
                if(noIncentive.contains(index2)) continue;
                if(scores[index][1] > scores[index2][1] && scores[index][0] > scores[index2][0]) {
                    noIncentive.add(index2);
                }
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < scores.length; i++) {
            if(noIncentive.contains(i)) continue;
            int score = scores[i][0] + scores[i][1];
            Integer count = map.getOrDefault(score, 0);
            map.put(score, count+1);
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, Collections.reverseOrder());
        int count = 0;
        int index = 0;
        int key = keySet.get(0);
        while(key > wonho) {
            count += map.get(key);
            index += 1;
            key = keySet.get(index);
        }
        
        return count + 1;
    }
}