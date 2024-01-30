import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int studentNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            int male = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            //남자
            if (male == 1) {
                int temp = num;
                while (temp < n + 1) {
                    if (arr[temp] == 0) arr[temp] = 1;
                    else arr[temp] = 0;
                    temp += num;
                }
            }//여자
            else {

                if (arr[num] == 0) arr[num] = 1;
                else arr[num] = 0;

                for (int j = 1; j < n; j++) {
                    if ((num - j) < 1 || (num + j) > (n )) break;
                    if (arr[num - j] != arr[num + j]) break;
                    if (arr[num - j] == 0) {
                        arr[num - j] = 1;
                        arr[num + j] = 1;
                    } else {
                        arr[num - j] = 0;
                        arr[num + j] = 0;
                    }
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (i == n){
                System.out.print(arr[i]);
            }else if(i==20 || i==40 || i==60||i==80){
                System.out.println(arr[i]);
            }
            else {
                System.out.print(arr[i] + " ");
            }

        }
    }
}
