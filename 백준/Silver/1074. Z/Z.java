import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int x = 0;
	static int y = 0;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int result = Z((int)Math.pow(2, N), r, c);
		System.out.println(result);
	}
	
	public static int Z(int n, int r, int c) {
		n /= 2;
		if(r < x + n && c < y + n) {
			count += (n * n * 0);
		}else if(r < x + n && c >= y + n) {
			count += (n * n * 1);
			y += n;
		}else if(c < y + n) {
			count += (n * n * 2);
			x += n;
		}else {
			count += (n * n * 3);
			x += n;
			y += n;
		}
		if(n == 1) return count;
		return Z(n, r, c);
	}

}