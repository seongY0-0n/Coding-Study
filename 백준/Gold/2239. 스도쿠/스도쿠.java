import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char 스도쿠[][];
    static int zeronum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        스도쿠 = new char[9][9];
        for (int i = 0; i < 9; i++) {
            스도쿠[i] = br.readLine().toCharArray();
        }
        zeronum = 0;
        for (int index = 0; index < 9; index++) {
            for (int i = 0; i < 9; i++) {
                if (스도쿠[index][i] == '0') {
                    zeronum++;
                }
            }
        }
        backtracking(0, 0, 0);

    }

    public static void backtracking(int count, int i, int j) {
        if (count == zeronum) {
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < 9; k++) {
                for(int m = 0; m < 9; m++){
                    sb.append(스도쿠[k][m]);
                }
                if(k!=8)
                    sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
            return;
        }
        if (i == 9)
            return;

        if (스도쿠[i][j] != '0') {
            if (j == 8) {
                backtracking(count, i + 1, 0);
            } else {
                backtracking(count, i, j + 1);
            }
        } else {
            if (j == 8) {
                boolean temp = false;
                for (int k = 1; k < 10; k++) {
                    if (check(i, j, (char) (k + '0'))) {
                        temp = true;
                        스도쿠[i][j] = (char) (k + '0');
                        backtracking(count + 1, i + 1, 0);
                    }
                    스도쿠[i][j] = '0';
                }
                if (!temp)
                    return;
            } else {
                boolean temp = false;
                for (int k = 1; k < 10; k++) {
                    if (check(i, j, (char) (k + '0'))) {
                        temp = true;
                        스도쿠[i][j] = (char) (k + '0');
                        backtracking(count + 1, i, j + 1);
                    }
                    스도쿠[i][j] = '0';
                }
                if (!temp)
                    return;
            }
        }
    }

    public static boolean check(int r, int c, char a) {
        for (int i = 0; i < 9; i++) {
            if (스도쿠[r][i] == a)
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if (스도쿠[i][c] == a)
                return false;
        }
        for (int i = (r / 3) * 3; i < (r / 3) * 3 + 3; i++) {
            for (int j = (c / 3) * 3; j < (c / 3) * 3 + 3; j++) {
                if (스도쿠[i][j] == a) {
                    return false;
                }
            }
        }
        return true;
    }
}
