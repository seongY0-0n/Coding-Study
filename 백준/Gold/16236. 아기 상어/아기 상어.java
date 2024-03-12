import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int dx[] = { 0, -1, 1, 0 };
    static int dy[] = { -1, 0, 0, 1 };
    static int N, size, eat, fish[], map[][], sharkPos[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        size = 2;
        eat = 0;
        sharkPos = new int[2];
        int ans = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkPos[0] = i;
                    sharkPos[1] = j;
                    map[i][j] = 0;
                }
            }
        }
        while (true) {
            Queue<int[]> q = new LinkedList<>();
            int dist[][] = new int[N][N];
            dist[sharkPos[0]][sharkPos[1]] = 1;
            boolean isSuccess = false;
            q.add(sharkPos);
            int temp = Integer.MAX_VALUE;
            int y = Integer.MAX_VALUE;
            int x = Integer.MAX_VALUE;
            while (!q.isEmpty()) {
                int cur[] = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur[1] + dx[i];
                    int ny = cur[0] + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[ny][nx] <= size && dist[ny][nx] == 0) {
                        dist[ny][nx] = dist[cur[0]][cur[1]] + 1;
                        q.add(new int[] { ny, nx });
                        if (map[ny][nx] != 0 && map[ny][nx] < size) {
                            isSuccess = true;
                            if (dist[ny][nx] < temp) {
                                temp = dist[ny][nx];
                                y = ny;
                                x = nx;
                            }
                            if (temp == dist[ny][nx]) {
                                if(y>ny){
                                    y = ny;
                                    x = nx;
                                }
                                if(y==ny && x >nx){
                                    x = nx;
                                }
                            }
                        }
                    }
                }
            }
            if (!isSuccess) {
                System.out.println(ans);
                break;
            }else{
                map[y][x] = 0;
                sharkPos[0] = y;
                sharkPos[1] = x;
                ans += dist[y][x] - 1;
                eat++;
            }
            if (eat == size) {
                size++;
                eat = 0;
            }
        }
    }
}
