import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int ans = 0;
    static int[] list = new int[1001];
    static int[] score = {1,5,10,50};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        back(0, 0, 0, n);
        System.out.println(ans);
    }

    static void back(int index, int total, int depth, int end) {
        if (depth == end) {
            if (list[total] == 0){
                list[total] = 1;
                ans += 1;
            }
            return;
        }
        for (int i = index; i < 4; i++) {
            back(i, total+score[i],depth +1, end);
        }
    }
}