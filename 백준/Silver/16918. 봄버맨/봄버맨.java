import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int time = 1;
    public static int R;
    public static int C;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        char[][] bomb = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                if (s.charAt(j) == 'O')
                    bomb[i][j] = '0';
                else
                    bomb[i][j] = s.charAt(j);
            }
        }
        while (time != N) {
            time += 1;
            if (time % 2 == 0) {
                insert(bomb);
            } else {
                pang(bomb);
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bomb[i][j] != '.')
                    bomb[i][j] = 'O';
                System.out.print(bomb[i][j]);
            }
            System.out.println();
        }
    }

    public static void insert(char[][] bomb) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bomb[i][j] == '.')
                    bomb[i][j] = (char) (time + '0');
            }
        }
    }

    public static void pang(char[][] bomb) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bomb[i][j] == (char) (time - 3 + '0')) {
                    bomb[i][j] = '.';
                    if (i + 1 < R && bomb[i + 1][j] != (char) (time - 3 + '0'))
                        bomb[i + 1][j] = '.';
                    if (i - 1 >= 0 && bomb[i - 1][j] != (char) (time - 3 + '0'))
                        bomb[i - 1][j] = '.';
                    if (j + 1 < C && bomb[i][j + 1] != (char) (time - 3 + '0'))
                        bomb[i][j + 1] = '.';
                    if (j - 1 >= 0 && bomb[i][j - 1] != (char) (time - 3 + '0'))
                        bomb[i][j - 1] = '.';
                } // 시간 비교해서 터뜨려야함! 그것도 동시에!

            }
        }
    }
}
