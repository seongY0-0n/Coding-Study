import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int min = 0;

            int dl[] = new int[] { 1, -1, 0, 0, 0, 0 };
            int dr[] = new int[] { 0, 0, 1, -1, 0, 0 };
            int dc[] = new int[] { 0, 0, 0, 0, 1, -1 };

            if (l == 0 && r == 0 && c == 0)
                break;

            char building[][][] = new char[l][r][c];
            boolean isVisited[][][] = new boolean[l][r][c];
            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r + 1; j++) {
                    String s = br.readLine();
                    if (s.equals(""))
                        continue;
                    if (s.contains("S")) {
                        q.add(new int[] { i, j, s.indexOf("S"), min });
                        isVisited[i][j][s.indexOf("S")] = true;
                    }
                    building[i][j] = s.toCharArray();
                }
            }
            boolean isFinished = false;
            while (!q.isEmpty()) {
                int index[] = q.poll();
                for (int i = 0; i < 6; i++) {
                    int nl = index[0] + dl[i];
                    int nr = index[1] + dr[i];
                    int nc = index[2] + dc[i];
                    int nm = index[3] + 1;

                    if (nl < 0 || nl >= l || nr < 0 || nr >= r || nc < 0 || nc >= c)
                        continue;
                    if (isVisited[nl][nr][nc] || building[nl][nr][nc] == '#')
                        continue;
                    if (building[nl][nr][nc] == 'E') {
                        isFinished = true;
                        System.out.println("Escaped in " + nm + " minute(s).");
                        break;
                    }
                    q.add(new int[] { nl, nr, nc, nm });
                    isVisited[nl][nr][nc] = true;
                }
                if (isFinished)
                    break;
            }
            if (!isFinished)
                System.out.println("Trapped!");
        }
    }
}
