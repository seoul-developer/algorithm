class Solution {
    
    private int[] numbers;
    private int target;
    private int answer = 0;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        // 현재까지 더한 결과, 다음 정해야 할 숫자
        dfs(0, 0);
        
        return answer;
    }
    
    private void dfs(int sum, int idx) {
        if (idx == numbers.length) {
            if(sum == target) {
                answer++;    
            }
            return;
        }
        
        dfs(sum + numbers[idx], idx + 1);
        dfs(sum - numbers[idx], idx + 1);
    }
}