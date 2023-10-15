import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            final String[] split = term.split(" ");
            map.put(split[0], Integer.parseInt(split[1]));
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            final String[] split = privacies[i].split(" ");
            final String type = split[1];
            final String[] date = split[0].split("\\.");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);

            final Integer plusMonth = map.get(type);
            final int mTmp = month + plusMonth;
            if ((mTmp - 1) / 12 != 0) {
                final int t1 = mTmp % 12;
                final int t2 = (mTmp -1) / 12;
                month = (t1 == 0) ? 12 : t1;
                year += t2;
            } else {
                month += plusMonth;
            }
            day--;

            if (day == 0) {
                day = 28;
                if (month - 1 == 0) {
                    month = 12;
                    year--;
                } else {
                    month--;
                }
            }

            final int finishDate = year * 10000 + month * 100 + day;
            final String[] splitToday = today.split("\\.");
            final int todayDate = Integer.parseInt(splitToday[0]) * 10000
                    + Integer.parseInt(splitToday[1]) * 100
                    + Integer.parseInt(splitToday[2]);

            if (finishDate < todayDate){
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(each -> each).toArray();
    }
}