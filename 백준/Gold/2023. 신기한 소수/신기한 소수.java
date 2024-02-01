import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<Integer> sosu = new ArrayList<>();

        sosu.add(2);
        sosu.add(3);
        sosu.add(5);
        sosu.add(7);

        for (int i = 1; i < N; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int s : sosu) {
                int tmp = s * 10;
                for(int j = 1; j < 10; j+=2){
                    if(isSosu(tmp+j))temp.add(tmp+j);
                }
            }
            sosu=temp;
        }
        for(int i = 0; i < sosu.size();i++){
            sb.append(sosu.get(i)).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean isSosu(int num) {
        for (int i = 2; i < (int) (Math.sqrt(num) + 1); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
