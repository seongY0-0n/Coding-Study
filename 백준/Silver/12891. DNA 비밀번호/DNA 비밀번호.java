
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int p, s, a, c, g, t, ans;

    static char[] Dna;
    static HashMap<Character, Integer> count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        Dna = new char[s];
        Dna = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        count = new HashMap<>();
        count.put('A', 0);
        count.put('C', 0);
        count.put('G', 0);
        count.put('T', 0);

        for (int i = 0; i < p; i++) {
            switch (Dna[i]) {
                case 'A':
                    count.put('A', count.get('A') + 1);
                    break;
                case 'C':
                    count.put('C', count.get('C') + 1);
                    break;
                case 'G':
                    count.put('G', count.get('G') + 1);
                    break;
                case 'T':
                    count.put('T', count.get('T') + 1);
                    break;
            }
        }

        check();
        for (int i = 1; i < s - p+1; i++) {
            count.put(Dna[i - 1], count.get(Dna[i - 1]) - 1);
            count.put(Dna[i + p - 1], count.get(Dna[i + p - 1]) + 1);
            check();
        }
        System.out.println(ans);
    }

    public static void check() {

        int ta = count.get('A');
        int tc = count.get('C');
        int tg = count.get('G');
        int tt = count.get('T');

        if (ta >= a && tc >= c && tg >= g && tt >= t) ans++;
    }


}
