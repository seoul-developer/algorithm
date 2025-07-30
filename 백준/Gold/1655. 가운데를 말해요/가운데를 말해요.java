import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// #1655
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 중앙값보다 작은 값
	static PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 중앙값보다 큰 값

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			int val = Integer.parseInt(br.readLine());

			if (maxHeap.isEmpty() || val <= maxHeap.peek()) {
				maxHeap.offer(val);
			} else {
				minHeap.offer(val);
			}

			// 크기 맞추기
			if (maxHeap.size() < minHeap.size()) {
				maxHeap.offer(minHeap.poll());
			} else if (maxHeap.size() > minHeap.size() + 1) {
				minHeap.offer(maxHeap.poll());
			}

			System.out.println(maxHeap.peek());
		}
	}
}
