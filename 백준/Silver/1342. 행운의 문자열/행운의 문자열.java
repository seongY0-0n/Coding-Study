import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static char[] str;
  static boolean[] isSelected;
  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    str = br.readLine().toCharArray();
    StringBuilder sb = new StringBuilder();
    isSelected = new boolean[str.length];
    Arrays.sort(str);

    perm(0, ' ');
    sb.append(count);
    System.out.println(sb);
  }

  public static void perm(int depth, char prev) {
    if (depth == str.length) {
      count++;
      return;
    }

    for (int i = 0; i < str.length; i++) {
      if (!isSelected[i] && str[i] != prev) {
        if (i > 0 && str[i] == str[i - 1] && !isSelected[i - 1]) {
          continue;
        }

        isSelected[i] = true;
        perm(depth + 1, str[i]);
        isSelected[i] = false;
      }
    }
  }
}
