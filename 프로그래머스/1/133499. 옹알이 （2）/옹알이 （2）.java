import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String str : babbling) {
            if(str.contains("ayaaya") ||
              str.contains("yeye") ||
              str.contains("woowoo") ||
              str.contains("mama")) continue;
            int ayaCount = str.length() - str.replace("aya", "").length();
            int yeCount = str.length() - str.replace("ye", "").length();
            int wooCount = str.length() - str.replace("woo", "").length();
            int maCount = str.length() - str.replace("ma", "").length();
            if(ayaCount+yeCount+wooCount+maCount == str.length()) {
                answer++;
            }
        }
        return answer;
    }
}