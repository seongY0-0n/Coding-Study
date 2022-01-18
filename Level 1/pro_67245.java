//키패드 누르기(level 1)
public class pro_67245 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int Left = 10;
        int Right = 12;

        for(int n:numbers){
            if(n==1||n==4||n==7){
                answer+="L";
                Left = n;
            }else if(n==3||n==6||n==9){
                answer+="R";
                Right = n;
            }else if(n==0){
                n=11;
                int L = Math.abs(n-Left)/3 + Math.abs(n-Left)%3;
                int R = Math.abs(n-Right)/3 + Math.abs(n-Right)%3;
                if(L<R){
                    answer+="L";
                    Left = n;
                }else if(R<L){
                    answer+="R";
                    Right = n;
                }else{
                    if(hand.equals("right")) {
                        answer+="R";
                        Right = n;
                    }else{
                        answer+="L";
                        Left = n;
                    }
                }
            }else{
                int L = Math.abs(n-Left)/3 + Math.abs(n-Left)%3;
                int R = Math.abs(n-Right)/3 + Math.abs(n-Right)%3;
                if(L<R){
                    answer+="L";
                    Left = n;
                }else if(R<L){
                    answer+="R";
                    Right = n;
                }else{
                    if(hand.equals("right")) {
                        answer+="R";
                        Right = n;
                    }else{
                        answer+="L";
                        Left = n;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        pro_67245 p = new pro_67245();
        int[] n1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        int[] n2 = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
        int[] n3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

        System.out.println(p.solution(n1, "right"));
        System.out.println(p.solution(n2, "left"));
        System.out.println(p.solution(n3, "right"));
    }
}
