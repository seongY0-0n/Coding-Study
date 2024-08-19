import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
     
        HashMap <String, String> carIn = new HashMap();
        HashMap <String, Integer> price = new HashMap();
        
        for(String r: records){
            String time = r.split(" ")[0];
            String carNum = r.split(" ")[1];
            String status = r.split(" ")[2];
            if(carIn.containsKey(carNum)){
                String inTime = carIn.get(carNum);
                int inHour = Integer.parseInt(inTime.split(":")[0]);
                int inMin = Integer.parseInt(inTime.split(":")[1]);
                int outHour = Integer.parseInt(time.split(":")[0]);
                int outMin = Integer.parseInt(time.split(":")[1]);
                int totalTime = (outHour - inHour) * 60 + outMin - inMin;
                price.put(carNum, price.get(carNum) + totalTime);
                carIn.remove(carNum);
                
            
            }else{
                carIn.put(carNum, time);
                if(!price.containsKey(carNum)){
                    price.put(carNum, 0);
                }
                
            }
        }
   
        //나가지 않은 차들 처리
        List<String> keySet = new ArrayList<>(carIn.keySet());
        for(String k : keySet){
            String inTime = carIn.get(k);
            int inHour = Integer.parseInt(inTime.split(":")[0]);
            int inMin = Integer.parseInt(inTime.split(":")[1]);
            int totalTime = (23 - inHour) * 60 + 59 - inMin;
            int pre = price.get(k);
            price.replace(k, pre + totalTime);
        }
        
        List<String> keySet1 = new ArrayList<>(price.keySet());
        Collections.sort(keySet1);
        int[] answer = new int[keySet1.size()];
        for(int i = 0 ; i < keySet1.size(); i++){
            int totalTime = price.get(keySet1.get(i));
            if(totalTime<=fees[0]){
                answer[i] = fees[1];
            }else{
                if((totalTime-fees[0])%fees[2]==0){
                    answer[i] = fees[1] + (totalTime-fees[0])/fees[2]*fees[3];
                }else {
                    answer[i] = fees[1] + ((totalTime-fees[0])/fees[2]+1)*fees[3];
                }
                
            }
        }
       

        
        
        return answer;
    }
}