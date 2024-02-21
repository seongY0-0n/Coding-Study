import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char c[];
    static boolean isSelected[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        c = new char[C];
        c = br.readLine().replace(" ", "").toCharArray();
        isSelected = new boolean[C];
        Arrays.sort(c);
        dfs(0, 0);
    }

    public static void dfs(int count, int start) {
        if (count == L) {
            String s = "";
            int temp = 0;
            int temp1 = 0;
            for (int i = 0; i < C; i++) {
                if (isSelected[i]) {
                    s += c[i];
                    if (c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u') {
                        temp++;
                    } else {
                        temp1++;
                    }
                }
            }
            if (temp != 0 && temp != count && temp1 >= 2) {
                System.out.println(s);
            }

            return;
        }

        for (int i = start; i < C; i++) {
            isSelected[i] = true;
            dfs(count + 1, i + 1);
            isSelected[i] = false;
        }
    }
}
