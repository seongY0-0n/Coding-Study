class Solution {
    public boolean canGo(String[] park, int op, int n, int[] cur){
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int x = cur[1];
        int y = cur[0];
        for(int i = 0; i < n; i++){
            int nx = x + dx[op];
            int ny = y + dy[op];
            if(nx < 0 || ny < 0 || nx >= park[0].length() || ny >= park.length || park[ny].charAt(nx)=='X'){
                return false;
            }
            x = nx;
            y = ny;
        }
        
        return true;
    }
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int[] cur = {};
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j<park[i].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    cur = new int[] {i, j};
                }
            }
        }
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        
        for(String r : routes){
            char op = r.charAt(0);
            int n = r.charAt(2) -48;
            switch(op){
                case 'E':
                    if(canGo(park,0,n,cur)){
                        for(int i = 0; i < n; i++){
                            cur[0] += dy[0];
                            cur[1] += dx[0];
                         }
                    }
                    break;
                case 'S':
                    if(canGo(park,1,n,cur)){
                        for(int i = 0; i < n; i++){
                            cur[0] += dy[1];
                            cur[1] += dx[1];
                         }
                    }
                    break;
                case 'W':
                    if(canGo(park,2,n,cur)){
                        for(int i = 0; i < n; i++){
                            cur[0] += dy[2];
                            cur[1] += dx[2];
                         }
                    }
                    break;
                case 'N':
                    if(canGo(park,3,n,cur)){
                        for(int i = 0; i < n; i++){
                            cur[0] += dy[3];
                            cur[1] += dx[3];
                         }
                    }
                    break;
            }
        }
        answer = cur;
        return answer;
    }
    
}