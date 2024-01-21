import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    String X = st.nextToken();
    String Y = st.nextToken();
    char[] arrX = X.toCharArray();
    char[] arrY = Y.toCharArray();
    int diff = Y.length() - X.length();
    int result = X.length();
    for (int i = 0; i < diff + 1; i++) {
      int temp = 0;
      for (int j = 0; j < X.length(); j++) {
        if (arrX[j] != arrY[j + i]) {
          temp++;
        }
      }
      if (result > temp) {
        result = temp;
      }
    }
    System.out.println(result);
  }
}
