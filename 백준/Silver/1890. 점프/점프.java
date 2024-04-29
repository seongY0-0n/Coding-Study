import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int map[][], n;
  static long dp[][];
  static int di[] = { 0, 1 };
  static int dj[] = { 1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    dp = new long[n][n];
    dp[0][0] = 1;
    dfs();
    System.out.println(dp[n - 1][n - 1]);
  }

  public static void dfs() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (map[i][j] == 0)
          break;
        for (int k = 0; k < 2; k++) {
          int ni = i + di[k] * map[i][j];
          int nj = j + dj[k] * map[i][j];
          if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
            dp[ni][nj] += dp[i][j];
          }
        }
      }
    }

  }
}
