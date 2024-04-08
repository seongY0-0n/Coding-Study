
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
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(num);
            List<Integer> temp1 = new ArrayList<>();
            List<Integer> temp2 = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    temp1.add(num[i]);
                } else {
                    temp2.add(num[i]);
                }
            }
            for (int i = temp2.size() - 1; i >= 0; i--) {
                temp1.add(temp2.get(i));
            }
            int ans = Integer.MIN_VALUE;
            for (int i = 0; i < temp1.size() - 1; i++) {
                int result = Math.abs(temp1.get(i) - temp1.get(i + 1));
                ans = Math.max(ans, result);
            }
            ans = Math.max(ans, Math.abs(temp1.get(0) - temp1.get(temp1.size() - 1)));
            System.out.println(ans);
        }
    }

}
