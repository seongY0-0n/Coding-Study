import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m, nums[], arr[];
    static boolean isSelected[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isSelected = new boolean[n];
        nums = new int[n];
        arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        perm(0);

    }

    public static void perm(int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) {

                System.out.print(arr[i] + " ");

            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                arr[count] = nums[i];
                perm(count + 1);
                isSelected[i] = false;
            }
        }
    }
}
