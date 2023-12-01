import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        final int length = topping.length;
        int[] count = new int[10001];

        Set<Integer> setA = new HashSet<>();
        setA.add(topping[0]);
        Set<Integer> setB = new HashSet<>();
        for(int i = 1; i < length; i++) {
            final int current = topping[i];
            setB.add(current);
            count[current] ++;
        }


        for (int i = 1; i < length; i++) {
            final int current = topping[i];
            
            setA.add(current);
            count[current]--;
            if(count[current] == 0) {
                setB.remove(current);
            }
            
            if (setA.size() == setB.size()) {
                answer++;
            }
        }
        return answer;
    }
}