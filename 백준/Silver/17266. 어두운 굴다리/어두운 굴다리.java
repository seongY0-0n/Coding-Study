import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int lights[] = new int[m];
        int ans;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }
        if (lights[0] > n - lights[m - 1]) {
            ans = lights[0];
        } else {
            ans = n - lights[m - 1];
        }

        for (int i = 0; i < m - 1; i++) {
            if (ans < (lights[i + 1] - lights[i] + 1) / 2) {
                ans = (lights[i + 1] - lights[i] + 1) / 2;
            }
        }
        System.out.println(ans);
    }
}
