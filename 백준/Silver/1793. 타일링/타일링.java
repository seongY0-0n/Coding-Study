import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger dp[] = new BigInteger[251];
        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        BigInteger temp = new BigInteger("2");
        for (int i = 2; i < 251; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2].multiply(temp));
        }
        String line = null;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            System.out.println(dp[n]);
        }

    }
}
