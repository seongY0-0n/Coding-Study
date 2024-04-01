
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] score = new int[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                score[Integer.parseInt(st.nextToken()) - 1] = Integer.parseInt(st.nextToken()) - 1;
            }

            int ans = 0;
            int temp = score[0];
            for (int i = 1; i < n; i++) {
                if (score[i] > temp) {
                    ans++;
                } else {
                    temp = score[i];
                }
            }
            System.out.println((n - ans));
        }
    }
}
