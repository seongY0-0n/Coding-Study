
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int p[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int arr[][] = new int[n + 1][n + 1];
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1)
                    Union(i, j);
            }
        }
        int travel[] = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            travel[i] = Integer.parseInt(st.nextToken());
        }

        // System.out.println(Arrays.toString(p));
        int root = Find_Set(travel[0]);
        for (int t : travel) {
            if (root != Find_Set(t)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static int Find_Set(int x) {
        if (x == p[x])
            return x;
        return Find_Set(p[x]);
    }

    public static void Union(int x, int y) {
        if (Find_Set(x) == Find_Set(y))
            return;

        p[Find_Set(y)] = Find_Set(x);
    }
}
