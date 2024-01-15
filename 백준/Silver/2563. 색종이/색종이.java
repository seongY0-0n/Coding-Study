import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int ans = 0;
    int[][] paper = new int[100][100];
    for (int i = 0; i < num; i++){
      int x = sc.nextInt();
      int y = sc.nextInt();
      for (int j = x; j < x + 10; j++){
        for (int k = y; k < y + 10; k++){
          paper[j][k] = 1;
        }
      }
    }
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
          if (paper[i][j] == 1) {
              ans += paper[i][j];
          }
      }
  }
    
    System.out.println(ans);

  }
}
