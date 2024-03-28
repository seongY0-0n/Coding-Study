import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        Deque<int[]> dq = new ArrayDeque<>();
        char[][] 티떱숲 = new char[r][c];
        int[][] dist = new int [r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                티떱숲[i][j] = str.charAt(j);
                if (티떱숲[i][j] == '*') {
                    dq.addLast(new int[] { i, j });
                }
                if (티떱숲[i][j] == 'S') {
                    dist[i][j] = 0;
                    dq.addFirst(new int[] { i, j });
                }
            }
        }
        int dr[] = { 1, 0, -1, 0 };
        int dc[] = { 0, 1, 0, -1 };

        while (!dq.isEmpty()) {
            int t[] = dq.pollFirst();

            if (티떱숲[t[0]][t[1]] == '*') {
                for (int i = 0; i < 4; i++) {
                    int nr = t[0] + dr[i];
                    int nc = t[1] + dc[i];
                    if (nr >= 0 && nr < r && nc >= 0 && nc < c && 티떱숲[nr][nc] != 'D' && 티떱숲[nr][nc] != 'X'
                            && 티떱숲[nr][nc] != '*') {
                        티떱숲[nr][nc] = '*';
                        dq.addLast(new int[] { nr, nc });
                    }
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    int nr = t[0] + dr[i];
                    int nc = t[1] + dc[i];
                    if (nr >= 0 && nr < r && nc >= 0 && nc < c && (티떱숲[nr][nc] == '.'||티떱숲[nr][nc] == 'D')) {
                        if (티떱숲[nr][nc] == 'D') {
                            System.out.println(dist[t[0]][t[1]]+1);
                            System.exit(0);
                        }
                        티떱숲[nr][nc] = 'S';
                        dist[nr][nc] = dist[t[0]][t[1]]+1;
                        dq.addLast(new int[] { nr, nc });
                    }
                }
            }
        }
        System.out.println("KAKTUS");
    }

}
