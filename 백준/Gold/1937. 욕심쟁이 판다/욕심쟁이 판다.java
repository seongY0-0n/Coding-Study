import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, 대나무숲[][], dp[][];
    static int di[] = { 1, 0, -1, 0 };
    static int dj[] = { 0, 1, 0, -1 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        대나무숲 = new int[n][n];
        dp = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                대나무숲[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        System.out.println(ans);
    }

    public static int dfs(int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        dp[i][j] = 1;

        for (int k = 0; k < 4; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];
            if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                if (대나무숲[ni][nj] > 대나무숲[i][j]) {
                    dp[i][j] = Math.max(dp[i][j], dfs(ni, nj) + 1);
                }
            }
        }
        return dp[i][j];
    }
}
