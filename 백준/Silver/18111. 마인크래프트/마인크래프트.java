import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int ans = 0;

        List<Integer> rand = new ArrayList<Integer>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                rand.add(Integer.parseInt(st.nextToken()));
            }
        }
 
        int maxRand = Collections.max(rand);
        int minRand = Collections.min(rand);
        int maxHeight = 0;
        int minTime = Integer.MAX_VALUE;
        for (int h = minRand; h < maxRand + 1; h++) {
            int tempTime = 0;
            int tempB = B;
            for (int i = 0; i < N * M; i++) {
                if (rand.get(i) < h ) {
                    tempB -= h - rand.get(i);
                    tempTime += h - rand.get(i);
                } else if (rand.get(i) > h) {
                    tempB += rand.get(i) - h;
                    tempTime += (rand.get(i) - h)*2;
                }
            }
            if(tempB<0)break;
            // System.out.println(tempTime);
            // System.out.println(tempB);
            if (tempTime <= minTime ){
                minTime = tempTime;
                if(maxHeight<h) maxHeight=h;
            }
        }
        System.out.print(minTime+" ");
        System.out.println(maxHeight);
    }
}
