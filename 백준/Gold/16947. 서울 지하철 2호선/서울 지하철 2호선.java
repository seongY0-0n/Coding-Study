import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static ArrayList<Integer>[] train;
  static boolean[] circle;
  static int[] count;
  static int[] depth;
  static int n;

  static void bfs() {
    Queue<Integer> q = new LinkedList<Integer>();
    boolean visited[] = new boolean[n + 1];

    for (int i = 1; i <= n; i++) {
      if (circle[i] && train[i].size() > 2) {
        q.add(i);
        visited[i] = true;
      }
    }

    while (!q.isEmpty()) {
      int node = q.poll();

      for (int next : train[node]) {
        if (!visited[next] && !circle[next]) {
          q.add(next);
          visited[next] = true;
          count[next] = count[node] + 1;
        }
      }
    }
  }

  static int findCycle(int node, int d) {
    for (int next : train[node]) {
      if (depth[next] == 0) {
        depth[next] = d + 1;
        int ret = findCycle(next, d + 1);
        if (ret != 0) {
          circle[next] = true;
          return ret - 1;
        }

      } else if (depth[next] != d - 1) {
        circle[next] = true;
        return d - depth[next];
      }
    }
    return 0;
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    train = new ArrayList[n + 1];
    depth = new int[n + 1];
    circle = new boolean[n + 1];
    count = new int[n + 1];

    for (int i = 1; i <= n; i++)
      train[i] = new ArrayList<>();

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      train[u].add(v);
      train[v].add(u);

    }

    depth[1] = 1;
    findCycle(1, 1);

    StringBuilder sb = new StringBuilder();

    bfs();

    for (int i = 1; i <= n; i++) {
      sb.append(count[i] + " ");
    }
    System.out.println(sb);

  }

}