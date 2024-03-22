import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        List<Minerals> list = new ArrayList<>();
        int pickCount = picks[0] + picks[1] + picks[2];
        for(int i = 0; i < minerals.length; i++) {
            if(pickCount == list.size() && list.get(list.size()-1).size == 5) {
                break;
            }
            if(i % 5 == 0) {
                Minerals element = new Minerals();
                element.add(minerals[i]);
                list.add(element);
            }else{
                list.get(list.size()-1).add(minerals[i]);
            }
        }
        
        Collections.sort(list, (m1, m2) -> 
                         m1.getTiredByStone() == m2.getTiredByStone() ? 
                         (m1.getTiredByIron() == m2.getTiredByIron() ? m2.getTiredByDia() - m1.getTiredByDia() : m2.getTiredByIron() - m1.getTiredByIron()) 
                         : m2.getTiredByStone() - m1.getTiredByStone());
               
        int answer = 0;
        for(int i = 0; i < list.size(); i++) {
            if(picks[0] != 0) {
                answer += list.get(i).getTiredByDia();
                picks[0]--;
            }else if(picks[1] != 0) {
                answer += list.get(i).getTiredByIron();
                picks[1]--;
            }else if(picks[2] != 0) {
                answer += list.get(i).getTiredByStone();
                picks[2]--;
            }
            System.out.println(answer);
            if(picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
                break;
            }
        }
        return answer;
    }
    
    class Minerals {
        int diamond = 0;
        int iron = 0;
        int stone = 0;
        Integer tiredByDia;
        Integer tiredByIron;
        Integer tiredByStone;
        int size = 0;
        
        void add(String mineral) {
            if(diamond + iron + stone == 5) {
                throw new IllegalArgumentException();
            }
            if("diamond".equals(mineral)) diamond ++;
            else if("iron".equals(mineral)) iron ++;
            else if("stone".equals(mineral)) stone ++;
            size++;
        }
        
        int getTiredByDia() {
            if(tiredByDia == null) {
                tiredByDia = diamond + iron + stone;
            }
            return tiredByDia;
        }
        
        int getTiredByIron() {
            if(tiredByIron == null) {
                tiredByIron = 5 * diamond + iron + stone;
            }
            return tiredByIron;
        }
        
        int getTiredByStone() {
            if(tiredByStone == null) {
                tiredByStone = 25 * diamond + 5 * iron + stone;
            }
            return tiredByStone;
        }
    }
}