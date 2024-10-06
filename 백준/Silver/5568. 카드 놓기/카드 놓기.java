import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static int k, n;
    static boolean visited[];
    static int num[];
    static HashSet<String> hs = new HashSet<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // n개의 숫자 입력
        k = Integer.parseInt(br.readLine()); // k개의 숫자를 선택

        num = new int[n]; // 숫자를 저장할 배열

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine()); // 각 숫자를 입력받음
        }

        visited = new boolean[n]; // 숫자를 방문했는지 체크할 배열
        generatePermutations(0, ""); // 초기 호출
        System.out.println(hs.size()); // 결과 출력
    }

    // 재귀적으로 k개의 숫자를 선택하여 문자열로 결합하는 함수
    public static void generatePermutations(int count, String current) {
        if (count == k) { // k개의 숫자를 선택했을 때
            hs.add(current); // HashSet에 결합된 숫자 문자열을 추가
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true; // 현재 숫자를 선택함
                generatePermutations(count + 1, current + num[i]); // 숫자를 문자열로 결합하여 다음 단계로 재귀 호출
                visited[i] = false; // 백트래킹: 다시 선택하지 않은 상태로 돌림
            }
        }
    }
}
