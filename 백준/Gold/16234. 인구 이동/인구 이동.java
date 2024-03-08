import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R, peoples[][];
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    static boolean isVisited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int ans = 0;

        peoples = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                peoples[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            boolean next = false;
            isVisited = new boolean[N][N];
            ans++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!isVisited[i][j]) {
                        int num = bfs(i, j);
                        if (num != 1) {
                            next = true;
                        }
                    }
                }
            }

            if (!next) {
                System.out.println(ans - 1);
                break;
            }
        }

    }

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        ArrayList<int[]> connect = new ArrayList<>();
        q.add(new int[] { x, y });
        isVisited[x][y] = true;
        connect.add(new int[] { x, y });
        int total = peoples[x][y];
        int temp = 1;
        while (!q.isEmpty()) {
            int t[] = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = t[0] + dx[i];
                int ny = t[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !isVisited[nx][ny]) {
                    if (Math.abs(peoples[t[0]][t[1]] - peoples[nx][ny]) >= L
                            && Math.abs(peoples[t[0]][t[1]] - peoples[nx][ny]) <= R) {
                        isVisited[nx][ny] = true;
                        connect.add(new int[] { nx, ny });
                        q.add(new int[] { nx, ny });
                        total += peoples[nx][ny];
                        temp++;
                    }
                }
            }
        }
        if (connect.size() == 1) {
            return 1;
        }
        for (int t[] : connect) {
            peoples[t[0]][t[1]] = total / temp;
        }
        return temp;
    }
}
