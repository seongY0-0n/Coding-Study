import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long buildings[] = new long[N];
        long ans = 0;

        for (int i = 0; i < N; i++) {
            buildings[i] = Long.parseLong(br.readLine());
        }

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!st.isEmpty() && buildings[st.peek()] <= buildings[i]) {
                ans += i - st.peek() - 1;
                st.pop();
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            ans += N - st.peek() - 1;
            st.pop();
        }

        System.out.println(ans);
    }
}
