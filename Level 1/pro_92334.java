import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class pro_92334{
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap <String, ArrayList<String>> hashmap = new HashMap<>();
        HashMap <String, Integer> count = new HashMap<>();
        ArrayList<String> stop = new ArrayList<>();
        for(String id: id_list){
            ArrayList <String> list = new ArrayList<>();
            hashmap.put(id,list);
            count.put(id,0);
        }
        // 유저가 신고한 아이디, 신고 당한 횟수 저장
        for(String r: report){
            String[] temp = r.split(" ");
            ArrayList<String> list = hashmap.get(temp[0]);
            if(!list.contains(temp[1])){
                list.add(temp[1]);
                count.put(temp[1],count.get(temp[1])+1);
            }
            hashmap.put(temp[0],list);
        }
        for(String id: id_list){
            if(count.get(id) >= k){
                stop.add(id);
            }
        }
        for(int i = 0; i<id_list.length; i++){
            ArrayList<String> list = hashmap.get(id_list[i]);
            for(String s: stop){
                if(list.contains(s)){
                    answer[i]++;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        pro_92334 p = new pro_92334();
        String [] id_list1 = {"muzi", "frodo", "apeach", "neo"};
        String [] id_list2 = {"con", "ryan"};
        String [] report1 = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        String [] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int Array1[];
        int Array2[];
        Array1 = p.solution(id_list1, report1, 2);
        Array2 = p.solution(id_list2, report2, 3);

        for(int i = 0; i < Array1.length; i++){
                System.out.println(Array1[i]);
        }

        for(int i = 0; i < Array2.length; i++){
            System.out.println(Array2[i]);
        }
    }
}