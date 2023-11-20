class Solution {
        public int solution(int[] queue1, int[] queue2) {
        final int length = queue1.length;
        int[] q = new int[length * 2];
        long sum = 0;
        for (int i = 0; i < length; i++) {
            sum += queue1[i] + queue2[i];
            q[i] = queue1[i];
            q[i + length] = queue2[i];
        }
        if (sum % 2 != 0) {
            return -1;
        }

        int start = 0;
        int end = length;
        long tmp = 0;
        for(int i = start; i < end; i++) {
            tmp += q[i];
        }

        long want = sum / 2;
        int count = 0;
        while(true) {
            if(tmp > want) {
                tmp -= q[start];
                start++;
                count++;
            }else if(tmp < want) {
                if(end == length * 2){
                    return -1;
                }
                tmp += q[end];
                end++;
                count++;
            }
            if(tmp == want){
                return count;
            }
        }
    }

}