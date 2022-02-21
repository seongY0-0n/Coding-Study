//기능개발 (level2)
import java.util.*;
public class pro_42586 {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] day = new int[progresses.length]; 
        for(int i = 0; i<speeds.length; i++){
            int temp = 0;
            while(progresses[i]<100){
                progresses[i] += speeds[i];
                temp++;
            }
            day[i] = temp;
        }
        int count = 1;
        int temp = day[0];
        for(int i = 1; i<day.length; i++){
            if(day[i]<=temp){
                count++;
            }else{
                answer.add(count);
                temp = day[i];
                count = 1;
            }
        }
        answer.add(count);
        return answer;
    }

    public static void main(String[] args) {
        pro_42586 p = new pro_42586();
        int[] progresses1 = {93,30,55};
        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds1 = {1, 30, 5};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};
        p.solution(progresses1, speeds1);
        p.solution(progresses2, speeds2);

    }
}
