import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int homeX = Integer.parseInt(st.nextToken());
            int homeY = Integer.parseInt(st.nextToken());

            int cu[][] = new int[n][2];
            boolean isVisited[] = new boolean[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                cu[i][0] = Integer.parseInt(st.nextToken());
                cu[i][1] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] { homeX, homeY });
            boolean isFinished = false;

            while (!q.isEmpty()) {
                int index[] = q.poll();
                if(canGo(index, new int[]{endX,endY})){
                    System.out.println("happy");
                    isFinished = true;
                    break;
                }
                for(int i = 0; i < n; i++){
                    if(!isVisited[i] && canGo(index, cu[i])){
                        q.add(cu[i]);
                        isVisited[i] = true;
                    }
                }
            }
            if(!isFinished)
                System.out.println("sad");
        }
    }

    public static boolean canGo(int i1[], int i2[]) {
        if ((Math.abs(i1[0] - i2[0]) + Math.abs(i1[1] - i2[1])) <= 1000)
            return true;

        return false;
    }
}
