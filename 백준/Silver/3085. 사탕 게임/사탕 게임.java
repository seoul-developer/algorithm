import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String empty = sc.nextLine();
        char[][] map = new char[num][num];
        for(int i=0;i<num;i++){
            String str= sc.nextLine();
            for(int j=0;j<num;j++){
                map[i][j]=str.charAt(j);
            }
        }
        int maxCount = 0;

        for (int i=0;i<num;i++){
            for (int j=0;j<num-1;j++){
                swapCandy(map,i,j,i,j+1);
                int rw = findMaxRow(map);
                int cl = findMaxColumn(map);
                maxCount = Math.max(Math.max(rw,cl),maxCount);
                swapCandy(map,i,j,i,j+1);
            }
        }
        for(int i=0;i<num-1;i++){
            for(int j=0;j<num;j++){
                swapCandy(map,i,j,i+1,j);
                int rw = findMaxRow(map);
                int cl = findMaxColumn(map);
                maxCount = Math.max(Math.max(rw,cl),maxCount);
                swapCandy(map,i,j,i+1,j);
            }
        }
        System.out.println(maxCount);
    }

    public static void swapCandy(char[][] map, int r1, int c1, int r2, int c2){
        char tmp = map[r1][c1];
        map[r1][c1]=map[r2][c2];
        map[r2][c2]=tmp;
    }
    public static int findMaxRow(char[][] map){
        int maxRow = 0;
        int N = map.length;
        for(int i=0;i<N;i++){
            int len =1;
            for(int j=0;j<N-1;j++){
                if(map[i][j]==map[i][j+1]){
                    len++;
                }else{
                    maxRow = Math.max(maxRow,len);
                    len = 1;
                }
            }
            maxRow = Math.max(maxRow,len);
        }
        return maxRow;
    }
    public static int findMaxColumn(char[][] map){
        int maxColumn = 0;
        int N = map.length;
        for(int i=0;i<N;i++){
            int len =1;
            for(int j=0;j<N-1;j++){
                if(map[j][i]==map[j+1][i]){
                    len++;
                }else{
                    maxColumn = Math.max(maxColumn,len);
                    len = 1;
                }
            }
            maxColumn = Math.max(maxColumn,len);
        }
        return maxColumn;
    }

}
