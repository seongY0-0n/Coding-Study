// 신규 아이디 추천 (Level 1)
public class pro_72410 {
    public String solution(String new_id) {
        String answer = "";
        //1단계
        answer = new_id.toLowerCase();
        //2단계
        String match = "[^a-z0-9-_.]";
        answer = answer.replaceAll(match, "");
        //3단계
        match = "\\.{2,}";
        answer = answer.replaceAll(match, ".");
        //4단계
        match = "^(\\.)|(\\.)$";
        answer = answer.replaceAll(match, "");
        //5단계
        if(answer.length()==0){
            answer = "a";
        }
        //6단계
        if(answer.length()>15){
            answer = answer.substring(0, 15).replaceAll(match, "");
        }
        //7단계
        while(answer.length()<3){
            answer += answer.charAt(answer.length()-1);
        }
        return answer;
    }
    public static void main(String[] args) {
        pro_72410 p = new pro_72410();
        String new_id_1 = "...!@BaT#*..y.abcdefghijklm";
        String new_id_2 = "z-+.^.";
        String new_id_3 = "=.=";
        String new_id_4 = "123_.def";
        String new_id_5 = "abcdefghijklmn.p";
        System.out.println(p.solution(new_id_1));
        System.out.println(p.solution(new_id_2));
        System.out.println(p.solution(new_id_3));
        System.out.println(p.solution(new_id_4));
        System.out.println(p.solution(new_id_5));

    }
}
