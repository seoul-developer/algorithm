import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String start = sc.nextLine();
        String end = sc.nextLine();

        String[] startTime = start.split(":");
        String[] endTime = end.split(":");

        int startTotal =0;
        int endTotal =0;

        for(int i =0; i<3;i++){
            startTotal+=Integer.parseInt(startTime[i])*Math.pow(60,2-i);
            endTotal+=Integer.parseInt(endTime[i])*Math.pow(60,2-i);

        }

        if (endTotal<=startTotal)
            endTotal+=24*3600;

        int diff = endTotal- startTotal;
        int hr = diff/3600;
        int min = (diff % 3600)/60;
        int sec = diff %60;

        String ans ="";
        if(hr<10){
            ans+="0"+hr+":";
        }else{
            ans+=hr+":";
        }
        if(min<10){
            ans+="0"+min+":";
        }else{
            ans+=min+":";
        }
        if(sec<10){
            ans+="0"+sec;
        }else{
            ans+=sec;
        }
        System.out.println(ans);
    }
}
