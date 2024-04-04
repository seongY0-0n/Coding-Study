
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }
        for (String s : str) {
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (!hm.containsKey(c)) {
                    hm.put(c, (int) Math.pow(10, s.length() - i - 1));
                } else {
                    hm.put(c, hm.get(c) + (int) Math.pow(10, s.length() - i - 1));
                }
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : hm.values()) {
            pq.add(i);
        }
        int num = 9;
        int ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll() * num--;
        }
        System.out.println(ans);
    }
}
