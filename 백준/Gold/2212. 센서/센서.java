import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        if (n <= k) {
            System.out.println(0);
            return;
        }

        int 센서[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            센서[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(센서);

        List<Integer> dist = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            dist.add(i, 센서[i + 1] - 센서[i]);
        }
        Collections.sort(dist, Collections.reverseOrder());
        int ans = 0;
        for (int i = k - 1; i < dist.size(); i++) {
            ans += dist.get(i);
        }
        System.out.println(ans);
    }
}
