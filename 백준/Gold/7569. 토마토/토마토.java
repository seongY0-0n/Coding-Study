import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int dx[] = { 1, -1, 0, 0 };
  static int dy[] = { 0, 0, 1, -1 };
  static int dz[] = { 1, -1 };
  static int M, N, H, tomato[][][], temp, ans;
  static Queue<int[]> q = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    tomato = new int[H][N][M];
    int 안익은토마토 = 0;
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < N; j++) {
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < M; k++) {
          tomato[i][j][k] = Integer.parseInt(st.nextToken());
          if (tomato[i][j][k] == 0) {
            안익은토마토++;
          } else if (tomato[i][j][k] == 1) {
            q.add(new int[] { i, j, k });
          }
        }
      }
    }

    bfs();
    if (temp == 안익은토마토) {
      System.out.println(ans - 1);
    } else {
      System.out.println(-1);
    }
  }

  public static void bfs() {
    while (!q.isEmpty()) {
      int[] t = q.poll();
      int h = t[0];
      int n = t[1];
      int m = t[2];
      ans = tomato[h][n][m];
      for (int i = 0; i < 4; i++) {
        int ny = n + dy[i];
        int nx = m + dx[i];
        if (ny >= 0 && ny < N && nx >= 0 && nx < M && (tomato[h][ny][nx] == 0)) {
          tomato[h][ny][nx] = tomato[h][n][m] + 1;
          q.add(new int[] { h, ny, nx });
          temp++;
        }
      }

      for (int i = 0; i < 2; i++) {
        int nz = h + dz[i];
        if (nz >= 0 && nz < H && (tomato[nz][n][m] == 0)) {
          tomato[nz][n][m] = tomato[h][n][m] + 1;
          q.add(new int[] { nz, n, m });
          temp++;
        }
      }
    }
  }
}
