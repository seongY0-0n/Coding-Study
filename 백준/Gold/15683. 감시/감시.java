import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int[] cctvCase = { 0, 4, 2, 4, 4, 1 };
    static int answer = 0, n, m;

    static int cctvCount = 0;
    static int cctv[][] = new int[8][3];

    static void search(int count) {
        if (count == cctvCount) {
            answer = Math.min(answer, getCount());
            return;
        }
        for (int d = 0; d < cctvCase[cctv[count][2]]; d++) {
            find(cctv[count][0], cctv[count][1], cctv[count][2], d, 0);
            search(count + 1);
            // 다음 경우의 수를 위해서 지워!!
            find(cctv[count][0], cctv[count][1], cctv[count][2], d, 1);
        }
    }

    static void check(int x, int y, int type, int d, int back) {
        switch (d) {
            case 0:
                for (int i = x + 1; i < n; i++) {
                    if (back == 0 && arr[i][y] <= 0)
                        arr[i][y] -= 1;
                    else if (back == 1 && arr[i][y] < 0)
                        arr[i][y] += 1;
                    else if (arr[i][y] == 6)
                        break;
                }
                break;
            case 1:
                for (int i = y + 1; i < m; i++) {
                    if (back == 0 && arr[x][i] <= 0)
                        arr[x][i] -= 1;
                    else if (back == 1 && arr[x][i] < 0)
                        arr[x][i] += 1;
                    else if (arr[x][i] == 6)
                        break;
                }
                break;
            case 2:
                for (int i = x - 1; i >= 0; i--) {
                    if (back == 0 && arr[i][y] <= 0)
                        arr[i][y] -= 1;
                    else if (back == 1 && arr[i][y] < 0)
                        arr[i][y] += 1;
                    else if (arr[i][y] == 6)
                        break;
                }
                break;
            case 3:
                for (int i = y - 1; i >= 0; i--) {
                    if (back == 0 && arr[x][i] <= 0)
                        arr[x][i] -= 1;
                    else if (back == 1 && arr[x][i] < 0)
                        arr[x][i] += 1;
                    else if (arr[x][i] == 6)
                        break;
                }
                break;
        }
    }

    static void find(int x, int y, int type, int d, int back) {
        switch (type) {
            case 1:
                switch (d) {
                    case 0:
                        check(x, y, type, 0, back);
                        break;
                    case 1:
                        check(x, y, type, 1, back);
                        break;
                    case 2:
                        check(x, y, type, 2, back);
                        break;
                    case 3:
                        check(x, y, type, 3, back);
                        break;
                }
                break;
            case 2:
                switch (d) {
                    case 0:
                        check(x, y, type, 0, back);
                        check(x, y, type, 2, back);
                        break;
                    case 1:
                        check(x, y, type, 1, back);
                        check(x, y, type, 3, back);
                        break;
                }
                break;
            case 3:
                switch (d) {
                    case 0:
                        check(x, y, type, 0, back);
                        check(x, y, type, 1, back);
                        break;
                    case 1:
                        check(x, y, type, 1, back);
                        check(x, y, type, 2, back);
                        break;
                    case 2:
                        check(x, y, type, 2, back);
                        check(x, y, type, 3, back);
                        break;
                    case 3:
                        check(x, y, type, 3, back);
                        check(x, y, type, 0, back);
                        break;
                }
                break;
            case 4:
                switch (d) {
                    case 0:
                        check(x, y, type, 0, back);
                        check(x, y, type, 1, back);
                        check(x, y, type, 2, back);
                        break;
                    case 1:
                        check(x, y, type, 1, back);
                        check(x, y, type, 2, back);
                        check(x, y, type, 3, back);
                        break;
                    case 2:
                        check(x, y, type, 2, back);
                        check(x, y, type, 3, back);
                        check(x, y, type, 0, back);
                        break;
                    case 3:
                        check(x, y, type, 3, back);
                        check(x, y, type, 0, back);
                        check(x, y, type, 1, back);
                        break;
                }
                break;
            case 5:
                for (int i = 0; i < 4; i++) {
                    check(x, y, type, i, back);
                }
                break;
        }
    }

    static int getCount() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;
                if (temp == 0)
                    answer++;
                else if (temp > 0 && temp < 6) {
                    cctv[cctvCount][0] = i;
                    cctv[cctvCount][1] = j;
                    cctv[cctvCount++][2] = temp;
                }
            }
        }
        if (cctvCount == 0)
            System.out.println(answer);
        else {
            search(0);
            System.out.println(answer);
        }
    }
}