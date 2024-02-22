import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static List<int[]> empty, virus;
  static boolean isVisited[], isSelected[][];
  static int[][] room;
  static int N, M;
  static int dx[] = { 1, -1, 0, 0 };
  static int dy[] = { 0, 0, 1, -1 };
  static int ans = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    empty = new ArrayList<>();
    virus = new ArrayList<>();
    room = new int[N][M];
    isSelected = new boolean[N][M];
    int wall = 0;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        room[i][j] = Integer.parseInt(st.nextToken());
        if (room[i][j] == 0)
          empty.add(new int[] { i, j });
        else if (room[i][j] == 2)
          virus.add(new int[] { i, j });
        else
          wall++;

      }
    }
    isVisited = new boolean[empty.size()];
    dfs(0, 0);
    System.out.println(N * M - (ans + virus.size() + wall + 3));
  }

  public static int bfs(int x, int y) {
    Queue<int[]> q = new LinkedList<>();

    q.add(new int[] { x, y });
    isSelected[x][y] = true;

    int temp = 0;

    while (!q.isEmpty()) {
      int t[] = q.poll();
      for (int i = 0; i < 4; i++) {
        int nx = t[0] + dx[i];
        int ny = t[1] + dy[i];
        if (nx >= 0 && nx < N && ny >= 0 && ny < M && room[nx][ny] == 0 && !isSelected[nx][ny]) {
          q.add(new int[] { nx, ny });
          isSelected[nx][ny] = true;
          temp++;
        }
      }
    }
    return temp;
  }

  public static void dfs(int count, int start) {
    if (count == 3) {
      for (int i = 0; i < empty.size(); i++) {
        if (isVisited[i]) {
          room[empty.get(i)[0]][empty.get(i)[1]] = 1;
        }
      }
      isSelected = new boolean[N][M];
      int result = 0;
      for (int t[] : virus) {
        result += bfs(t[0], t[1]);
      }

      ans = Math.min(ans, result);
      for (int i = 0; i < empty.size(); i++) {
        if (isVisited[i]) {
          room[empty.get(i)[0]][empty.get(i)[1]] = 0;
        }
      }
      return;
    }
    for (int i = start; i < empty.size(); i++) {
      isVisited[i] = true;
      dfs(count + 1, i + 1);
      isVisited[i] = false;
    }
  }

}
