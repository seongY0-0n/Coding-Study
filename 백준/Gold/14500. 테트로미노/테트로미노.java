import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(Math.max(Math.max(Math.max(t1(), t2()), Math.max(t3(), t4())), t5()));
    }

    public static int t1() {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 3; j++) {
                int temp = 0;
                temp += map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i][j + 3];
                result = Math.max(result, temp);
            }
        }
        for (int i = 0; i < n - 3; i++) {
            for (int j = 0; j < m; j++) {
                int temp = 0;
                temp += map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 3][j];
                result = Math.max(result, temp);

            }
        }
        return result;
    }

    public static int t2() {
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                int temp = 0;
                temp += map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1];
                result = Math.max(result, temp);
            }
        }
        return result;
    }

    public static int t3() {
        int result = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 1; j++) {
                int temp = 0;
                temp += map[i][j] + map[i + 2][j + 1] + map[i + 1][j] + map[i + 2][j];
                result = Math.max(result, temp);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 2; j++) {
                int temp = 0;
                temp += map[i][j] + map[i + 1][j] + map[i][j + 1] + map[i][j + 2];
                result = Math.max(result, temp);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 2; j++) {
                int temp = 0;
                temp += map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
                result = Math.max(result, temp);
            }
        }
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 1; j++) {
                int temp = 0;
                temp += map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1] + map[i + 2][j];
                result = Math.max(result, temp);
            }
        }
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 1; j++) {
                int temp = 0;
                temp += map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1];
                result = Math.max(result, temp);
            }
        }
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 1; j++) {
                int temp = 0;
                temp += map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 2][j];
                result = Math.max(result, temp);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 2; j++) {
                int temp = 0;
                temp += map[i][j + 2] + map[i + 1][j + 2] + map[i + 1][j + 1] + map[i + 1][j];
                result = Math.max(result, temp);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 2; j++) {
                int temp = 0;
                temp += map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 2];
                result = Math.max(result, temp);
            }
        }
        return result;
    }

    public static int t4() {
        int result = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 1; j++) {
                int temp = 0;
                temp += map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1];
                result = Math.max(result, temp);
            }
        }
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 1; j++) {
                int temp = 0;
                temp += map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j] + map[i + 2][j];
                result = Math.max(result, temp);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 2; j++) {
                int temp = 0;
                temp += map[i + 1][j] + map[i + 1][j + 1] + map[i][j + 1] + map[i][j + 2];
                result = Math.max(result, temp);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 2; j++) {
                int temp = 0;
                temp += map[i][j] + map[i + 1][j + 1] + map[i][j + 1] + map[i + 1][j + 2];
                result = Math.max(result, temp);
            }
        }
        return result;
    }

    public static int t5() {
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 2; j++) {
                int temp = 0;
                temp += map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i][j + 2];
                result = Math.max(result, temp);
            }
        }
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 1; j++) {
                int temp = 0;
                temp += map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1];
                result = Math.max(result, temp);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 2; j++) {
                int temp = 0;
                temp += map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
                result = Math.max(result, temp);
            }
        }
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 1; j++) {
                int temp = 0;
                temp += map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j];
                result = Math.max(result, temp);
            }
        }
        return result;
    }
}
