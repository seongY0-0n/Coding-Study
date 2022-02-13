import java.util.*;

public class pro_42840 {
    public ArrayList<Integer> solution(int[] answers) {
        int[] one = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        int index = 0;
        ArrayList <Integer> count = new ArrayList<>(Arrays.asList(0,0,0,0));
        ArrayList <Integer> answer = new ArrayList<>();
        for(int i = 0; i < answers.length; i++){
            if(one[i%one.length] == answers[i]) count.set(1,count.get(1) + 1);
            if(one[i%second.length] == answers[i]) count.set(2,count.get(2) + 1);
            if(one[i%third.length] == answers[i]) count.set(3,count.get(3) + 1);
        }
        int max = Collections.max(count);
        for(int i = 0; i < count.size(); i++){
            if(count.get(i) == max){
                answer.add(i);
            }
        }

        Collections.sort(answer);

        return answer;
    }

    
    }
}
