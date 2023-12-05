import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    
    List<Integer> answers = new ArrayList<>();
    public int solution(int storey) {
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(new ArrayList<>(List.of(storey, 0)));
        while(!q.isEmpty()) {
            final List<Integer> poll = q.poll();
            int tmp = poll.get(0);
            int answer = poll.get(1);
            
            if(tmp % 10 == 5) {
                final int round = (tmp + 5) / 10 * 10;
                int answer2 = answer + round- tmp;
                int tmp2 = (int)(round * 0.1);
                if(round == 0) {
                    answers.add(answer2);
                }else{
                    q.add(new ArrayList<>(List.of(tmp2, answer2)));   
                }
            }
            
            final int round = (tmp + 4) / 10 * 10;
            if(round >= tmp) {
                answer += round- tmp;
            }else{
                answer += tmp - round;
            }
            tmp = (int)(round * 0.1);
            if(round == 0) {
                answers.add(answer);
            }else{
                q.add(new ArrayList<>(List.of(tmp, answer)));   
            }
        }
        Collections.sort(answers);
        return answers.get(0);
    }

}