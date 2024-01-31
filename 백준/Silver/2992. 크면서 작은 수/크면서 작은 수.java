import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> temp;
    static int arr [];
    static int x;
    static int ans = Integer.MAX_VALUE;
    static boolean isVisted [];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());
        temp = new ArrayList<>();
        int t = x;
        while (t>0){
            temp.add(t%10);
            t/=10;
        }
        arr = new int [temp.size()];
        isVisted = new boolean[temp.size()];
        dfs(0);
        if (ans == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(ans);
        }

    }
    public static void dfs(int depth){
        if(depth == temp.size()){
            String s ="";
            for(int i : arr){
                s += i;
            }
            if(Integer.parseInt(s)>x){
                ans = Math.min(ans,Integer.parseInt(s));
            }
        }
        for(int i = 0; i<temp.size(); i++){
            if(!isVisted[i]){
                isVisted[i] = true;
                arr[depth] = temp.get(i);
                dfs(depth+1);
                isVisted[i] = false;
            }
        }
    }
}
