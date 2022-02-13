import java.util.ArrayList;
import java.util.*;

public class pro_42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        HashSet<Integer> reserves = new HashSet<Integer>();
        for(int r: reserve){
            reserves.add(r);
        }
        for(int i =0;i<lost.length;i++) {
            if(reserves.contains(lost[i])) {
                answer++;
                reserves.remove(lost[i]);
                lost[i]=-1;
            }
        }
        for(int i=0; i<lost.length;i++){
            if(reserves.contains(lost[i]-1)){
                reserves.remove(lost[i]-1);
                answer++;
            }else if(reserves.contains(lost[i]+1)){
                reserves.remove(lost[i]+1);
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        pro_42862 p = new pro_42862();
        int[] lost = {2,4};
        int[] reserve = {3};
        System.out.println(p.solution(5, lost, reserve));
    }
}
