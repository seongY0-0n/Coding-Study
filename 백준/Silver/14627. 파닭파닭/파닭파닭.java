import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int len[] = new int[s];

        // 파의 길이를 입력받음
        for (int i = 0; i < s; i++) {
            len[i] = Integer.parseInt(br.readLine());
        }
        
        // 파의 길이를 오름차순으로 정렬
        Arrays.sort(len);
        
        // 이진 탐색을 위한 변수
        int start = 1;
        int end = len[s - 1];
        long answer = 0L;  // 남은 파의 길이 합을 저장할 변수
        int totalChicken = 0; // 최적의 파 길이를 사용해 만든 치킨 조각 개수

        // 이진 탐색 시작
        while (start <= end) {
            int mid = (start + end) / 2;
            int chicken = 0;  // 현재 파 길이(mid)로 만든 조각 수
            long remainder = 0L;  // 남은 파 길이

            // 모든 파 길이에 대해 조각 수와 남은 길이 계산
            for (int l : len) {
                chicken += l / mid;  // 파를 mid 길이로 잘라 얻은 조각 수
                remainder += l % mid;  // 잘라서 남은 파 길이
            }

            if (chicken >= c) {
                // 조각 수가 충분하면, 파 길이를 더 크게 시도
                answer = remainder;  // 남은 파 길이를 저장
                start = mid + 1;
                totalChicken = chicken;  // 현재 mid에서 얻은 치킨 조각 수를 기록
            } else {
                // 조각 수가 부족하면, 파 길이를 더 작게 시도
                end = mid - 1;
            }
        }

        // 최종적으로 남은 파의 길이에서, 남는 조각의 수를 정확히 조정
        // (총 만든 치킨 조각 수 - 필요한 치킨 조각 수)만큼 더 잘라낼 수 있는 파 길이를 계산
        answer += (totalChicken - c) * end;

        // 결과 출력
        System.out.println(answer);
    }
}
