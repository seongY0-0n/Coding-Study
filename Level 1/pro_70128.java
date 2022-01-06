//  내적 (level 1)

public class pro_70128{
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i = 0; i<a.length; i++){
            answer = answer + a[i]*b[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        pro_70128 p = new pro_70128();
        int[] a1 = {1, 2, 3, 4};
        int[] b1 = {-3, -1, 0, 2};
        int[] a2 = {-1, 0, 1};
        int[] b2 = {1, 0, -1};

        System.out.println(p.solution(a1, b1));
        System.out.println(p.solution(a2, b2));
    }
}