
import java.io.*;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //Scanner sc = new Scanner(System.in);
        List<Character> editor= new LinkedList<>();
        String firstWord = br.readLine();
                //sc.nextLine();
        int cursor = firstWord.length();
        for(char alp:firstWord.toCharArray())
            editor.add(alp);

        int N = Integer.parseInt(br.readLine());
        //sc.nextInt();
        //String empty = sc.nextLine();
        ListIterator<Character> it = editor.listIterator(editor.size());

        for(int i=0; i<N;i++){
            String line = br.readLine();
            if(line.charAt(0)=='P'){
                //editor.add(cursor++,line.charAt(2));
                it.add(line.charAt(2));
            }else if(line.charAt(0)=='L'){
                //if(cursor!=0) cursor--;
                if(it.hasPrevious()) it.previous();
            }else if(line.charAt(0)=='D'){
                //if(cursor!=editor.size()) cursor++;
                if(it.hasNext()) it.next();
            }else{
                //if(cursor>0) editor.remove(--cursor);
                if(it.hasPrevious()){
                    it.previous();
                    it.remove();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char element : editor)
            sb.append(element);
        bw.write(sb+"\n");
        bw.flush();

    }
}
