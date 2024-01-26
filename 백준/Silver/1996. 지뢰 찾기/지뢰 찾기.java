import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static char[][] map;
    public static char[][] ans;
    public static int N;

    public static void countBomb(int i, int j) {
        int[] di = { 1, -1, 0, 0, 1, 1, -1, -1 };
        int[] dj = { 0, 0, 1, -1, 1, -1, 1, -1 };
        int temp = 0;
        for (int k = 0; k < 8; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];
            if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
                if (map[ni][nj] != '.') {
                    temp += map[ni][nj] - '0';
                }
            }
        }
        if (temp>9){
            ans[i][j] = 'M';
        }else{
            ans[i][j] = (char)(temp + '0') ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().replaceAll(" ", "").toCharArray();
        }

        ans = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != '.')
                    ans[i][j] = '*';
                else
                    countBomb(i, j);
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(ans[i]);
        }
    }
}
