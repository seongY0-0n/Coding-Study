
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Shark {
    int r, c, s, d, z;
    boolean isCatched = false;

    public Shark(int r, int c, int s, int d, int z) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
        isCatched = false;
    }

}

public class Main {
    static int r, c, m, map[][], ans;
    static Shark[] sharks;
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[r + 1][c + 1];
        sharks = new Shark[m + 1];
        sharks[0] = new Shark(0, 0, 0, 0, 0);
        sharks[0].isCatched = true;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            sharks[i] = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()));
            map[sharks[i].r][sharks[i].c] = i;
        }

        for (int i = 1; i <= c; i++) {
            chatchShark(i);
            moveShark();
        }
        System.out.println(ans);
    }

    public static void chatchShark(int c) {
        for (int i = 1; i <= r; i++) {
            if (map[i][c] != 0) {
                ans += sharks[map[i][c]].z;
                sharks[map[i][c]].isCatched = true;
                map[i][c] = 0;
                return;
            }
        }
    }

    public static void moveShark() {
        int[][] newMap = new int[r + 1][c + 1];
        int index = 0;
        for (Shark s : sharks) {
            if (!s.isCatched) {
                int nr = s.r;
                int nc = s.c;
                for (int i = 0; i < s.s; i++) {
                    if (nr + dir[s.d][0] > 0 && nr + dir[s.d][0] <= r && nc + dir[s.d][1] > 0
                            && nc + dir[s.d][1] <= c) {
                        nr += dir[s.d][0];
                        nc += dir[s.d][1];
                    } else {
                        switch (s.d) {
                            case 0:
                                s.d = 1;
                                nr += dir[s.d][0];
                                nc += dir[s.d][1];
                                break;
                            case 1:
                                s.d = 0;
                                nr += dir[s.d][0];
                                nc += dir[s.d][1];
                                break;
                            case 2:
                                s.d = 3;
                                nr += dir[s.d][0];
                                nc += dir[s.d][1];
                                break;
                            case 3:
                                s.d = 2;
                                nr += dir[s.d][0];
                                nc += dir[s.d][1];
                                break;
                        }
                    }
                }
                s.r = nr;
                s.c = nc;
                if (newMap[nr][nc] == 0) {
                    newMap[nr][nc] = index;
                } else {
                    if (sharks[newMap[nr][nc]].z < sharks[index].z) {
                        sharks[newMap[nr][nc]].isCatched = true;
                        newMap[nr][nc] = index;
                    } else {
                        sharks[index].isCatched = true;
                    }
                }
            }
            index++;
        }
        map = newMap;
    }
}
