import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int ans = 1;
        while (a < b) {
            if (b % 10 == 1) {
                b /= 10;
                ans++;
            } else if (b % 2 == 0) {
                b /= 2;
                ans++;
            } else {
                System.out.println(-1);
                System.exit(0);

            }
        }
        if (a == b) {
            System.out.println(ans);
            System.exit(0);
        } else {
            System.out.println(-1);
        }

    }
}
