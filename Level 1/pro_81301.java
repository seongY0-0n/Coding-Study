import java.util.ArrayList;
import java.util.HashMap;

//숫자 문자열과 영단어 (Level1)
public class pro_81301 {
    public int solution(String s) {
        int answer = 0;
        String [] Anumber ={"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String [] Bnumber ={"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int i = 0;
        for(String n:Anumber){
            if(s.contains(n)){
                s = s.replace(n, Bnumber[i]);
            }
            i++;             
        }   
        answer = Integer.parseInt(s);
 
        return answer;
    }

    public static void main(String[] args) {
        pro_81301 p = new pro_81301();
        String s1 = "one4seveneight";
        String s2 = "23four5six7";
        String s3 = "2three45sixseven";
        String s4 = "123";

        System.out.println(p.solution(s1));
        System.out.println(p.solution(s2));
        System.out.println(p.solution(s3));
        System.out.println(p.solution(s4));
    }
}
