class Solution {

    public String solution(String new_id) {
        String answer;
        
        // #1
        answer = firstStep(new_id);
        System.out.println("answer 1 = " + answer);

        // #2
        answer = secondStep(answer);
        System.out.println("answer 2 = " + answer);

        // #3
        answer = thirdStep(answer);
        System.out.println("answer 3 = " + answer);

        // #4
        answer = fourthStep(answer);
        System.out.println("answer 4 = " + answer);

        // #5
        answer = fifthStep(answer);
        System.out.println("answer 5 = " + answer);

        // #6
        answer = sixthStep(answer);
        System.out.println("answer 6 = " + answer);

        // #7
        answer = seventhStep(answer);
        System.out.println("answer 7 = " + answer);

        return answer;
    }

    private static String firstStep(final String new_id) {
        return new_id.toLowerCase();
    }

    private static String secondStep(String answer) {
        StringBuilder result = new StringBuilder();
        for (final char ch : answer.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                result.append(ch);
                continue;
            }
            if (ch >= '0' && ch <= '9') {
                result.append(ch);
                continue;
            }
            if (ch == '-' || ch == '_' || ch == '.') {
                result.append(ch);
            }
        }
        answer = result.toString();
        return answer;
    }

    private static String thirdStep(String answer) {
        int[] countDot = new int[answer.length()];
        int cnt = 0;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == '.') {
                cnt++;
            }
            if (answer.charAt(i) != '.') {
                cnt = 0;
            }
            countDot[i] = cnt;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < countDot.length; i++) {
            final int count = countDot[i];
            if (count < 2) {
                result.append(answer.charAt(i));
            }
        }
        answer = result.toString();
        return answer;
    }

    private static String fourthStep(String answer) {
        if (answer.startsWith(".")) {
            answer = answer.substring(1);
        }
        if (answer.endsWith(".")) {
            answer = answer.substring(0, answer.length() - 1);
        }
        return answer;
    }

    private static String fifthStep(final String answer) {
        if (answer == null || answer.isBlank() || answer.isEmpty()) {
            return "a";
        }
        return answer;
    }

    private static String sixthStep(String answer) {
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }
        if (answer.endsWith(".")) {
            answer = answer.substring(0, 14);
        }
        return answer;
    }

    private static String seventhStep(String answer) {
        if (answer.length() <= 2) {
            final char last = answer.charAt(answer.length() - 1);
            final StringBuilder result = new StringBuilder();
            for (final char ch : answer.toCharArray()) {
                result.append(ch);
            }
            while (result.length() < 3) {
                result.append(last);
            }
            answer = result.toString();
        }
        return answer;
    }
}
