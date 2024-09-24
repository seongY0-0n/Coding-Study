import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 접시의 수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] susie = new int[n]; // 초밥 배열
        for (int i = 0; i < n; i++) {
            susie[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1]; // 초밥의 종류별 먹은 개수 카운팅
        int variety = 0; // 현재 먹고 있는 초밥 종류 수

        // 초기 k개의 초밥 처리
        for (int i = 0; i < k; i++) {
            if (count[susie[i]] == 0) variety++;
            count[susie[i]]++;
        }

        int maxVariety = variety;

        // 쿠폰 초밥이 없는 경우 추가
        if (count[c] == 0) maxVariety++;

        // 슬라이딩 윈도우로 회전 초밥 처리
        for (int i = 1; i < n; i++) {
            // 이전 초밥 제거
            int prev = susie[i - 1];
            count[prev]--;
            if (count[prev] == 0) variety--; // 종류 감소

            // 새로운 초밥 추가
            int next = susie[(i + k - 1) % n];
            if (count[next] == 0) variety++; // 새로운 종류 추가
            count[next]++;

            // 쿠폰 초밥 추가 고려
            int currentMax = variety;
            if (count[c] == 0) currentMax++; // 쿠폰 초밥을 더할 수 있으면 추가

            maxVariety = Math.max(maxVariety, currentMax);
        }

        System.out.println(maxVariety);
    }
}
