import java.util.HashSet;
import java.util.Set;

class Solution {
    int[] answer = new int[2];
    int[][] arr1;
    public int[] solution(int[][] arr) {
        arr1 = arr;
        func(0, arr.length, 0, arr.length);
        return answer;
    }

    public void func(int rowStart, int rowEnd, int columnStart, int columnEnd) {
        Set<Integer> set = new HashSet<>();
        for(int i = rowStart; i < rowEnd; i++) {
            for(int j = columnStart; j < columnEnd; j++) {
                set.add(arr1[i][j]);
                if(set.size() == 2) {
                    if(rowStart + 2 == rowEnd) {
                        answer[arr1[rowStart][columnStart]] ++;
                        answer[arr1[rowStart][columnStart+1]]++;
                        answer[arr1[rowStart+1][columnStart]]++;
                        answer[arr1[rowStart+1][columnStart+1]]++;
                        return;
                    }
                    func(rowStart, (rowStart + rowEnd)/2, columnStart, (columnStart + columnEnd)/2);
                    func(rowStart, (rowStart + rowEnd)/2, (columnStart + columnEnd)/2, columnEnd);
                    func((rowStart + rowEnd)/2, rowEnd, columnStart, (columnStart + columnEnd)/2);
                    func((rowStart + rowEnd)/2, rowEnd, (columnStart + columnEnd)/2, columnEnd);
                    return;
                }
            }
        }
        if(set.contains(1)) answer[1]++;
        if(set.contains(0)) answer[0]++;
    }
}