import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] hw = new int[N][2];
    Queue<int[]> q = new LinkedList<>();
    int ans = 0;

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      hw[i][0] = Integer.parseInt(st.nextToken());
      hw[i][1] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(hw, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0])
          return o2[1] - o1[1];

        return o2[0] - o1[0];
      }
    });

    for (int i = 0; i < N; i++) {
      q.add(hw[i]);
    }

    int day = hw[0][0];
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = day; i > 0; i--) {

      while (!q.isEmpty() && q.peek()[0] == i) {
        pq.add(q.poll()[1]);
      }
      if (!pq.isEmpty())
        ans += pq.poll();
    }

    System.out.println(ans);
  }
}
