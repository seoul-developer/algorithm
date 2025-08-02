import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// # 1202 보석 도둑

		// 보석 N개, 각 무게 M[i], 가격 V[i]
		// 가방 K개, 각 가방에 담을 수 있는 최대 무게는 C[i]
		// 한 가방에는 1개의 보석만 담을 수 있음
		// 훔칠 수 있는 보석의 최대 가격

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 30만
		int K = Integer.parseInt(st.nextToken()); // 30만

//		System.out.println(N);
//		System.out.println(K);

		Gem[] gems = new Gem[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			gems[i] = new Gem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int[] bags = new int[K];
		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine()); // 가방 무게
//			System.out.println(bags[i]);
		}

		// 보석, 가방을 무게로 정렬
		Arrays.sort(gems, (a, b) -> (a.weight - b.weight)); // O(NlogN)
		Arrays.sort(bags); // O(KlogK)

		long total = 0;
		int gemIndex = 0;

		PriorityQueue<Integer> gemValues = new PriorityQueue<>(Collections.reverseOrder()); // 보석의 가치를 저장

		for (int bagIndex = 0; bagIndex < bags.length; bagIndex++) {
			int bagCapa = bags[bagIndex];
//			System.out.println("bag: " + bagCapa);

			while (gemIndex < gems.length && gems[gemIndex].weight <= bagCapa) { // O(NlogN)
				int gemValue = gems[gemIndex].value;
				gemValues.offer(gemValue); // O(logN) - PQ (heapify)
//				System.out.println("gem val: " + gemValue);
				gemIndex++;
			}

			if (!gemValues.isEmpty()) {
				total += gemValues.poll(); // O(logN) - PQ (heapify)
			}
		}

		System.out.println(total);
	}
}

class Gem {
	int weight = 0;
	int value = 0;

	public Gem(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
}
