class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] result = {-1, sequence.length};
        int start = 0;
        int end = 0;
        int sum = sequence[0];
        while(true) {
            if(sum < k) {
                end++;
                if(end >= sequence.length) {
                    break;
                }
                sum += sequence[end];
            }else if(sum > k) {
                sum -= sequence[start];
                start ++;
            }else {
                final int original = result[1] - result[0];
                final int current = end - start;
                if(original > current || (original == current && result[0] > start)) {
                    result[0] = start;
                    result[1] = end;
                }
                sum -= sequence[start];
                start++;
            }
        }
        return result;
    }
}