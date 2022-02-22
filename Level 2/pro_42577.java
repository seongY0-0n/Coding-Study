import java.util.Arrays;

public class pro_42577 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;  
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])) answer = false;
        }
        return answer;
    }
    public static void main(String[] args) {
        pro_42577 p = new pro_42577();
        String[] p1 = {"119", "97674223", "1195524421"};
        String[] p2 = {"123","456","789"};
        String[] p3 = {"12","123","1235","567","88"};
        System.out.println(p.solution(p1));
        System.out.println(p.solution(p2));
        System.out.println(p.solution(p3));
    }
}
