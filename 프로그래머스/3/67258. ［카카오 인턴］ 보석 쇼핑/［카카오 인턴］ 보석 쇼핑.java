import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
class Solution {
    public int[] solution(String[] gems) {
       int[] answer = new int[2];

        Set<String> gemsSet = new HashSet<>(Arrays.asList(gems));
        int gemsSize = gemsSet.size();
        HashMap<String, Integer> hm = new HashMap<>();
        int left = 0;
        int right = 0;
        int index = 0;
        int gemsIdx[] = new int[gemsSize];
        for (String s : gemsSet) {
            hm.put(s, index++);
        }
        gemsIdx[hm.get(gems[0])]++;
        int total = 1;
        if (total == gemsSize) {
            answer[0] = 1;
            answer[1] = 1;
            return answer;
        }
        int len = 1;
        int successLen = Integer.MAX_VALUE;
        while (true) {
            if (total < gemsSize) {
                right++;
                if (gemsIdx[hm.get(gems[right])] == 0) {
                    total++;
                }
                gemsIdx[hm.get(gems[right])]++;
                len++;
            } else {
                if (successLen > len) {
                    successLen = len;
                    answer[0] = left;
                    answer[1] = right;
                }

                if (gemsIdx[hm.get(gems[left])] == 1) {
                    total--;
                }
                gemsIdx[hm.get(gems[left])]--;
                len--;
                left++;
            }
            if (right == gems.length - 1 && total < gemsSize)
                break;
        }
        answer[0]++;
        answer[1]++;
        return answer;
    }
}