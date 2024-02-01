import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [][] food;
    static boolean isSelected[];
    static int N;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        food = new int [N][2];
        isSelected = new boolean[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            food[i][0] = Integer.parseInt(st.nextToken());
            food[i][1] = Integer.parseInt(st.nextToken());
        }
        choice(0);
        System.out.println(min);
    }

    public static void choice(int count){
        if(count == N){
            int tmpS = 1;
            int tmpB = 0;
            int countF = 0;
            for(int i = 0; i < count; i++){
                if(isSelected[i]){
                    tmpS *= food[i][0];
                    tmpB += food[i][1];
                }else{
                    countF++;
                }
            }
            if (count == countF){
                return;
            }
            min = Math.min(min,Math.abs(tmpS-tmpB));
            return;
        }
        isSelected[count] = true;
        choice(count + 1);
        isSelected[count] = false;
        choice(count+1);

    }
}
