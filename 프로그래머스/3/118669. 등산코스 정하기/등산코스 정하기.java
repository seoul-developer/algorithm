import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    
    static List<ArrayList<Node>> graph = new ArrayList<>();
    static Set<Integer> gateSet = new HashSet<>();
    static Set<Integer> summitSet = new HashSet<>();
    static int[] intensity;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] path : paths) {
            graph.get(path[0]).add(new Node(path[1], path[2]));
            graph.get(path[1]).add(new Node(path[0], path[2]));
        }
        for (int gate : gates) {
            gateSet.add(gate);
        }
        for (int summit : summits) {
            summitSet.add(summit);
        }

        intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);

        for (int gate : gates) {
            func(gate);
        }

        int resultSummit = Integer.MAX_VALUE;
        int resultIntensity = Integer.MAX_VALUE;
        for (int summit : summits) {
            if(resultIntensity > intensity[summit] || (resultIntensity == intensity[summit] && resultSummit > summit)) {
                resultIntensity = intensity[summit];
                resultSummit = summit;
            }
        }

        return new int[]{resultSummit, resultIntensity};
    }

    public void func( int gate) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(gate, 0));

        while (!q.isEmpty()) {
            final Node currentNode = q.poll();
            final int currentNumber = currentNode.number;
            if (summitSet.contains(currentNumber)) {
                continue;
            }

            for (Node next : graph.get(currentNumber)) {
                final int newIntensity = Math.max(currentNode.weight, next.weight);
                if (!gateSet.contains(next.number) && newIntensity < intensity[next.number]) {
                    q.offer(new Node(next.number, newIntensity));
                    intensity[next.number] = newIntensity;
                }
            }
        }
    }

    class Node {

        int number;
        int weight;

        public Node(final int number, final int weight) {
            this.number = number;
            this.weight = weight;
        }
    }
}
