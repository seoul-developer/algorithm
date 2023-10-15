import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {

    public static int[] solution(String today, String[] terms, String[] privacies) {
        final int[] todayDate = parseToDate(today);

        final HashMap<String, Integer> termsMap = createTermsMap(terms);

        final List<Integer> answer = new ArrayList<>();

        for (int index = 0; index < privacies.length; index++) {
            final String privacy = privacies[index];
            final Object[] array = Arrays.stream(privacy.split(" ")).toArray();
            final int[] startDate = parseToDate((String) array[0]);
            final String yakgwan = (String) array[1];

            final int term = termsMap.get(yakgwan);

            final int[] expireDate = getExpireDate(startDate, term);

            final boolean isExpired = compare(todayDate, expireDate);
            if (isExpired) {
                answer.add(index + 1);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private static boolean compare(final int[] todayDate, final int[] expireDate) {
        final int todayYear = todayDate[0];
        final int expireYear = expireDate[0];

        if (todayYear > expireYear) {
            return true;
        }

        final int todayMonth = todayDate[1];
        final int expireMonth = expireDate[1];

        if (todayYear == expireYear && todayMonth > expireMonth) {
            return true;
        }

        final int todayDay = todayDate[2];
        final int expireDay = expireDate[2];

        if (todayYear == expireYear && todayMonth == expireMonth && todayDay > expireDay) {
            return true;
        }
        return false;
    }

    private static int[] getExpireDate(final int[] startDate, final int term) {
        int startYear = startDate[0];
        int startMonth = startDate[1];
        int startDay = startDate[2];

        startDay += term * 28 - 1;
        if (startDay > 28) {
            startMonth += startDay / 28;
            startDay = startDay % 28;
        }
        if (startMonth > 12) {
            startYear += startMonth / 12;
            startMonth = startMonth % 12;
        }
        if (startDay == 0) {
            startMonth--;
            startDay = 28;
        }
        if (startMonth==0) {
            startYear--;
            startMonth = 12;
        }

        return new int[]{startYear, startMonth, startDay};
    }

    private static HashMap<String, Integer> createTermsMap(final String[] terms) {
        final HashMap<String, Integer> termsMap = new HashMap<>();
        for (final String term : terms) {
            final String[] array = term.split(" ");
            final String yakgwan = array[0];
            final int month = Integer.valueOf(array[1]);

            termsMap.put(yakgwan, month);
        }
        return termsMap;
    }

    private static int[] parseToDate(final String today) {
        final String[] date = today.split("\\.");

        return new int[]{
                Integer.valueOf(date[0]),
                Integer.valueOf(date[1]),
                Integer.valueOf(date[2])
        };
    }
}