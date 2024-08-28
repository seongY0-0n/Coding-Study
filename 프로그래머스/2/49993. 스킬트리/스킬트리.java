class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String s : skill_trees){
            String temp = "";
            for(char c: s.toCharArray()){
                if(skill.indexOf(c)!=-1){
                    temp+=c;
                }
    
            }
            if(skill.indexOf(temp)==0){
                answer++;
            }
   
        }
        return answer;
    }
}