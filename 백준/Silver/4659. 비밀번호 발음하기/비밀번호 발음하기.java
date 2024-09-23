import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String vowel = "aeiou";

        while (true) {
            String str = br.readLine();
            if (str.equals("end"))
                break;

            boolean hasVowel = false;  // 모음이 하나라도 있는지 확인하는 변수
            boolean isAcceptable = true;  // 규칙을 만족하는지 여부
            int vowelCount = 0, consonantCount = 0;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                // 모음인지 확인
                if (vowel.contains(String.valueOf(c))) {
                    hasVowel = true;  // 모음이 하나라도 있음을 표시
                    vowelCount++;
                    consonantCount = 0;  // 자음 연속 카운트 초기화
                } else {
                    consonantCount++;
                    vowelCount = 0;  // 모음 연속 카운트 초기화
                }

                // 모음이든 자음이든 3개 이상 연속되면 안됨
                if (vowelCount == 3 || consonantCount == 3) {
                    isAcceptable = false;
                    break;
                }

                // 같은 문자가 연속 두 번 오는지 확인 (단, ee와 oo는 예외)
                if (i > 0 && str.charAt(i) == str.charAt(i - 1) &&
                    !(str.charAt(i) == 'e' || str.charAt(i) == 'o')) {
                    isAcceptable = false;
                    break;
                }
            }

            // 모음이 없으면 규칙 위반
            if (!hasVowel) {
                isAcceptable = false;
            }

            if (isAcceptable) {
                System.out.println("<" + str + "> is acceptable.");
            } else {
                System.out.println("<" + str + "> is not acceptable.");
            }
        }
    }
}
