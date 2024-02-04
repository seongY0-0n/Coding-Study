import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[] str;
    static boolean[] isSelected;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().toCharArray();
        isSelected = new boolean[str.length];
        Arrays.sort(str); // 사전순으로 출력하기 위해 미리 정렬

        perm(0, ' ');
        System.out.println(count);
    }

    public static void perm(int depth, char prev) {
        if (depth == str.length) {
            count++;
            return;
        }

        for (int i = 0; i < str.length; i++) {
            if (!isSelected[i] && str[i] != prev) {
                if (i > 0 && str[i] == str[i - 1] && !isSelected[i - 1]) {
                    continue; // 양 쪽에 같은 문자가 있는 경우 스킵
                }

                isSelected[i] = true;
                perm(depth + 1, str[i]);
                isSelected[i] = false;
            }
        }
    }
}
