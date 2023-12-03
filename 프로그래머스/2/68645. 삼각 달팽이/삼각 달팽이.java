class Solution {
    int[][] tmp;
    int number;
    int N;
    int MAX;

    public int[] solution(int n) {
        tmp = new int[n][n];
        number = 1;
        N = n;
        MAX = n * (n + 1) / 2;
        func(n, 0, 0);

        int[] answer = new int[MAX];
        int a = 0;
        int b = 0;
        for(int i = 0; i < MAX; i++) {
            answer[i] = tmp[a][b];
            if(b == a) {
                a++;
                b = 0;
            }else{
                b++;
            }
        }

        return answer;
    }

    public void func(int size, int startRow, int startColumn) {
        if(number > MAX){
            return;
        }
        for(int i = startRow; i < startRow + size; i++) {
            tmp[i][startColumn] = number;
            number++;
        }
        for(int i = startColumn + 1; i < startColumn + size; i++) {
            tmp[startRow + size -1][i] = number;
            number++;
        }
        for(int i = 1; i < size - 1; i++) {
            tmp[startRow + size - 1 - i][startColumn + size - 1 - i] = number;
            number++;
        }
        func(size - 3, startRow + 2, startColumn +1);
    }
}