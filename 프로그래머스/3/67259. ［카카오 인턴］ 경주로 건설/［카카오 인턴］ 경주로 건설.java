import java.util.ArrayDeque;
import java.util.Queue;
public class Solution{
 public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int d[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        // 방향 벡터별 방문처리
        boolean isVisited[][][] = new boolean[board.length][board.length][4];

        Queue<int[]> q = new ArrayDeque<>();

        // c, r, 비용, 방향
        q.add(new int[] { 0, 0, 0, -1 });

        while (!q.isEmpty()) {
            int t[] = q.poll();

            // 목적지 도착하면 비용 비교
            if (t[0] == board.length - 1 && t[1] == board.length - 1) {
                answer = Math.min(answer, t[2]);
            }

            for (int i = 0; i < 4; i++) {
                int ni = t[0] + d[i][0];
                int nj = t[1] + d[i][1];

                if (ni < 0 || ni >= board.length || nj < 0 || nj >= board.length || board[ni][nj] == 1)
                    continue;

//                 switch (t[3]) {
//                     case 0:
//                         if (i == 1)
//                             continue;
//                         break;
//                     case 1:
//                         if (i == 0)
//                             continue;
//                         break;
//                     case 2:

//                         if (i == 3)
//                             continue;
//                         break;
//                     case 3:

//                         if (i == 2)
//                             continue;
//                         break;

//                 }

                int nPrice = t[2];
                if (t[3] == -1 || t[3] == i) {
                    nPrice += 100;
                } else {
                    nPrice += 600;
                }

                if (!isVisited[ni][nj][i] || (isVisited[ni][nj][i] &&board[ni][nj] >= nPrice)) {
                    isVisited[ni][nj][i] = true;
                    board[ni][nj] = nPrice;
                    q.add(new int[] { ni, nj, nPrice, i });
                }
            }
        }
        return answer;
    }
}