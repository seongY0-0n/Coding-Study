import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int color[] = new int[m];
        for (int i = 0; i < m; i++) {
            color[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(color);
        int start = 1;
        int end = color[m - 1];
        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 0;
            for (int c : color) {
                if (c % mid == 0) {
                    count += c / mid;
                } else {
                    count += c / mid + 1;
                }
            }
            if (count > n) {
                start = mid + 1;

            } else {
                end = mid - 1;
                answer = mid;
            }

        }
        System.out.println(answer);

    }
}
