import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

class Solution {
        static List<String> arr[];
        static HashSet<HashSet<String>> hSet;

        public int solution(String[] user_id, String[] banned_id) {
            arr = new ArrayList[banned_id.length];
            hSet = new HashSet<>();
            for (int i = 0; i < banned_id.length; i++) {
                arr[i] = new ArrayList<String>();
            }
            int index = 0;
            for (String b : banned_id) {
                for (String u : user_id) {
                    if (u.length() != b.length())
                        continue;
                    if (check(b, u)) {
                        arr[index].add(u);
                    }
                }
                index++;
            }
            dfs(0, banned_id.length, new HashSet<String>());
            return hSet.size();
        }

        public void dfs(int depth, int finish, HashSet<String> h) {
            if (depth == finish) {
                hSet.add(new HashSet<String>(h));
                return;
            }

            for (int i = 0; i < arr[depth].size(); i++) {
                if (h.add(arr[depth].get(i))) {
                    dfs(depth + 1, finish, h);
                    h.remove(arr[depth].get(i));
                }

            }
        }

        public boolean check(String s1, String s2) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i) && s1.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
    }