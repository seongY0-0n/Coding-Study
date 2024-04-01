
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        class score {
            int a, b;

            public score(int a, int b) {
                this.a = a;
                this.b = b;
            }

        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            score[] scores = new score[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                scores[i] = new score(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            Arrays.sort(scores, new Comparator<score>() {
                @Override
                public int compare(score o1, score o2) {
                    return o1.a - o2.a;
                }
            });
            int ans = 0;
            int temp = scores[0].b;
            for (int i = 1; i < n; i++) {
                if (scores[i].b > temp) {
                    ans++;
                } else {
                    temp = scores[i].b;
                }
            }
            System.out.println((n - ans));
        }
    }
}
