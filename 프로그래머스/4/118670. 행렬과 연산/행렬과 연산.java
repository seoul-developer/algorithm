import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public int[][] solution(int[][] rc, String[] operations) {

        Deque<Integer> leftLine = new ArrayDeque<>();
        Deque<Integer> rightLine = new ArrayDeque<>();
        Deque<Deque<Integer>> centerLines = new ArrayDeque<>();

        for(int i = 0; i < rc.length; i++) {
            leftLine.addLast(rc[i][0]);
            rightLine.addLast(rc[i][rc[0].length -1]);
            Deque<Integer> centerLine = new ArrayDeque<>();
            for(int j = 1; j < rc[0].length -1; j++) {
                centerLine.addLast(rc[i][j]);
            }
            centerLines.addLast(centerLine);
        }

        for (String operation : operations) {
            if(operation.equals("Rotate")) {
                rotate(leftLine, rightLine, centerLines);
            }else{
                shiftRow(leftLine, rightLine, centerLines);
            }
        }

        for(int i = 0; i < rc.length; i++) {
            rc[i][0] = leftLine.removeFirst();
            rc[i][rc[0].length -1] = rightLine.removeFirst();
            final Deque<Integer> centerLine = centerLines.removeFirst();
            for(int j = 1; j < rc[0].length -1; j++) {
                rc[i][j] = centerLine.removeFirst();
            }
        }
        return rc;
    }

    private void shiftRow(final Deque<Integer> leftLine, final Deque<Integer> rightLine,
                          final Deque<Deque<Integer>> centerLines) {
        leftLine.addFirst(leftLine.removeLast());
        rightLine.addFirst(rightLine.removeLast());
        centerLines.addFirst(centerLines.removeLast());
    }

    private void rotate(final Deque<Integer> leftLine, final Deque<Integer> rightLine, final Deque<Deque<Integer>> centerLines) {
        final Deque<Integer> firstLine = centerLines.peekFirst();
        firstLine.addFirst(leftLine.removeFirst());
        rightLine.addFirst(firstLine.removeLast());
        final Deque<Integer> lastLine = centerLines.peekLast();
        lastLine.addLast(rightLine.removeLast());
        leftLine.addLast(lastLine.removeFirst());
    }
}