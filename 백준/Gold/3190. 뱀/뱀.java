import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int map[][] = new int[N][N];
        int d[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y - 1][x - 1] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        int ans = 0;
        map[0][0] = 2;
        int now_y = 0;
        int now_x = 0;
        int now_d = 0;
        int tail_y = 0;
        int tail_x = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { tail_y, tail_x });
        int direction[][] = new int[L][2];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            direction[i][0] = sec;
            direction[i][1] = dir;
        }
        int index = 0;
        int sec = 0, dir = 0;
        while (true) {
            if (index < L) {
                sec = direction[index][0];
                dir = direction[index][1];
            }
            ans++;
            int next_y = now_y + d[now_d][0];
            int next_x = now_x + d[now_d][1];

            if (next_y >= 0 && next_y < N && next_x >= 0 && next_x < N && map[next_y][next_x] != 2) {
                if (map[next_y][next_x] == 0) {
                    int t[] = q.poll();
                    map[t[0]][t[1]] = 0;
                }
                q.add(new int[] { next_y, next_x });
                map[next_y][next_x] = 2;
                now_y = next_y;
                now_x = next_x;
            } else {
                System.out.println(ans);
                break;
            }
            if (ans == sec) {
                if (dir == 'D') {
                    now_d = (now_d + 1) % 4;
                } else {
                    now_d = (now_d + 3) % 4;
                }
                index++;
            }
        }

    }
}
