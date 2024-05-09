import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int move[] = new int[101];
        int ans = 0;
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            move[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> q = new LinkedList();
        q.offer(new int[] { 1, 0 });
        int visited[] = new int[101];
        Arrays.fill(visited, 100000);
        while (!q.isEmpty()) {
            int t[] = q.poll();
            if (t[0] == 100) {
                ans = t[1];
                break;
            }
            for (int i = 1; i <= 6; i++) {
                int nx = t[0] + i;
                if (nx > 100)
                    continue;
                if (visited[nx] < t[1] + 1) {
                    continue;
                }
                if (move[nx] != 0) {
                    nx = move[nx];
                }
                visited[nx] = t[1] + 1;
                q.offer(new int[] { nx, t[1] + 1 });
            }
        }
        System.out.println(ans);
    }
}
