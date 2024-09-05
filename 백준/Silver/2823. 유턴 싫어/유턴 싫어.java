import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        boolean b = true;
        char street[][] = new char[r][c];
        for (int i = 0; i < r; i++) {
            street[i] = br.readLine().toCharArray();
        }
        int di[] = { 1, 0, -1, 0 };
        int dj[] = { 0, 1, 0, -1 };
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (street[i][j] == '.') {
                    int num = 0;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + di[k];
                        int nj = j + dj[k];
                        if (ni < 0 || ni >= r || nj < 0 || nj >= c || street[ni][nj] == 'X') {
                            num++;
                        }
                    }
                    if (num > 2) {
                        b = false;
                    }
                }
            }
        }
        if (b) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
