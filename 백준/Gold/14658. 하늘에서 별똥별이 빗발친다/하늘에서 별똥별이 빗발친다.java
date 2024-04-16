
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int n, m, l, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[][] stars = new int[k][2];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Integer.parseInt(st.nextToken());
            stars[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                int startX = Math.min(stars[i][0], stars[j][0]);
                int startY = Math.min(stars[i][1], stars[j][1]);
                int temp = 0;
                for (int s[] : stars) {
                    if (s[0] >= startX && s[0] <= startX + l && s[1] >= startY && s[1] <= startY + l) {
                        temp++;
                    }
                }
                ans = Math.max(ans, temp);
            }

        }
        System.out.println(k - ans);

    }

}
