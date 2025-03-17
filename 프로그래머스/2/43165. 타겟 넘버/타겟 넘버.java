class Solution {
    private int[] nums;
    private int t;
    private int answer;
    
    public int solution(int[] numbers, int target) {
        nums = numbers;
        t = target;
        
        bfs(0, 0);
        
        return answer;
    }
    
    private void bfs(int step, int sum){
        if(step == nums.length) {
            if(sum==t){
                answer++;
            }
            return;
        }
        
        bfs(step+1, sum+nums[step]);
        bfs(step+1, sum-nums[step]);
    }
}