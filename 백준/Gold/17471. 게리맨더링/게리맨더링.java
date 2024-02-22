
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int peoples[];
    static boolean isSelected[], canVisited[], isVisited[];
    static List<List<Integer>> arr;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        peoples = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        peoples[0] = -1;
        for (int i = 1; i < N + 1; i++) {
            peoples[i] = Integer.parseInt(st.nextToken());
        }
        arr = new ArrayList<>();
        isSelected = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                int v = Integer.parseInt(st.nextToken());
                arr.get(i).add(v);
                arr.get(v).add(i);
            }
        }
        subset(1);
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

    }

    public static boolean check(List<Integer> a) {
        int size = 0;
        canVisited = new boolean[N + 1];
        isVisited = new boolean[N + 1];
        for (int i : a) {
            canVisited[i] = true;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(a.get(0));
        isVisited[a.get(0)] = true;
        size++;
        while (!q.isEmpty()) {
            int t = q.poll();
            for (int i : arr.get(t)) {
                if (!isVisited[i] && canVisited[i]) {
                    q.add(i);
                    isVisited[i] = true;
                    size++;
                }
            }
        }
        if (size == a.size()) {
            return true;
        } else {
            return false;
        }

    }

    public static void subset(int count) {
        if (count == N) {
            List<Integer> aSite = new ArrayList<>();
            List<Integer> bSite = new ArrayList<>();
            for (int i = 1; i < N + 1; i++) {
                if (isSelected[i]) {
                    aSite.add(i);
                }

                else
                    bSite.add(i);
            }
            if (aSite.size() == 0 || bSite.size() == 0)
                return;

            int a = 0;
            int b = 0;
            if (check(aSite) && check(bSite)) {
                for (int i = 1; i < N + 1; i++) {
                    if (isSelected[i]) {
                        a += peoples[i];
                    } else {
                        b += peoples[i];
                    }
                }
                ans = Math.min(ans, Math.abs(a - b));
            }

            return;
        }

        isSelected[count] = true;
        subset(count + 1);
        isSelected[count] = false;
        subset(count + 1);

    }
}
