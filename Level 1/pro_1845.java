import java.util.*;

public class pro_1845 {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> hs = new HashSet<Integer>();
        for(int i:nums){
            hs.add(i);
        }
        if(hs.size()<nums.length/2){
            answer = hs.size();
        }else{
            answer = nums.length/2;
        }
        return answer;
    }
    public static void main(String[] args) {
        pro_1845 p = new pro_1845();
        int []nums1 = {3,1,2,3};
        int []nums2 = {3,3,3,2,2,4};
        int []nums3 = {3,3,3,2,2,2};
        System.out.println(p.solution(nums1));
        System.out.println(p.solution(nums2));
        System.out.println(p.solution(nums3));
    }
}
