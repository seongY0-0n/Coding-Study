import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> card = new LinkedList<>();
        for(int i = 1; i<=N;i++){
            card.add(i);
        }

        while(true){
            if(card.size()==1) {
                System.out.println(card.poll());
                break;
            }
            card.poll();
            if(card.size()==1) {
                System.out.println(card.poll());
                break;
            }
            card.add(card.poll());
        }

    }
}
