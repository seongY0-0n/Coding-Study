
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(5);
        arr.add(10);
        arr.add(50);
        Set<Integer> hset = new HashSet<>();
        int[] roma = { 1, 5, 10, 50 };
        for (int i = 0; i < N - 1; i++) {
            Set<Integer> temp = new HashSet<>();
            for (int j = 0; j < arr.size(); j++) {
                for (int r : roma) {
                    temp.add(arr.get(j) + r);
                }
            }
            arr = new ArrayList<>(temp);
        }

        System.out.println(arr.size());

    }
}
