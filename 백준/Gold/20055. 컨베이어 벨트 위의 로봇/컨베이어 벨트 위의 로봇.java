import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, K, belt[];
    static List <Integer> robot = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new int[2*N +1];
        int turn = 1;
        int dead = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= 2*N; i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }
        
        while(true){
            moveBelt();
            if(robot.size()!= 0){
                for(int r : robot){
                    if(robot.contains(r+1)){
                        continue;
                    }
                    if(belt[r+1]==0){
                        continue;
                    }
                    robot.set(robot.indexOf(r),r+1);
                    belt[r+1]--;
                    if(belt[r+1]==0){
                        dead++;
                    }
                    if(r+1==N){
                        robot.set(robot.indexOf(r+1),-1);
                    }
                }
                robot.removeAll(Arrays.asList(Integer.valueOf(-1)));

            }
            if(belt[1] != 0){
                robot.add(1);
                belt[1]--;
                if(belt[1]==0){
                    dead++;
                }
            }
            if(dead>=K){
                System.out.println(turn);
                break;
            }
            turn++;
        }

    }

    public static void moveBelt(){
        int temp = belt[2*N];
        for(int i = 2*N; i>=2; i--){
            belt[i] = belt[i-1];
        }
        belt[1] = temp;
        for(int i = 0; i < robot.size(); i++){
            if(robot.get(i) == N-1){
                robot.set(i, -1);
            }else{
                robot.set(i, robot.get(i)+1);
            }  
        }
        robot.removeAll(Arrays.asList(Integer.valueOf(-1)));

    }
}
