import java.util.Scanner;

public class Main {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();
        int count;
        for (int i =1;i<=numTest;i++){
            int index = sc.nextInt();
            int[] childLine = new int[20];
            count =0;
            childLine[0]= sc.nextInt();

            for (int j=1;j<20;j++){
                childLine[j]= sc.nextInt();
                for(int k =0; k<j;k++){
                    if(childLine[j]<childLine[k])
                        count++;
                }
            }

            System.out.println(i+" "+count);
        }

    }
}
