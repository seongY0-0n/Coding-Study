import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i = 0; i < n; i++) {
      pq.offer(Integer.parseInt(br.readLine()));
    }
    if (n == 1) {
      System.out.println(0);
    } else {
      int result = 0;
      while (true) {
        int a = pq.poll();
        int b = pq.poll();
        result += a + b;
        if (pq.isEmpty())
          break;
        pq.add(a + b);
      }
      System.out.println(result);
    }

  }

}
