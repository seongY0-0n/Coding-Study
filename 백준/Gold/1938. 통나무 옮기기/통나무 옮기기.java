import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {
	static class Train {
		int train1[] = new int[2];
		int train2[] = new int[2];
		int train3[] = new int[2];
		int count;
		boolean isSero = false;

		public Train(int[] train1, int[] train2, int[] train3, boolean isSero, int count) {
			this.train1 = train1;
			this.train2 = train2;
			this.train3 = train3;
			this.isSero = isSero;
			this.count = count;
		}

	}

	static Train trainB, trainE;
	static char map[][];
	static boolean isVisitedSero[][], isVisitedGaro[][];
	static int n, ans;
	static Queue<Train> q = new ArrayDeque<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ans = Integer.MAX_VALUE;
		map = new char[n][n];
		isVisitedSero = new boolean[n][n];
		isVisitedGaro = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		List<int[]> B = new ArrayList<>();
		List<int[]> E = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'B') {
					B.add(new int[] { i, j });
				}
				if (map[i][j] == 'E') {
					E.add(new int[] { i, j });
				}
			}
		}

		int temp[] = B.get(1);
		int temp1[] = E.get(1);
		if (temp[1] - 1 >= 0 && map[temp[0]][temp[1]] == map[temp[0]][temp[1] - 1]) {
			trainB = new Train(B.get(0), B.get(1), B.get(2), false, 0);
		} else {
			trainB = new Train(B.get(0), B.get(1), B.get(2), true, 0);
		}
		if (temp1[1] - 1 >= 0 && map[temp1[0]][temp1[1]] == map[temp1[0]][temp1[1] - 1]) {
			trainE = new Train(E.get(0), E.get(1), E.get(2), false, 0);
		} else {
			trainE = new Train(E.get(0), E.get(1), E.get(2), true, 0);
		}
		if (trainB.isSero) {
			isVisitedSero[trainB.train2[0]][trainB.train2[1]] = true;
		} else {
			isVisitedGaro[trainB.train2[0]][trainB.train2[1]] = true;
		}
		q.add(trainB);
		bfs();
		if (ans == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(ans);
		}

	}

	public static void bfs() {
		while (!q.isEmpty()) {
			Train T = q.poll();

			if (T.train2[0] == trainE.train2[0] && T.train2[1] == trainE.train2[1] && T.isSero == trainE.isSero) {
				ans = T.count;
				return;
			}
			U(T);
			R(T);
			D(T);
			TURN(T);
			L(T);
		}
	}

	public static boolean TURN(Train t1) {

		int[] a1 = Arrays.copyOf(t1.train1, 2);
		int[] a2 = Arrays.copyOf(t1.train2, 2);
		int[] a3 = Arrays.copyOf(t1.train3, 2);
		Train t = new Train(a1, a2, a3, t1.isSero, t1.count);
		if (t.isSero) {

			if (t.train1[1] - 1 >= 0 && t.train1[1] + 1 < n
					&& !isVisitedGaro[t.train2[0]][t.train2[1]]) {
				if (map[t.train1[0]][t.train1[1] - 1] != '1'
						&& map[t.train1[0]][t.train1[1] + 1] != '1'
						&& map[t.train2[0]][t.train2[1] - 1] != '1'
						&& map[t.train2[0]][t.train2[1] + 1] != '1'
						&& map[t.train3[0]][t.train3[1] - 1] != '1'
						&& map[t.train3[0]][t.train3[1] + 1] != '1') {
					t.train1[0]++;
					t.train1[1]--;
					t.train3[0]--;
					t.train3[1]++;
					t.isSero = false;
					isVisitedGaro[t.train2[0]][t.train2[1]] = true;
					q.add(new Train(t.train1, t.train2, t.train3, t.isSero, t.count + 1));
					return true;
				}
			}
		} else {
			if (t.train1[0] - 1 >= 0 && t.train1[0] + 1 < n
					&& !isVisitedSero[t.train2[0]][t.train2[1]]) {
				if (map[t.train1[0] - 1][t.train1[1]] != '1'
						&& map[t.train1[0] + 1][t.train1[1]] != '1'
						&& map[t.train2[0] - 1][t.train2[1]] != '1'
						&& map[t.train2[0] + 1][t.train2[1]] != '1'
						&& map[t.train3[0] - 1][t.train3[1]] != '1'
						&& map[t.train3[0] + 1][t.train3[1]] != '1') {
					t.train1[0]--;
					t.train1[1]++;
					t.train3[0]++;
					t.train3[1]--;
					t.isSero = true;
					isVisitedSero[t.train2[0]][t.train2[1]] = true;

					q.add(new Train(t.train1, t.train2, t.train3, t.isSero, t.count + 1));
					return true;
				}
			}
		}

		return false;
	}

	public static boolean R(Train t1) {
		int[] a1 = Arrays.copyOf(t1.train1, 2);
		int[] a2 = Arrays.copyOf(t1.train2, 2);
		int[] a3 = Arrays.copyOf(t1.train3, 2);
		Train t = new Train(a1, a2, a3, t1.isSero, t1.count);
		if (t.train3[1] + 1 < n && map[t.train3[0]][t.train3[1] + 1] != '1'
				&& map[t.train2[0]][t.train2[1] + 1] != '1'
				&& map[t.train1[0]][t.train1[1] + 1] != '1') {

			if (t.isSero) {
				if (!isVisitedSero[t.train2[0]][t.train2[1] + 1]) {
					t.train1[1]++;
					t.train2[1]++;
					t.train3[1]++;
					isVisitedSero[t.train2[0]][t.train2[1]] = true;

					q.add(new Train(t.train1, t.train2, t.train3, t.isSero, t.count + 1));
					return true;
				}
			} else {
				if (!isVisitedGaro[t.train2[0]][t.train2[1] + 1]) {
					t.train1[1]++;
					t.train2[1]++;
					t.train3[1]++;
					isVisitedGaro[t.train2[0]][t.train2[1]] = true;

					q.add(new Train(t.train1, t.train2, t.train3, t.isSero, t.count + 1));
					return true;
				}
			}
		}
		return false;
	}

	public static boolean L(Train t1) {
		int[] a1 = Arrays.copyOf(t1.train1, 2);
		int[] a2 = Arrays.copyOf(t1.train2, 2);
		int[] a3 = Arrays.copyOf(t1.train3, 2);
		Train t = new Train(a1, a2, a3, t1.isSero, t1.count);
		if (t.train1[1] - 1 >= 0 && map[t.train1[0]][t.train1[1] - 1] != '1'
				&& map[t.train2[0]][t.train2[1] - 1] != '1'
				&& map[t.train3[0]][t.train3[1] - 1] != '1') {
			if (t.isSero) {
				if (!isVisitedSero[t.train2[0]][t.train2[1] - 1]) {
					t.train1[1]--;
					t.train2[1]--;
					t.train3[1]--;
					isVisitedSero[t.train2[0]][t.train2[1]] = true;

					q.add(new Train(t.train1, t.train2, t.train3, t.isSero, t.count + 1));
					return true;
				}
			} else {
				if (!isVisitedGaro[t.train2[0]][t.train2[1] - 1]) {
					t.train1[1]--;
					t.train2[1]--;
					t.train3[1]--;
					isVisitedGaro[t.train2[0]][t.train2[1]] = true;

					q.add(new Train(t.train1, t.train2, t.train3, t.isSero, t.count + 1));
					return true;
				}
			}
		}
		return false;
	}

	public static boolean U(Train t1) {
		int[] a1 = Arrays.copyOf(t1.train1, 2);
		int[] a2 = Arrays.copyOf(t1.train2, 2);
		int[] a3 = Arrays.copyOf(t1.train3, 2);
		Train t = new Train(a1, a2, a3, t1.isSero, t1.count);
		if (t.train1[0] - 1 >= 0 && map[t.train1[0] - 1][t.train1[1]] != '1'
				&& map[t.train2[0] - 1][t.train2[1]] != '1'
				&& map[t.train3[0] - 1][t.train3[1]] != '1') {
			if (t.isSero) {
				if (!isVisitedSero[t.train2[0] - 1][t.train2[1]]) {
					t.train1[0]--;
					t.train2[0]--;
					t.train3[0]--;
					isVisitedSero[t.train2[0]][t.train2[1]] = true;

					q.add(new Train(t.train1, t.train2, t.train3, t.isSero, t.count + 1));
					return true;
				}
			} else {
				if (!isVisitedGaro[t.train2[0] - 1][t.train2[1]]) {
					t.train1[0]--;
					t.train2[0]--;
					t.train3[0]--;
					isVisitedGaro[t.train2[0]][t.train2[1]] = true;

					q.add(new Train(t.train1, t.train2, t.train3, t.isSero, t.count + 1));
					return true;
				}
			}

		}
		return false;
	}

	public static boolean D(Train t1) {
		int[] a1 = Arrays.copyOf(t1.train1, 2);
		int[] a2 = Arrays.copyOf(t1.train2, 2);
		int[] a3 = Arrays.copyOf(t1.train3, 2);
		Train t = new Train(a1, a2, a3, t1.isSero, t1.count);
		if (t.train3[0] + 1 < n && map[t.train1[0] + 1][t.train1[1]] != '1'
				&& map[t.train2[0] + 1][t.train2[1]] != '1'
				&& map[t.train3[0] + 1][t.train3[1]] != '1') {
			if (t.isSero) {
				if (!isVisitedSero[t.train2[0] + 1][t.train2[1]]) {
					t.train1[0]++;
					t.train2[0]++;
					t.train3[0]++;
					isVisitedSero[t.train2[0]][t.train2[1]] = true;

					q.add(new Train(t.train1, t.train2, t.train3, t.isSero, t.count + 1));
					return true;
				}
			} else {
				if (!isVisitedGaro[t.train2[0] + 1][t.train2[1]]) {
					t.train1[0]++;
					t.train2[0]++;
					t.train3[0]++;
					isVisitedGaro[t.train2[0]][t.train2[1]] = true;

					q.add(new Train(t.train1, t.train2, t.train3, t.isSero, t.count + 1));
					return true;
				}
			}

		}
		return false;
	}
}
