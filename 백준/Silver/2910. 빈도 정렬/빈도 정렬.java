import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //Scanner sc = new Scanner(System.in);
        String[] firstLine = br.readLine().split(" ");
        int N =Integer.parseInt(firstLine[0]);
        int C =Integer.parseInt(firstLine[1]);

        Message[] messages = new Message[N];
        String[] numberList = br.readLine().split(" ");
        for (int i=0;i<N;i++){
            int number = Integer.parseInt(numberList[i]);
            messages[i] = new Message(number,i);
        }
        Arrays.sort(messages, new Comparator<Message>() {
            @Override
            public int compare(Message o1, Message o2) {
                return o1.num-o2.num;
            }
        });
        Frequency[] frequencies = new Frequency[N];
        int index=0;
        frequencies[index] = new Frequency(messages[0].num,1,messages[0].idx);
        for (int i=1;i<N;i++){
            if(messages[i].num==messages[i-1].num){
                frequencies[index].count+=1;
            }else{
                frequencies[++index] = new Frequency(messages[i].num,1,messages[i].idx);
            }
        }
        Arrays.sort(frequencies, Comparator.nullsLast(new Comparator<Frequency>() {
            @Override
            public int compare(Frequency o1, Frequency o2) {
                if(o2.count==o1.count){
                    return o1.firstIndex-o2.firstIndex;
                }
                return o2.count-o1.count;
            }
        }));


        for(int i=0;i<N;i++){
            if(frequencies[i]!=null){
                int count = frequencies[i].count;
                for(int j=0;j<count;j++){
                    System.out.print(frequencies[i].num+" ");
                }
            }
        }
        System.out.println();
    }
}
class Frequency{
    int num;
    int count;
    int firstIndex;



    public Frequency(int num, int count, int firstIndex) {
        this.num = num;
        this.count = count;
        this.firstIndex = firstIndex;
    }
}
class Message{
    int num;
    int idx;

    public Message(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }
}
