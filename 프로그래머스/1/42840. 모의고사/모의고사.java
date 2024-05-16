import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] scores = {0, 0, 0};
        // student 1
        int[] student1Pattern = {1, 2, 3, 4, 5};
        for (int i = 0; i < answers.length; i++) {
            final int answer = answers[i];
            final int reply = student1Pattern[i % student1Pattern.length];

            if (answer == reply) {
                scores[0]++;
            }
        }

        int[] student2Pattern = {2, 1, 2, 3, 2, 4, 2, 5};
        for (int i = 0; i < answers.length; i++) {
            final int answer = answers[i];
            final int reply = student2Pattern[i % student2Pattern.length];

            if (answer == reply) {
                scores[1]++;
            }
        }

        int[] student3Pattern = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for (int i = 0; i < answers.length; i++) {
            final int answer = answers[i];
            final int reply = student3Pattern[i % student3Pattern.length];

            if (answer == reply) {
                scores[2]++;
            }
        }

        final List<Integer> answer = new ArrayList<>();
        final int maxScore = Arrays.stream(scores).max().getAsInt();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(it -> it).toArray();
    }
}