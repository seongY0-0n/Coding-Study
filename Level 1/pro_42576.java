import java.util.HashMap;

public class pro_42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        pro_42576 p = new pro_42576();
        String[] participant_1 = {"leo", "kiki", "eden"};
        String[] participant_2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] participant_3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion_1 = {"eden", "kiki"};
        String[] completion_2 = {"josipa", "filipa", "marina", "nikola"};
        String[] completion_3 = {"stanko", "ana", "mislav"};
       
        System.out.println( p.solution(participant_1, completion_1));
        System.out.println( p.solution(participant_2, completion_2));
        System.out.println( p.solution(participant_3, completion_3));
    }
}
