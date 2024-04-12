
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int A[][] = new int[n + 1][2];

        for (int i = 1; i < n + 1; i++) {
            A[i][0] = Integer.parseInt(br.readLine());
            A[i][1] = i;

        }
        Arrays.sort(A, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }

        });
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            if (A[i][1] - i > 0) {
                ans = Math.max(ans, A[i][1] - i);
            }
        }
        System.out.println(ans + 1);
    }
}
