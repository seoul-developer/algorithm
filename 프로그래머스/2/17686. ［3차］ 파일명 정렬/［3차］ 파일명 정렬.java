import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public String[] solution(String[] files) {
        List<FileName> list = new ArrayList<>();
        for (String file : files) {
            list.add(new FileName(file));
        }
        Collections.sort(list, new Comparator<FileName>() {
            @Override
            public int compare(final FileName o1, final FileName o2) {
                final int headResult = o1.head.toLowerCase().compareTo(o2.head.toLowerCase());
                if (headResult != 0) {
                    return headResult;
                }
                final int o1Number = Integer.parseInt(o1.number);
                final int o2Number = Integer.parseInt(o2.number);
                if (o1Number == o2Number) {
                    return 0;
                } else if (o1Number < o2Number) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).toFullName();
        }
        return answer;
    }


    class FileName {

        String head;
        String number = "";
        String tail = "";

        public FileName(final String fullName) {
            boolean findHead = false;
            int numberStartIndex = -1;
            for (int i = 0; i < fullName.length(); i++) {
                final char c = fullName.charAt(i);
                if (!findHead && Character.isDigit(c)) {
                    this.head = fullName.substring(0, i);
                    findHead = true;
                    numberStartIndex = i;
                }
                if (findHead && (!Character.isDigit(c) || i == numberStartIndex + 5)) {
                    this.number = fullName.substring(numberStartIndex, i);
                    this.tail = fullName.substring(i);
                    break;
                }
            }
            if(!findHead) {
                this.head = fullName;
            }
            if(this.number.equals("")) { //파일명이 숫자로 끝난 경우
                this.number = fullName.substring(numberStartIndex);
            }
        }

        public String toFullName() {
            if(tail.equals("")){
                return head + number;
            }
            return head + number + tail;
        }
    }
}