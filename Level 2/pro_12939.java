//최대값과 최소값 (level 2)
public class pro_12939{
    public String solution(String s) {
        String answer = "";
        String [] array = s.split(" ");
        int min = Integer.parseInt(array[0]);
        int max = Integer.parseInt(array[0]);
        for(String a:array){
            int b = Integer.parseInt(a);
            if(b > max){
                max = b;
            }
            if(b < min){
                min = b;
            }  
        }
        answer = String.valueOf(min) + " " + String.valueOf(max);
        return answer;
    }
}