import java.util.Arrays;

//로또의 최고 순위와 최저 순위 (level 1)
public class pro_77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0,0};
        int  count = 0;
        for (int i = 0 ; i<6 ; i++){
            for (int j = 0 ; j<6; j++){
                if(lottos[i] == win_nums[j]){
                    count++;
                }
            }
        }
        switch(count){
            case 6: answer[1] = 1;
                break;
            case 5: answer[1] = 2;
                break;
            case 4: answer[1] = 3;
                break;
            case 3: answer[1] = 4;
                break;
            case 2: answer[1] = 5;
                break;
            default: answer[1] = 6;
        }
        count = 0;
        for (int i = 0 ; i<6 ; i++){
            for (int j = 0 ; j<6; j++){
                if(lottos[i] == win_nums[j]){
                    count++;
                }
            }
        }
        for(int i = 0 ; i < 6; i++){
            if(lottos[i]==0){
                count++;
            }
        }
        switch(count){
            case 6: answer[0] = 1;
                break;
            case 5: answer[0] = 2;
                break;
            case 4: answer[0] = 3;
                break;
            case 3: answer[0] = 4;
                break;
            case 2: answer[0] = 5;
                break;
            default: answer[0] = 6;
        }
        return answer;
    }
    
    public static void main(String[] args) {
        pro_77484 p = new pro_77484();

        int [] lottos1 = {44, 1, 0, 0, 31, 25};
        int [] lottos2 = {0, 0, 0, 0, 0, 0};
        int [] lottos3 = {45, 4, 35, 20, 3, 9};
        int [] win_nums1 = {31, 10, 45, 1, 6, 19};
        int [] win_nums2 = {38, 19, 20, 40, 15, 25};
        int [] win_nums3 = {20, 9, 3, 45, 4, 35};
        int intArray1[];
        int intArray2[];
        int intArray3[];
        intArray1 = p.solution(lottos1, win_nums1);
        intArray2 = p.solution(lottos2, win_nums2);
        intArray3 = p.solution(lottos3, win_nums3);
        for(int i=0; i<3;i++)
        {   
            System.out.println(intArray1[i]);
            System.out.println(intArray2[i]);
            System.out.println(intArray3[i]);
        }
       


    }
}
