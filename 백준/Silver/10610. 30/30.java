import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] num = br.readLine().toCharArray();
        Arrays.sort(num);
        if (num[0] != '0') {
            System.out.println(-1);
            return;
        }
        int sum = 0;
        for (int i = 0; i < num.length; i++)
            sum += num[i] - '0';
        if (sum % 3 != 0)
            System.out.println(-1);
        else
            System.out.println(new StringBuilder(String.valueOf(num)).reverse());
    }
}