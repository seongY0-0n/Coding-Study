
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
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }

            });
            for (int i = 0; i < n; i++) {
                주가[i] = Integer.parseInt(st.nextToken());
                pq.offer(new int[] { i, 주가[i] });
            }
            int dDay = pq.peek()[0];
            int price = pq.poll()[1];

            for (int i = 0; i < n; i++) {
                if (dDay > i) {
                    ans += (price - 주가[i]);
                } else {
                    while (!pq.isEmpty()) {
                        dDay = pq.peek()[0];
                        price = pq.poll()[1];
                        if (dDay > i)
                            break;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
