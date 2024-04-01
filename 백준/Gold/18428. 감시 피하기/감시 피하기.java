import java.util.*;
import java.io.*;

public class Main {

	static int N, tSize;
    static char [][] map;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {-1,1,0,0};
    static ArrayList<Pos> targetMap = new ArrayList<>();
    static Queue<Pos> teacher = new LinkedList<>();

    static class Pos {
        int x, y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void tempMethod() {
    	int cnt = targetMap.size();
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			if (map[i][j] == 'X') {
    				targetMap.add(new Pos(j, i));
    				cnt++;
    				if (cnt == 3) {
    					return;
    				}
    			}
    		}
    	}
    }

    public static void sightOfTeacher(int x, int y, int dir) {
        int j = 1;
        while (true) {
            int nx = x + dx[dir] * j;
            int ny = y + dy[dir] * j;
            if (map[ny][nx] == 'S') {
                break;
            }
            targetMap.add(new Pos(nx, ny));
            j++;
        }
        if (targetMap.size() < 3) tempMethod();
    }

    public static boolean checkCanSeeStudent(int x, int y) {
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            int j = 1;
            while (true) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (map[ny][nx] == 'S') {
                        flag = true;
                        sightOfTeacher(x, y, i);
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
        }
        return flag;
    }

    public static boolean finalCheck() {
        for (int p = 0; p < tSize; p++) {
            Pos pos = teacher.poll();
            int x = pos.x;
            int y = pos.y;
            for (int i = 0; i < 4; i++) {
                int j = 1;
                while (true) {
                    int nx = x + dx[i] * j;
                    int ny = y + dy[i] * j;
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        if (map[ny][nx] == 'S') {
                            teacher.offer(pos);
                            return false;
                        } else if (map[ny][nx] == 'O') {
                            break;
                        }
                    } else {
                        break;
                    }
                    j++;
                }
            }
            teacher.offer(pos);
        }
        return true;
    }

    public static void dfs(int depth, int start) {
        if (depth == 3) {
            if (finalCheck()) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        for (int i = start; i < targetMap.size(); i++) {
            Pos pos = targetMap.get(i);
            map[pos.y][pos.x] = 'O';
            dfs(depth + 1, i + 1);
            map[pos.y][pos.x] = 'X';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'T') {
                    teacher.offer(new Pos(j, i));
                }
            }
        }

        int size = teacher.size();


        for (int i = 0; i < size; i++) {
            Pos pos = teacher.poll();
            if (!checkCanSeeStudent(pos.x, pos.y)) {
                map[pos.y][pos.x] = 'X';
            } else {
                teacher.offer(pos);
            }
        }
        tSize = teacher.size();
        dfs(0, 0);
        System.out.println("NO");
    }

}
