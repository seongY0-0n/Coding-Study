
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Ac_17281
 */
public class Main {
    static int N, ining[][], playerSeq[];
    static boolean isSelected[];
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ining = new int[N][9];
        playerSeq = new int[9];
        isSelected = new boolean[9];
        isSelected[0] = true;
        playerSeq[3] = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                ining[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        perm(0);
        System.out.println(ans);
    }

    public static void perm(int count) {
        if (count == 9) {
            // 타순은 정했고 야구 시작!
            ans = Math.max(ans, playBaseBall());
            return;
        }

        // 4번타자는 이미 있으니까 스킵
        if (count == 3) {
            perm(count + 1);
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                playerSeq[count] = i;
                perm(count + 1);
                isSelected[i] = false;
            }
        }
    }

    public static int playBaseBall() {
        int score = 0;

        int nowHitPlayer = 0; // 현재 타순
        for (int i = 0; i < N; i++) {
            int out = 0;
            int base[] = { 0, 0, 0 };
            while (out != 3) {
                int nowHitPlayerNum = playerSeq[nowHitPlayer];

                switch (ining[i][nowHitPlayerNum]) {
                    case 1:
                        if (base[2] == 1) {
                            base[2] = 0;
                            score++;
                        }
                        if (base[1] == 1) {
                            base[2] = 1;
                            base[1] = 0;
                        }
                        if (base[0] == 1) {
                            base[1] = 1;
                            base[0] = 0;
                        }
                        base[0] = 1;
                        break;

                    case 2:
                        if (base[2] == 1) {
                            base[2] = 0;
                            score++;
                        }
                        if (base[1] == 1) {
                            base[1] = 0;
                            score++;
                        }
                        if (base[0] == 1) {
                            base[2] = 1;
                            base[0] = 0;
                        }
                        base[1] = 1;
                        break;
                    case 3:
                        if (base[2] == 1) {
                            base[2] = 0;
                            score++;
                        }
                        if (base[1] == 1) {
                            base[1] = 0;
                            score++;
                        }
                        if (base[0] == 1) {
                            base[0] = 0;
                            score++;
                        }
                        base[2] = 1;
                        break;
                    case 4:
                        score++;
                        for (int j = 0; j < 3; j++) {
                            if (base[j] == 1) {
                                score++;
                            }
                            base[j] = 0;
                        }
                        break;
                    case 0:
                        out++;
                        break;
                }
                if (++nowHitPlayer == 9)
                    nowHitPlayer = 0;
            }
        }

        return score;
    }
}