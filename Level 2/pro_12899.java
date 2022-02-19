// 124나라의 숫자(level 2)
public class pro_12899 {
    public String solution(int n) {
        String answer = "";
        String[] number = {"4","1","2"};
        while(n>0){
            int a = n%3;
            n/=3;

            if(a==0) n--;

            answer = number[a] + answer;
            
        }
        return answer;
    }
    public static void main(String[] args) {
        pro_12899 p = new pro_12899();
        System.out.println(p.solution(10));
    }
}
