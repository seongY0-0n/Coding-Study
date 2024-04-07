import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int size = num.length();
        int n[] = new int[size];
        for (int i = 0; i < size; i++) {
            n[i] = num.charAt(i) - '0';
        }

        Arrays.sort(n);
        if (n[0] != 0) {
            System.out.println(-1);
        } else {
            int temp = 0;
            for (int i = 0; i < size; i++) {
                temp += n[i];
            }
            if (temp % 3 != 0) {
                System.out.println(-1);
            } else {
                String ans = "";
                for (int i = size - 1; i >= 0; i--) {
                    ans += (n[i]);
                }
                System.out.println(ans);
            }
        }
    }
}
