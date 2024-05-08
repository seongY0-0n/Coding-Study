import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int union[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        union = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            union[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 0) {
                Union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if (Find_Set(x) == Find_Set(y))
                    System.out.print("YES");
                else
                    System.out.print("NO");

                if (i == m - 1) {
                    break;
                }
                System.out.println();
            }

        }
    }

    public static void Union(int x, int y) {
        if (Find_Set(x) == Find_Set(y))
            return;
        union[Find_Set(x)] = Find_Set(y);
    }

    public static int Find_Set(int x) {
        if (x == union[x])
            return x;
        return union[x] = Find_Set(union[x]);
    }
}
