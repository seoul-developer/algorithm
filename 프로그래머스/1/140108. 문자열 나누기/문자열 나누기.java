class Solution {

    public int solution(String s) {
        int answer = 0;

        String result = s;

        while (true) {
            result = execute(result);
            answer++;

            if (result.length() == 0) {
                break;
            }
        }

        return answer;
    }

    private String execute(final String s) {
        char x = s.charAt(0);
        System.out.println("x = " + x);
        int same = 0;
        int diff = 0;

        final char[] chars = s.toCharArray();

        int i;
        for (i = 0; i < chars.length; i++) {
            final char curr = chars[i];
            System.out.println("curr = " + curr);
            if (x == chars[i]) {
                same++;
            } else {
                diff++;
            }

            if (same == diff) {
                break;
            }
        }

        StringBuilder result = new StringBuilder();

        for (int j = i + 1; j < chars.length; j++) {
            result.append(chars[j]);
        }

        return result.toString();
    }
}
