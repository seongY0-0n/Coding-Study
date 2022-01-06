// 음양더하기 (level 1)

public class pro_76501 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0 ; i<absolutes.length;i++){
            if(signs[i]==true){
                answer = answer + absolutes[i];
            }else{
                answer = answer - absolutes[i];
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        pro_76501 p = new pro_76501();
        int [] absolutes1 = {4,7,12};
        boolean [] signs1 = {true, false, true};
        int [] absolutes2 = {1,2,3};
        boolean [] signs2 = {false, false, true};
        System.out.println(p.solution(absolutes1, signs1));
        System.out.println(p.solution(absolutes2, signs2));
    }
}
