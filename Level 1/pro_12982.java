import java.util.Arrays;

public class pro_12982 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int D: d){
            if(D<=budget){
                answer++;
                budget -= D;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        pro_12982 p = new pro_12982();
        int[] d = {1,3,2,5,4};
        p.solution(d, 9);
    }
}
