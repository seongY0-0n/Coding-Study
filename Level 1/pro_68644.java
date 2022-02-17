import java.util.*;

public class pro_68644 {
    public List<Integer> solution(int[] numbers) {
        
        HashSet<Integer> number = new HashSet<>();
        for(int i = 0; i<numbers.length; i++){
            for(int j = i+1; j<numbers.length; j++){
                number.add(numbers[i] + numbers[j]);
            }
        }
        List<Integer> answer = new ArrayList<>(number);
        Collections.sort(answer);
        return answer;
    }
}
