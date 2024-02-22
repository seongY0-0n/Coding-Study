import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int 초밥[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        초밥 = new int[d + 1];
        int cycle[] = new int[N + k - 1];
        int ans = 0;
        for (int i = 0; i < N; i++) {
            cycle[i] = Integer.parseInt(br.readLine());
        }
        int idx = 0;

        for (int i = N; i < N + k - 1; i++) {
            cycle[i] = cycle[idx++];
        }

        for (int i = 0; i < k; i++) {
            초밥[cycle[i]]++;
            if (초밥[cycle[i]] == 1)
                ans++;
        }
        초밥[c]++;
        if (초밥[c] == 1)
            ans++;
        int start = 0;
        int finish = k - 1;
        int temp = ans;
        while (true) {
            if (초밥[cycle[start]] == 1)
                temp--;
            초밥[cycle[start++]]--;

            if (초밥[cycle[++finish]] == 0)
                temp++;
            초밥[cycle[finish]]++;
            ans = Math.max(ans, temp);
            if (finish == N + k - 2)
                break;
        }
        System.out.println(ans);
    }
}
