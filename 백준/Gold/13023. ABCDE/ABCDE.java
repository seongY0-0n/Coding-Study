
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> ls;
    static boolean isVisted[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ls = new ArrayList<>();

        for (int i = 0; i < N; i++)
            ls.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ls.get(x).add(y);
            ls.get(y).add(x);
        }

        for (int i = 0; i < N; i++) {
            isVisted = new boolean[N];
            dfs(i, 0);
        }
        System.out.println(0);
    }

    public static void dfs(int x, int count) {
        if (count == 4) {
            System.out.println(1);
            System.exit(0);
        }
        isVisted[x] = true;
        for (int i = 0; i < ls.get(x).size(); i++) {
            if (!isVisted[ls.get(x).get(i)]) {
                dfs(ls.get(x).get(i), count + 1);
            }
        }
        isVisted[x] = false;
    }

}
