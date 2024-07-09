import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());
            int ans1 = Integer.MAX_VALUE;
            int ans2 = 0;
            int start = 0;
            int end = 1;
            if (k == 1){
                System.out.println(1 + " " + 1);
                continue;
            }

            while (start != w.length()) {
                int n = 1;
                for (int j = end; j < w.length(); j++) {
                    if (w.charAt(start) == w.charAt(j)) {
                        n++;
                    }
                    if (n == k) {
                        if (ans1 > j - start + 1)
                            ans1 = j - start + 1;
                        if (ans2 < j - start + 1){
                            ans2 = j - start + 1;
                        }
                        break;
                    }
                }

                start++;
                end = start + 1;

            }
            if (ans1 == Integer.MAX_VALUE) {
                ans1 = -1;
                System.out.println(ans1);
            } else {
                System.out.println(ans1 + " " + ans2);
            }

        }

    }
}
