import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int ans = Integer.MAX_VALUE;
        boolean[][][] visited = new boolean[n][m][2]; // visited 배열에 벽을 부쉈는지의 여부도 저장

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 1}); // x, y, 부순 벽의 수, 거리
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int brokenWalls = current[2];
            int dist = current[3];

            if (x == m - 1 && y == n - 1) {
                ans = dist;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (map[ny][nx] == 1 && brokenWalls == 0 && !visited[ny][nx][1]) { // 벽이 있고 아직 벽을 부수지 않은 경우
                        q.add(new int[]{nx, ny, 1, dist + 1});
                        visited[ny][nx][1] = true;
                    } else if (map[ny][nx] == 0 && !visited[ny][nx][brokenWalls]) { // 벽이 없는 경우
                        q.add(new int[]{nx, ny, brokenWalls, dist + 1});
                        visited[ny][nx][brokenWalls] = true;
                    }
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
