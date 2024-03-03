import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int robot[] = new int[3];
    int ans = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 3; i++) {
      robot[i] = Integer.parseInt(st.nextToken());
    }
    int room[][] = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        room[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int dx[] = { 1, 0, -1, 0 };
    int dy[] = { 0, 1, 0, -1 };
    int moveBack[][] = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
    int moveFront[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    while (true) {
      int x = robot[1];
      int y = robot[0];
      int d = robot[2];

      // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
      if (room[y][x] == 0) {
        room[y][x]--;
        ans++;
      }
      // 현재 칸의 주변 4칸 중 청소되지 않은 빈칸 확인
      boolean isClean = true;
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && nx < M && ny >= 0 && ny < N && room[ny][nx] == 0) {
          isClean = false;
          break;
        }
      }

      // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
      if (isClean) {
        int nx = x + moveBack[d][1];
        int ny = y + moveBack[d][0];
        if (nx >= 0 && nx < M && ny >= 0 && ny < N && room[ny][nx] < 1) {
          robot[1] = nx;
          robot[0] = ny;
        } else {
          // 종료조건

          break;
        }
      } else // 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 있는경우
      {
        robot[2] = (robot[2] + 3) % 4;
        int nx = x + moveFront[robot[2]][1];
        int ny = y + moveFront[robot[2]][0];
        if (nx >= 0 && nx < M && ny >= 0 && ny < N && room[ny][nx] == 0) {

          robot[1] = nx;
          robot[0] = ny;
        }
      }
    }
    System.out.println(ans);
  }
}
