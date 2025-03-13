class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int[] longer = new int[sizes.length];
        int[] shorter = new int[sizes.length];
        
        for(int i=0; i<sizes.length; i++){
            int[] size = sizes[i];
            int a = size[0];
            int b = size[1];
            
            longer[i] = Math.max(a, b);
            shorter[i] = Math.min(a, b);
        }

        int longerMax = max(longer);
        int shorterMax = max(shorter);
        
        return longerMax * shorterMax;
    }
    
    private int max(int[] arr){
        int max = 0;
        for(int val: arr){
            if(val > max){
                max = val;
            }
        }
        
        return max;
    }
}