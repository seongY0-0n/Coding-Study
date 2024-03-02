import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int num = Integer.parseInt(br.readLine());
    int total = m + m + n + n;
    int store[] = new int[num + 1];
    for (int i = 0; i <= num; i++) {
      st = new StringTokenizer(br.readLine());
      int d = Integer.parseInt(st.nextToken());
      store[i] = Integer.parseInt(st.nextToken());

      if (d == 2)
        store[i] = m - store[i];
      else if (d == 3)
        store[i] = n - store[i];

      switch (d) {
        case 3:
          store[i] += m;
        case 2:
          store[i] += n;
        case 4:
          store[i] += m;
      }
    }
    int sum = 0;
    for (int i = 0; i < num; i++) {
      int len = Math.abs(store[num] - store[i]);
      sum += Math.min(len, total - len);
    }

    System.out.println(sum);
  }
}
