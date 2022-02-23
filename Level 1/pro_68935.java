import java.util.ArrayList;

public class pro_68935{
    public int solution(int n) {
        int answer = 0;
        ArrayList<String> number = new ArrayList<>();
        while(n>=1){
            String a =  Integer.toString(n%3);
            number.add(a);
            n=n/3;
        }
        int a = 1;
        for(int i = number.size()-1; i>=0;i--){
            answer += Integer.parseInt(number.get(i))*a;
            a = a*3;
        }

        return answer;
    }
    public static void main(String[] args) {
        pro_68935 p = new pro_68935();
        System.out.println(p.solution(45));
    }
}