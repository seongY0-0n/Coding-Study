import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ac_15684
 */
public class Main {
  static int[][] sadari;
  static int N, M, H;
  static boolean isFinish;
  static int ans;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    sadari = new int[H + 1][N + 1];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int x, y;
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());

      // sadari 배열의 값을 더하면 이동한 사다리가 몇인지 바로 알 수 있게 오른쪽으로 갈 사다리는 +1, 왼쪽으로 갈 사다리는 -1
      sadari[x][y] = 1;
      sadari[x][y + 1] = -1;
    }

    // 사다리는 3개까지 놓아보고 안되면 -1출력
    for (int i = 0; i <= 3; i++) {
      ans = i;
      dfs(1, 0);
      if (isFinish)
        break;
    }
    System.out.println(isFinish ? ans : -1);
  }

  public static void dfs(int depth, int select) {
    if (ans == select) {
      if (check())
        isFinish = true;
      return;
    }

    for (int i = depth; i <= H; i++) {
      for (int j = 1; j < N; j++) {
        if (sadari[i][j] == 0 && sadari[i][j + 1] == 0) {
          sadari[i][j] = 1;
          sadari[i][j + 1] = -1;
          dfs(i, select + 1);
          sadari[i][j] = sadari[i][j + 1] = 0;
        }
      }
    }
  }

  public static boolean check() {
    for (int i = 1; i <= N; i++) {
      int depth = 1;
      int cur = i;
      for (int j = 0; j < H; j++) {
        cur += sadari[depth][cur];
        depth++;
      }

      if (cur != i)
        return false;
    }
    return true;
  }
}