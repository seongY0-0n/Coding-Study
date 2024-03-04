import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int dx[] = { 1, 0, -1, 0 };
        int dy[] = { 0, 1, 0, -1 };
        int room[][] = new int[R][C];
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1) {
                    c2 = i;
                }
            }
        }
        c1 = c2 - 1;
        int time = 0;
        while (time != T) {
            time++;
            int newRoom[][] = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (room[i][j] != -1 && room[i][j] != 0) {
                        int temp = 0;
                        for (int k = 0; k < 4; k++) {
                            int ni = i + dx[k];
                            int nj = j + dy[k];
                            if (ni >= 0 && ni < R && nj >= 0 && nj < C && room[ni][nj] != -1) {
                                temp++;
                                newRoom[ni][nj] += room[i][j] / 5;
                            }
                        }
                        newRoom[i][j] += room[i][j] - (room[i][j] / 5) * temp;
                    }
                }
            }
            // 위 공기청정기 작동
            for (int i = c1 - 1; i > 0; i--) {
                newRoom[i][0] = newRoom[i - 1][0];
            }
            for (int i = 0; i < C - 1; i++) {
                newRoom[0][i] = newRoom[0][i + 1];
            }
            for (int i = 0; i < c1; i++) {
                newRoom[i][C - 1] = newRoom[i + 1][C - 1];
            }
            for (int i = C - 1; i > 0; i--) {
                newRoom[c1][i] = newRoom[c1][i - 1];
            }
            
            // 아래 공기청정기 작동
            for (int i = c2 + 1; i < R - 1; i++) {
                newRoom[i][0] = newRoom[i + 1][0];
            }
            for (int i = 0; i < C - 1; i++) {
                newRoom[R - 1][i] = newRoom[R - 1][i + 1];
            }
            for (int i = R - 1; i > c2; i--) {
                newRoom[i][C - 1] = newRoom[i - 1][C - 1];
            }
            for (int i = C - 1; i > 0; i--) {
                newRoom[c2][i] = newRoom[c2][i - 1];
            }

            room = newRoom;
            room[c1][0] = -1;
            room[c2][0] = -1;
        }
        int ans = 2;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans += room[i][j];
            }
        }
        System.out.println(ans);
    }
}