class Solution {

    public int[] solution(int[] arr, int[][] intervals) {
        int num = 0;
        for (final int[] interval : intervals) {
            num += interval[1] - interval[0] + 1;
        }

        int[] answer = new int[num];
        int i = 0;

        for (final int[] interval : intervals) {
            final int startIndex = interval[0];
            final int endIndex = interval[1];

            for (int index = startIndex; index <= endIndex; index++) {
                answer[i] = arr[index];
                i++;
            }
        }
        return answer;
    }
}