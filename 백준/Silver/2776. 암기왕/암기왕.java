import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            HashMap<Integer, Integer> memo1 = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                memo1.put(Integer.parseInt(st.nextToken()), 1);
            }

            int m = Integer.parseInt(br.readLine());
            int memo2[] = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                if (memo1.containsKey(Integer.parseInt(st.nextToken()))) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }

            }
            sb.replace(sb.lastIndexOf("\n"), sb.lastIndexOf("\n") + 1, "");
            System.out.println(sb);
        }

    }
}
