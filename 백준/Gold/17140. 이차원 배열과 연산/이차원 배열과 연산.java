
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int r, c, k, arr[][], 행, 열;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[101][101];
        for (int i = 1; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        행 = 3;
        열 = 3;
        while (arr[r][c] != k) {
            ans++;
            if (ans == 101) {
                System.out.println(-1);
                return;
            }
            if (행 >= 열) {
                func_r();
            } else {
                func_c();
            }

        }
        System.out.println(ans);
    }

    public static void func_r() {
        int temp[][] = new int[101][101];
        int m = 열;
        for (int i = 1; i <= 행; i++) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int j = 1; j <= 열; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }
                if (hm.containsKey(arr[i][j])) {
                    hm.put(arr[i][j], hm.get(arr[i][j]) + 1);
                } else {
                    hm.put(arr[i][j], 1);
                }
            }
            List<Integer> keySet = new ArrayList<>(hm.keySet());
            m = Math.max(m, keySet.size() * 2);
            keySet.sort(new Comparator<Integer>() {

                @Override
                public int compare(Integer o1, Integer o2) {
                    if (hm.get(o1) == hm.get(o2)) {
                        return o1 - o2;
                    }
                    return hm.get(o1) - hm.get(o2);
                }

            });
            int idx = 1;
            for (int k : keySet) {
                temp[i][idx] = k;
                temp[i][idx + 1] = hm.get(k);
                idx += 2;
                // System.out.print(k + " " + hm.get(k) + " ");
                if (idx > 100) {
                    break;
                }
            }
            // System.out.println();
        }
        // System.out.println("_____________________________________________________");
        arr = temp;
        열 = m;

    }

    public static void func_c() {
        int temp[][] = new int[101][101];
        int m = 행;
        for (int i = 1; i <= 열; i++) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int j = 1; j <= 행; j++) {
                if (arr[j][i] == 0) {
                    continue;
                }
                if (hm.containsKey(arr[j][i])) {
                    hm.put(arr[j][i], hm.get(arr[j][i]) + 1);
                } else {
                    hm.put(arr[j][i], 1);
                }
            }
            List<Integer> keySet = new ArrayList<>(hm.keySet());
            m = Math.max(m, keySet.size() * 2);
            keySet.sort(new Comparator<Integer>() {

                @Override
                public int compare(Integer o1, Integer o2) {
                    if (hm.get(o1) == hm.get(o2)) {
                        return o1 - o2;
                    }
                    return hm.get(o1) - hm.get(o2);
                }

            });
            int idx = 1;
            for (int k : keySet) {
                temp[idx][i] = k;
                temp[idx + 1][i] = hm.get(k);
                idx += 2;
                // System.out.print(k + " " + hm.get(k) + " ");
                if (idx > 100) {
                    break;
                }
            }
            // System.out.println();
        }
        // System.out.println("_____________________________________________________");
        arr = temp;
        행 = m;
    }
}
