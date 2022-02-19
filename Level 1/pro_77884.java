public class pro_77884 {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i<=right; i++){
            int count = 0;
            for(int j=1; j<=i;j++){
                if(i%j==0){
                    count++;
                }
            }
            if(count%2==0){
                answer+=i;
            }else{
                answer-=i;
            }

        }
        return answer;
    }
    public static void main(String[] args) {
        pro_77884 p = new pro_77884();
        System.out.println(p.solution(13, 17)); 
    }
}
