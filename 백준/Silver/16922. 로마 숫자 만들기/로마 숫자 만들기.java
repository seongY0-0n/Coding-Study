import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 


        Set<Integer> current = new HashSet<>();
        current.add(1);
        current.add(5);
        current.add(10);
        current.add(50);
        int[] roma = {1, 5, 10, 50};

        for (int i = 1; i < N; i++) {  // i = 1부터 시작 (N-1번 반복)
            Set<Integer> next = new HashSet<>();
            for (int num : current) {
                for (int r : roma) {
                    next.add(num + r);
                }
            }
            current = next;  // 업데이트
        }

        System.out.println(current.size());
    }
}
