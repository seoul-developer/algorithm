import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        String empty = sc.nextLine();
        boolean[] height = new boolean[h];
        boolean[] width = new boolean[w];

        for (int i=0; i<h;i++){
            String castle = sc.nextLine();
            for (int j= 0; j<w; j++){
                if(castle.charAt(j)=='X'){
                    height[i]=true;
                    width[j]=true;
                }
            }
        }


        int needHeight = 0;
        int needWidth = 0;

        for (boolean b : height) {
            if(!b) needHeight++;
        }

        for (boolean b : width) {
            if(!b) needWidth++;
        }

        if(needHeight>needWidth){
            System.out.println(needHeight);
        }else{
            System.out.println(needWidth);
        }

    }
}
