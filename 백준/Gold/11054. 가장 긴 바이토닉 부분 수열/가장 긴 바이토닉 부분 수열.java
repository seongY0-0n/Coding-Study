import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int dp1[] = new int[n + 1];
        int dp2[] = new int[n + 1];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        dp1[0] = 0;
        dp2[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if (arr[i] < arr[j]) {
                    dp1[j] = Math.max(dp1[i] + 1, dp1[j]);
                }
                if (arr[n - i + 1] < arr[n - j + 1]) {
                    dp2[j] = Math.max(dp2[i] + 1, dp2[j]);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            ans = Math.max(dp1[i] + dp2[n - i + 1] - 1, ans);
        }
        System.out.println(ans);
    }
}
