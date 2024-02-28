
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pos {
	int x, y;

	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

class Mountain {
	int startX, finishX;

	public Mountain(int startX, int finishX) {
		super();
		this.startX = startX;
		this.finishX = finishX;
	}

}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Pos[] points = new Pos[N];
		int startX = Integer.MAX_VALUE;
		int index = 0;
		List<Mountain> mountains = new ArrayList<Mountain>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			points[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			if (points[i].y < 0 && points[i].x < startX) {
				startX = points[i].x;
				index = i;
			}
		}
		int ans1 = 0;
		int ans2 = 0;
		boolean isOver = false;
		int i = index;
		int finishX = Integer.MIN_VALUE;
		while (true) {
			i = (i + 1) % N;
			if (i == index)
				break;
			int nowY = points[i].y;
			if (!isOver && nowY > 0) {
				startX = points[i].x;
				isOver = true;
			} else if (isOver && nowY <= 0) {
				finishX = points[i].x;
				mountains.add(
						new Mountain(Math.min(startX, finishX), Math.max(startX, finishX)));
				isOver = false;
			}
		}
		Collections.sort(mountains, new Comparator<Mountain>() {

			@Override
			public int compare(Mountain o1, Mountain o2) {
				// TODO Auto-generated method stub
				return o1.startX - o2.startX;
			}
		});

		if (mountains.size() == 1) {
			System.out.println(1 + " " + 1);
		} else {
			int 기준1 = mountains.get(0).finishX;
			ans1++;
			for (int j = 1; j < mountains.size(); j++) {
				if (mountains.get(j).startX > 기준1) {
					ans1++;
					기준1 = mountains.get(j).finishX;
				}
			}
			int 기준2 = mountains.get(0).finishX;
			ans2 = 1;
			for (int j = 1; j < mountains.size(); j++) {
				if (mountains.get(j).startX > 기준2) {
					ans2++;
					기준2 = mountains.get(j).finishX;
				} else {
					기준2 = mountains.get(j).finishX;
				}
			}

			System.out.println(ans1 + " " + ans2);
		}

	}
}
