package org.example;

class Solution {

    public int solution(String s) {
        int answer = 0;

        char x;
        int numX = 0;
        int numNonX = 0;

        String str = s;
        while (true) {
            if (str.length() == 1) {
                answer++;
                return answer;
            }

            if (str.length() == 0) {
                return answer;
            }

            final char[] chars = str.toCharArray();
            x = chars[0];

            for (int i = 0; i < chars.length; i++) {
                final char ch = chars[i];
                if (ch == x) {
                    numX++;
                } else {
                    numNonX++;
                }

                if (numX == numNonX) {
                    answer++;
                    str = str.substring(i + 1);
                    numX = 0;
                    numNonX = 0;
                    break;
                }

                if (i == str.length() - 1) {
                    answer++;
                    numX = 0;
                    numNonX = 0;
                    break;
                }
            }
        }
    }
}
