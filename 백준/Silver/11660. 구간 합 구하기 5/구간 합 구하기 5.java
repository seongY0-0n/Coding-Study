
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] num = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (j == 1) {
                    temp += num[i - 1][N];
                    num[i][j - 1] = num[i-1][N];
                } else {
                    temp += num[i][j - 1];
                }
                num[i][j] = temp;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int ans = 0;
            for (int j = x1; j <= x2; j++) {
                ans += num[j][y2] - num[j][y1 - 1];
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
