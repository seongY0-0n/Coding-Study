
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int zero = 0;
        int ans = 0;
        PriorityQueue<Integer> 음수 = new PriorityQueue<>();
        PriorityQueue<Integer> 양수 = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }

        });
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num < 0) {
                음수.offer(num);
            } else if (num > 0) {
                양수.offer(num);
            } else {
                zero++;
            }
        }
        while (양수.size() > 1) {
            int a = 양수.poll();
            int b = 양수.poll();
            if (a == 1 || b == 1) {
                ans += a + b;
            } else {
                ans += a * b;
            }

        }
        if (!양수.isEmpty()) {
            ans += 양수.poll();
        }

        while (음수.size() > 1) {
            ans += 음수.poll() * 음수.poll();
        }
        if (!음수.isEmpty()) {
            if (zero == 0) {
                ans += 음수.poll();
            }
        }
        System.out.println(ans);
    }
}
