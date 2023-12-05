class Solution {

    public static void main(String[] args) {
        final Solution solution = new Solution();
        final String res = solution.solution("abc1abc1abc");
        System.out.println("res = " + res);
    }

    public String solution(String code) {
        final StringBuilder answer = new StringBuilder();
        boolean mode = false;

        for (int i = 0; i < code.length(); i++) {
            final char ch = code.charAt(i);
            if (ch == '1') {
                mode = !mode;
                continue;
            }

            if (!mode) {
                if (i % 2 == 0) {
                    answer.append(ch);
                }
            } else {
                if (i % 2 != 0) {
                    answer.append(ch);
                }
            }
        }

        final String res = answer.toString();

        if (res.isEmpty()) {
            return "EMPTY";
        }

        return res;
    }
}