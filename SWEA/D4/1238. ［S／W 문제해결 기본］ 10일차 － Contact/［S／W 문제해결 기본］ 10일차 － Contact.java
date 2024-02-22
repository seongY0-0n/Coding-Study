import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static boolean isVisited[];
    static int seq[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            List<HashSet<Integer>> arr = new ArrayList<>();
            seq = new int[101];
            int ans = Integer.MIN_VALUE;
            int result = 0;
            isVisited = new boolean[101];
            for (int i = 0; i < 101; i++) {
                arr.add(new HashSet<Integer>());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n / 2; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr.get(a).add(b);
            }

            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            isVisited[start] = true;
            int temp = 0;
            seq[start] = 0;
            while (!q.isEmpty()) {
                int t = q.poll();
                for (int i : arr.get(t)) {
                    if (!isVisited[i]) {
                        isVisited[i] = true;
                        q.add(i);
                        seq[i] = seq[t] + 1;
                    }
                }
            }

            for (int i = 0; i < 101; i++) {
                if (ans <= seq[i]) {
                    ans = seq[i];
                    result = i;
                }
            }
            System.out.println("#" + tc + " " + result);
        }

    }
}
