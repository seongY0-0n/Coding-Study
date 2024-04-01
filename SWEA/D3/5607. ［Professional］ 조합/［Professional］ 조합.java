import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static long [] factorial = new long[1000001];
	static int p = 1234567891;
	
	private static long calculatePow(long n, long k) {
        if(k == 1){
            return n;
        }
        long x = calculatePow(n, k/2) % p;
        if(k % 2 == 0){
            return x * x % p;
        }else{
            return ((x * x) % p * n) % p;
        }
    }

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		factorial[0] = 1;
        for(int i=1; i<=1000000; i++){
            factorial[i] = factorial[i-1] * i % p;
        }
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
	        long c1 = factorial[N];
            long c2 = (factorial[N - R] * factorial[R]) % p;
            long c3 = calculatePow(c2, p - 2);
            
            sb.append("#").append(t).append(" ").append(c1 * c3 % p).append("\n");
		}
		System.out.println(sb);
	}

}