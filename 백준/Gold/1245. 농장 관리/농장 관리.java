import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int dx[] = { 1, -1, 0, 0, 1, 1, -1, -1 };
  static int dy[] = { 0, 0, 1, -1, 1, -1, 1, -1 };
  static int N, M, ans;
  static boolean isVisited[][];
  static int mountain[][];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    mountain = new int[N][M];
    isVisited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        mountain[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!isVisited[i][j])
          bfs(i, j, mountain[i][j]);
      }
    }
    System.out.println(ans);
  }

  public static void bfs(int x, int y, int height) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] { x, y });
    int temp = 0;
    while (!q.isEmpty()) {
      int[] c = q.poll();
      int cx = c[0];
      int cy = c[1];
      isVisited[cx][cy] = true;

      for (int i = 0; i < 8; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        if (nx >= 0 && nx < N && ny >= 0 && ny < M && (mountain[nx][ny] == height) && !isVisited[nx][ny]) {
          q.add(new int[] { nx, ny });
        }
        if (nx >= 0 && nx < N && ny >= 0 && ny < M && ((mountain[nx][ny] > height))) {
          temp++;
        }
      }
    }

    if (temp == 0) {
      ans++;
    }

  }
}
