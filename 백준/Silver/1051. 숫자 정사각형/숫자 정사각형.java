import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M, ans = 1;
    static char[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        // for(int i=0; i<N; i++){
        //     String s = br.readLine();
        //     for(int j=0; j<M; j++){
        //         arr[i][j] = s.charAt(j) - '0';
        //     }
        // }
        for(int i = 0; i<N; i++){
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i<N; i++){
            for (int j = 0; j<M; j++){
                int temp = arr[i][j];
                for (int k = 1; j+k < M; k++){
                    if(i+k<N&&arr[i][j+k]==temp &&arr[i+k][j]==temp &&arr[i+k][j+k]==temp){
                        ans = Math.max(ans, k+1);
                    }
                }
            }
        }
        System.out.println(ans*ans);
    }
}