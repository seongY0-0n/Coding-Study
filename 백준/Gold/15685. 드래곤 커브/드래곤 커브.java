import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] pos = new int[101][101];
        int[][] dir = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
        int ans = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            pos[x][y] = 1;
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(d);
            for (int j = 0; j < g; j++) {
                for (int k = arr.size() - 1; k >= 0; k--) {
                    int nd = (arr.get(k) + 1) % 4;
                    arr.add(nd);
                }
            }

            for (int j = 0; j < arr.size(); j++) {
                x = x + dir[arr.get(j)][0];
                y = y + dir[arr.get(j)][1];
                pos[x][y] = 1;
            }
        }
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (pos[i][j] == 1 && pos[i + 1][j] == 1 && pos[i][j + 1] == 1 && pos[i + 1][j + 1] == 1) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
