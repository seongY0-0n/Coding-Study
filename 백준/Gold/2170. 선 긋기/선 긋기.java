
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int pos[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(pos, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }

        });
        int start = pos[0][0];
        int finish = pos[0][1];
        int ans = finish - start;
        for (int i = 1; i < n; i++) {
            int nextStart = pos[i][0];
            int nextFinish = pos[i][1];
            if (nextStart >= finish) {
                start = nextStart;
                finish = nextFinish;
                ans += finish - start;
            } else {
                if (nextFinish <= finish)
                    continue;
                else {
                    ans += nextFinish - finish;
                    finish = nextFinish;
                }
            }
        }
        System.out.println(ans);
    }
}
