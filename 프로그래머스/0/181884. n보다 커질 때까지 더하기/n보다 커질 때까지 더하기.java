import java.util.*;
import java.math.*;

class Solution {
    public int solution(int[] numbers, int n) {
        int temp = 0;
        for(int i=0; i<numbers.length;i++){
            temp += numbers[i];
            if(temp>n){
                return temp;
            }
        }
        return temp;
    }
}