import java.util.ArrayDeque;
import java.util.Queue;

 class Solution {
    public int solution(int[][] board) {
      int answer = Integer.MAX_VALUE;
      int d[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
      boolean isVisited[][][] = new boolean[board.length][board.length][4];

      Queue<int[]> q = new ArrayDeque<>();
      q.add(new int[] { 0, 0, 0, -1 });

      while (!q.isEmpty()) {
        int t[] = q.poll();
        if (t[0] == board.length - 1 && t[1] == board.length - 1) {
          answer = Math.min(answer, t[2]);
        }
        for (int i = 0; i < 4; i++) {
          int ni = t[0] + d[i][0];
          int nj = t[1] + d[i][1];

          if (ni < 0 || ni >= board.length || nj < 0 || nj >= board.length || board[ni][nj] == 1)
            continue;

          int nPrice = t[2];
          if (t[3] == -1 || t[3] == i) {
            nPrice += 100;
          } else {
            nPrice += 600;
          }

          if (!isVisited[ni][nj][i] || board[ni][nj]>=nPrice) {
            isVisited[ni][nj][i] = true;
            board[ni][nj] = nPrice;
            q.add(new int[] { ni, nj, nPrice, i });
          }
        }
      }
      return answer;
    }
  }