import java.util.*;

class Solution {
    
    private Set<String> nonNum = new HashSet<>(List.of("+", "-"));
    
    public int solution(String arr[]) {
        int N = arr.length;
        
        int[] nums = new int[arr.length / 2 + 1];
        String[] ops = new String[arr.length / 2];
        
        for(int i=0; i<arr.length; i++) {
            String val = arr[i];
            int idx = i/2;

           if (!nonNum.contains(val)) {
             nums[i/2] = Integer.parseInt(val);
           } else {
             ops[(i-1)/2] = val;
           }
        }
        
        int numCnt = nums.length;
        int[][] maxDp = new int[numCnt][numCnt]; // i~j까지의 최대값
        int[][] minDp = new int[numCnt][numCnt]; // i~j까지의 최소값 
        
        // 구간 길이 0
        for(int i=0; i<nums.length; i++) {
            maxDp[i][i] = nums[i];
            minDp[i][i] = nums[i];
        }
        
        // len 1 
        for(int i=0; i< nums.length - 1; i++) {
            String op = ops[i];
            int a = nums[i];
            int b = nums[i+1];
            // System.out.printf("%d ~ %d %d %s %d%n", i, i+1, a, op, b);

            if(op.equals("+")) {
                int val = a+b;
                maxDp[i][i+1] = val;
                minDp[i][i+1] = val;
             } else if (op.equals("-")) {
                int val = a-b;
                maxDp[i][i+1] = val;
                minDp[i][i+1] = val;
            }
        }
        
        for(int len = 2; len < nums.length; len++) {
            for(int i=0; i< nums.length - len; i++) {
                int idx1 = i;
                int idx2 = i+len;
                
                maxDp[idx1][idx2] = Integer.MIN_VALUE;
                minDp[idx1][idx2] = Integer.MAX_VALUE;
                
                // System.out.printf("%d ~ %d%n", idx1, idx2);
                
                for(int k=i; k<i+len; k++) {
                    String op = ops[k];
                    
                    if(op.equals("+")) {
                        maxDp[idx1][idx2] = Math.max(maxDp[idx1][idx2], maxDp[idx1][k] + maxDp[k+1][idx2]);
                        minDp[idx1][idx2] = Math.min(minDp[idx1][idx2], minDp[idx1][k] + minDp[k+1][idx2]);
                    } else if (op.equals("-")) {
                        maxDp[idx1][idx2] = Math.max(maxDp[idx1][idx2], maxDp[idx1][k] - minDp[k+1][idx2]);
                        minDp[idx1][idx2] = Math.min(minDp[idx1][idx2], minDp[idx1][k] - maxDp[k+1][idx2]);
                    }
                }
            }
        }
        
        // for(int i=0; i<numCnt; i++) {
        //     for(int j=0; j<numCnt; j++) {
        //         System.out.print(maxDp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
                
        return maxDp[0][nums.length-1];
    }
}