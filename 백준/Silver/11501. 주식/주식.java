
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] 주가 = new int[n];
            long ans = 0;

            for (int i = 0; i < n; i++) {
                주가[i] = Integer.parseInt(st.nextToken());
            }
            int max = 주가[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                if (주가[i] < max) {
                    ans += max - 주가[i];
                } else {
                    max = 주가[i];
                }
            }
            System.out.println(ans);
        }
    }
}
