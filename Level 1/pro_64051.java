import java.util.ArrayList;
import java.util.Stack;

public class pro_64051{
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int m:moves){
            for(int i = 0; i < board[0].length; i++){
                if(board[i][m-1]!=0){
                    if(board[i][m-1]==stack.peek()){
                        stack.pop();
                        answer += 2;
                    }else{
                        stack.push(board[i][m-1]);
                    }
                    board[i][m-1] = 0;
                    break;
                }
            }
        }
        
        
        return answer;
    }

    public static void main(String[] args) {
        pro_64051 p = new pro_64051();
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        
        System.out.println(p.solution(board, moves));
    };
        
}