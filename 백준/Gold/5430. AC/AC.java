import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
  static String ac;
  static ArrayDeque<Integer> dq = new ArrayDeque<>();
  static StringTokenizer st;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;

  public static void main(String[] args) throws NumberFormatException, IOException {
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      boolean reversed = true;
      boolean isError = false;
      ac = br.readLine();
      n = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine(), "[],");

      for (int j = 0; j < n; j++) {

        dq.add(Integer.parseInt(st.nextToken()));

      }
      for (int k = 0; k < ac.length(); k++) {
        if (ac.charAt(k) == 'R') {
          reversed = !reversed;
        } else {
          if (dq.isEmpty()) {
            isError = true;
            break;
          }

          if (reversed) {
            dq.removeFirst();
          } else {
            dq.removeLast();
          }
        }
      }
      if (!isError) {
        if (reversed) {
          StringBuilder sb = new StringBuilder();
          sb.append('[');
          if (dq.isEmpty()) {

          } else {
            sb.append(dq.pollFirst());
            while (!dq.isEmpty()) {
              sb.append(',');
              sb.append(dq.pollFirst());
            }
          }

          sb.append(']');
          System.out.println(sb.toString());
        } else {
          StringBuilder sb = new StringBuilder();
          sb.append('[');
          if (dq.isEmpty()) {

          } else {
            sb.append(dq.pollLast());
            while (!dq.isEmpty()) {
              sb.append(',');
              sb.append(dq.pollLast());
            }
          }
          sb.append(']');
          System.out.println(sb.toString());
        }
      } else {
        System.out.println("error");
      }
    }
  }
}
