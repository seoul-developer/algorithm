import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int[] pattern1 =  {1, 2, 3, 4, 5};
    public static int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
    public static int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int a = 0;
        int b = 0;
        int c = 0;
        for(int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if(answer == pattern1[i % pattern1.length]) a++;
            if(answer == pattern2[i % pattern2.length]) b++;
            if(answer == pattern3[i % pattern3.length]) c++;
        }

        final int max = Math.max(Math.max(a, b), c);
        List<Integer> ans = new ArrayList<>();
        if(a == max) {
            ans.add(1);
        }
        if(b == max) {
            ans.add(2);
        }
        if(c == max) {
            ans.add(3);
        }
        return ans.stream().mapToInt(each -> each).toArray();
    }
}