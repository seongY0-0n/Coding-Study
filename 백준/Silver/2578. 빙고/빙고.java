import java.io.*;
import java.util.*;

public class Main {
    public static int[][] my = new int[5][5];
    public static boolean[][] marked = new boolean[5][5];
    public static int[] rowCount = new int[5];
    public static int[] colCount = new int[5];
    public static int diag1Count = 0, diag2Count = 0;
    public static Map<Integer, int[]> positionMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        // 빙고판 입력 및 위치 저장
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                my[i][j] = Integer.parseInt(st.nextToken());
                positionMap.put(my[i][j], new int[]{i, j});
            }
        }

        // 사회자가 부르는 숫자
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int number = Integer.parseInt(st.nextToken());
                result++;

                if (positionMap.containsKey(number)) {
                    int[] pos = positionMap.get(number);
                    int x = pos[0], y = pos[1];

                    // 숫자 체크
                    marked[x][y] = true;
                    rowCount[x]++;
                    colCount[y]++;
                    if (x == y) diag1Count++;
                    if (x + y == 4) diag2Count++;

                    // 빙고 3개 완성 시 종료
                    if (countBingo() >= 3) {
                        System.out.println(result);
                        return;
                    }
                }
            }
        }
    }

    public static int countBingo() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (rowCount[i] == 5) count++;
            if (colCount[i] == 5) count++;
        }
        if (diag1Count == 5) count++;
        if (diag2Count == 5) count++;
        return count;
    }
}