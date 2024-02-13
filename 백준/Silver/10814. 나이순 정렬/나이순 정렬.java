import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        Member[] members = new Member[num];

        for (int i=0; i<num; i++){
            String[] element = br.readLine().split(" ");
            members[i] = new Member(element[1],Integer.parseInt(element[0]));
        }
        Arrays.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o1.age-o2.age;
            }
        });
        for (int i=0; i<num;i++){
            System.out.println(members[i]);
        }
    }
}
class Member{
    String name;
    int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return  age + " " + name;
    }
}
