import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        char [][] map = new char[num][num];
        firstArray(num, map);
        String empty = sc.nextLine();
        String str = sc.nextLine();
        char[][] finalPath = robotPath(str, map);
        for(int i=0;i<num;i++){
            for (int j=0;j<num;j++){
                System.out.print(finalPath[i][j]);
            }
            System.out.println();
        }
    }

    private static char[][] robotPath(String str, char[][] map) {
        int i=0;
        int j=0;
        int N = map.length;
        for(int l = 0; l< str.length(); l++){
            if(str.charAt(l)=='U'){
                if(i!=0){
                    if(map[i][j]=='.'){
                        map[i][j]='|';
                    }else if(map[i][j] =='-'){
                        map[i][j]='+';
                    }
                    if(map[i -1][j]=='.'){
                        map[i -1][j]='|';
                    }else if(map[i -1][j] =='-'){
                        map[i -1][j]='+';
                    }
                    i--;
                }
            } else if(str.charAt(l)=='D'){
                if(i!=N-1){
                    if(map[i][j]=='.'){
                        map[i][j]='|';
                    }else if(map[i][j] =='-'){
                        map[i][j]='+';
                    }
                    if(map[i+1][j]=='.'){
                        map[i +1][j]='|';
                    }else if(map[i +1][j] =='-'){
                        map[i +1][j]='+';
                    }
                    i++;
                }
            }else if(str.charAt(l)=='L'){
                if(j!=0){
                    if(map[i][j]=='.'){
                        map[i][j]='-';
                    }else if(map[i][j] =='|'){
                        map[i][j]='+';
                    }
                    if(map[i][j -1]=='.'){
                        map[i][j -1]='-';
                    }else if(map[i][j -1] =='|'){
                        map[i][j -1]='+';
                    }
                    j--;
                }
            }else{
                if(j!=N-1){
                    if(map[i][j]=='.'){
                        map[i][j]='-';
                    }else if(map[i][j] =='|'){
                        map[i][j]='+';
                    }
                    if(map[i][j +1]=='.'){
                        map[i][j +1]='-';
                    }else if(map[i][j +1] =='|'){
                        map[i][j +1]='+';
                    }
                    j++;
                }
            }
        }
        return map;
    }

    private static void firstArray(int num, char[][] map) {
        for (int i = 0; i< num; i++){
            for(int j = 0; j< num; j++){
                map[i][j] = '.';
            }
        }
    }


}
