import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int floor[] = new int[k];
        int index = k - 1;
        int ans = 0;
        while (x > 0) {
            floor[index--] = x % 10;
            x /= 10;
        }
        int digit[][] = new int[][] { { 1, 1, 1, 1, 1, 1, 0 }, { 0, 1, 1, 0, 0, 0, 0 }, { 1, 1, 0, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 0, 0, 1 }, { 0, 1, 1, 0, 0, 1, 1 }, { 1, 0, 1, 1, 0, 1, 1 }, { 1, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 1, 1 } };

        for (int i = 1; i <= n; i++) {
            int fake[] = new int[k];
            index = k - 1;
            int num = i;
            while (num > 0) {
                fake[index--] = num % 10;
                num /= 10;
            }
            int count = 0;
            for (int j = 0; j < k; j++) {
                for (int t = 0; t < 7; t++) {
                    if (digit[floor[j]][t] != digit[fake[j]][t]) {
                        count++;
                    }
                }
                if (count > p) {
                    break;
                }
            }
            if (count <= p && count > 0) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
