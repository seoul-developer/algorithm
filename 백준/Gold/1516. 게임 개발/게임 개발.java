import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] roots;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine()); // 500

		Map<Integer, Building> buildingMap = new HashMap<>();

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());

			boolean[] beforeBuilding = new boolean[N + 1];
			int indegree = 0;
			while (true) {
				int v = Integer.parseInt(st.nextToken());
				if (v == -1) {
					break;
				}

				beforeBuilding[v] = true;
				indegree++;
			}

			buildingMap.put(i, new Building(i, time, indegree, beforeBuilding));
		}

//		for (Building building : buildingMap.values()) {
//			System.out.printf("time: %d, indegree :%s%n", building.time, building.indegree);
//			for (int i = 1; i < building.beforeBuilding.length; i++) {
//				System.out.println(building.beforeBuilding[i]);
//			}
//		}

		ArrayDeque<Building> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			Building building = buildingMap.get(i);
			if (building.indegree == 0) {
				queue.offer(building);
			}
		}

		int[] res = new int[N + 1];
		while (!queue.isEmpty()) {
			Building curr = queue.poll();
			res[curr.index] += curr.time;
//			System.out.printf("fixed! curr: %d, res: %d, indegree: %d%n", curr.index, res[curr.index], curr.indegree);

			// update other buildings containing curr as a before building
			for (int i = 1; i <= N; i++) {
				Building building = buildingMap.get(i);
				if (building.beforeBuilding[curr.index] == true) {

					building.beforeBuilding[curr.indegree] = false;
					building.indegree--;
					res[building.index] = Math.max(res[curr.index], res[building.index]);

//					System.out.printf("curr: %d, building: %d, res: %d, indegree: %d%n", curr.index, building.index,
//							res[building.index], building.indegree);
					if (building.indegree == 0) {
						queue.offer(building);
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(res[i]);
		}
	}
}

class Building {
	int index;
	int time;
	int indegree;
	boolean[] beforeBuilding;

	public Building(int index, int time, int indegree, boolean[] beforeBuilding) {
		this.index = index;
		this.time = time;
		this.indegree = indegree;
		this.beforeBuilding = beforeBuilding;
	}

}