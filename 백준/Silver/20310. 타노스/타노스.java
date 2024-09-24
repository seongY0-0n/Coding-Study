import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int one = 0, zero = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                one++;
            } else {
                zero++;
            }
        }
        one = one / 2;
        zero = zero / 2;

        for (int i = 0; i < zero; i++) {
            System.out.print('0');
        }

        for (int i = 0; i < one; i++) {
            System.out.print('1');
        }
    }
}
