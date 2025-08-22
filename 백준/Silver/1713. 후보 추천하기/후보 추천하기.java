import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine()); // 사진틀 개수 (20)
		int recCnt = Integer.parseInt(br.readLine()); // 추천 횟수 (1000)
		int[] recIdx = new int[recCnt];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < recCnt; i++) {
			recIdx[i] = Integer.parseInt(st.nextToken());
		}

		// 아래를 M회 반복 O(MNlogN)
		// 1. 이미 프레임 안에 있는지 확인하고 있으면 횟수만 추가 O(N)
		// 2. 프레임 안에 없는 경우에는 추가해야 함
		// 2-1. 프레임이 꽉 찼다면 기존 것들을 정렬한 후 기준에 맞는 프레임을 선택해서 버림 O(NlogN)
		// 2-2. 새로운 것을 프레임에 추가

		List<Candidate> frames = new ArrayList<>();
		loop: for (int i = 0; i < recCnt; i++) { // M회 반복
			int curr = recIdx[i];
//			System.out.println("처리중: " + curr);

			for (Candidate c : frames) {
				if (c.idx == curr) {
//					System.out.println("중복 발견!");
					// 1. 이미 프레임 안에 있는지 확인하고 있으면 횟수만 추가 O(N)
					c.cnt++;
					continue loop;
				}
			}

			// 2. 프레임 안에 없는 경우에는 추가해야 함
			int currSize = frames.size();
			if (currSize == N) {
//				System.out.println("가득 참!");

				// 2-1. 프레임이 꽉 찼다면 기존 것들을 정렬한 후 기준에 맞는 프레임을 선택해서 버림 O(NlogN)
				Collections.sort(frames, (a, b) -> {
					if (a.cnt == b.cnt) {
						return a.time - b.time;
					}
					return a.cnt - b.cnt;
				});

//				System.out.println("removing: " + frames.get(0));
				frames.remove(0);
			}
			// 2-2. 새로운 것을 프레임에 추가
			frames.add(new Candidate(curr, 1, i));
		}

		// 로깅
//		for (Candidate c : frames) {
//			System.out.printf("idx: %d, cnt: %d, time: %d %n", c.idx, c.cnt, c.time);
//		}

		System.out.println(frames.stream().map(it -> it.idx).sorted().map(it -> String.valueOf(it))
				.collect(Collectors.joining(" ")));

	}
}

class Candidate {
	int idx;
	int cnt;
	int time;

	public Candidate(int idx, int cnt, int time) {
		this.idx = idx;
		this.cnt = cnt;
		this.time = time;
	}
}