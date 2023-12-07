class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            final long number = numbers[i];
            String bit = Long.toBinaryString(number);
            final char last = bit.charAt(bit.length() - 1);
            if(last == '0') {
                answer[i] = number + 1;
                continue;
            }
            for(int k = bit.length() - 1; k >= 0; k--) {
                if(bit.charAt(k) == '0') {
                    //k를 1로 k+1을 0으로
                    final StringBuilder stringBuilder = new StringBuilder(bit);
                    stringBuilder.setCharAt(k, '1');
                    stringBuilder.setCharAt(k+1, '0');
                    answer[i] = Long.parseLong(stringBuilder.toString(), 2);
                    break;
                }else if(k == 0) {
                    final StringBuilder stringBuilder = new StringBuilder(bit);
                    stringBuilder.setCharAt(0, '0');
                    final StringBuilder append = new StringBuilder("1").append(stringBuilder);
                    answer[i] = Long.parseLong(append.toString(), 2);
                    break;
                }
            }
        }
        return answer;
    }
}