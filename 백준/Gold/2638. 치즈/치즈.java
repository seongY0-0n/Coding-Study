import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static boolean isAir[][];
  static int dx[] = { 1, -1, 0, 0 };
  static int dy[] = { 0, 0, 1, -1 };
  static int n, m;
  static int[][] 치즈;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    치즈 = new int[n][m];
    int num = 0;
    int time = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        치즈[i][j] = Integer.parseInt(st.nextToken());
        if (치즈[i][j] == 1)
          num++;
      }
    }

    // 공기인지 확인
    while (true) {
      time++;
      isAir = new boolean[n][m];
      isHole(0, 0);
      // 녹을 치즈 확인 후 녹임
      int melt = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (치즈[i][j] == 1) {
            int temp = 0;
            for (int k = 0; k < 4; k++) {
              int nx = dx[k] + i;
              int ny = dy[k] + j;
              if (nx < 0 || nx >= n || ny < 0 || ny >= m || isAir[nx][ny]) {
                temp++;
              }
            }
            if (temp >= 2) {
              치즈[i][j] = 0;
              melt++;
            }
          }
        }
      }
      num -= melt;
      if (num == 0) {
        System.out.println(time);
        break;
      }
    }
  }

  public static void isHole(int x, int y) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] { x, y });
    isAir[x][y] = true;
    while (!q.isEmpty()) {
      int t[] = q.poll();
      for (int i = 0; i < 4; i++) {
        int nx = dx[i] + t[0];
        int ny = dy[i] + t[1];
        if (nx >= 0 && nx < n && ny >= 0 && ny < m && !isAir[nx][ny] && (치즈[nx][ny] == 0)) {
          q.add(new int[] { nx, ny });
          isAir[nx][ny] = true;
        }
      }
    }
  }
}