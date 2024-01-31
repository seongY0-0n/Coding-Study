import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static String s;
    static int[] arr;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        comb(0, 0);
        if(k>count)System.out.print(-1);

    }

    public static void comb(int total, int level) {
        if (total > n) return;
        if (total == n) {
            count++;
            if (count == k) {
                for (int i = 0; i < level - 1; i++) {
                    System.out.print(arr[i] + "+");
                }
                System.out.println(arr[level - 1]);
            }
            return;
        }
        for (int i = 1; i < 4; i++) {
            arr[level] = i;
            comb(total + i, level + 1);
        }
    }
}
