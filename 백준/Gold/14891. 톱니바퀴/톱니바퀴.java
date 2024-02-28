import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c1[] = new int[8];
        int c2[] = new int[8];
        int c3[] = new int[8];
        int c4[] = new int[8];
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();
        String s4 = br.readLine();
        for (int i = 0; i < 8; i++) {
            c1[i] = s1.charAt(i) - '0';
            c2[i] = s2.charAt(i) - '0';
            c3[i] = s3.charAt(i) - '0';
            c4[i] = s4.charAt(i) - '0';
        }
        int k = Integer.parseInt(br.readLine());
        int order[][] = new int[k][2];
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            order[i][0] = Integer.parseInt(st.nextToken());
            order[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int o[] : order) {
            switch (o[0]) {
                case 1:
                    if (c1[2] == c2[6]) {
                        cycle(o[1], c1);
                    } else {
                        if (c2[2] == c3[6]) {
                            cycle(o[1], c1);
                            cycle(o[1] * -1, c2);
                        } else {
                            if (c3[2] == c4[6]) {
                                cycle(o[1], c1);
                                cycle(o[1] * -1, c2);
                                cycle(o[1], c3);
                            } else {
                                cycle(o[1], c1);
                                cycle(o[1] * -1, c2);
                                cycle(o[1], c3);
                                cycle(o[1] * -1, c4);
                            }
                        }
                    }
                    break;
                case 2:
                    if (c1[2] != c2[6])
                        cycle(o[1] * -1, c1);

                    if (c2[2] == c3[6]) {
                        cycle(o[1], c2);
                    } else {
                        if (c3[2] == c4[6]) {
                            cycle(o[1], c2);
                            cycle(o[1] * -1, c3);
                        } else {
                            cycle(o[1], c2);
                            cycle(o[1] * -1, c3);
                            cycle(o[1], c4);
                        }
                    }
                    break;
                case 3:
                    if (c3[2] != c4[6])
                        cycle(o[1] * -1, c4);

                    if (c3[6] == c2[2]) {
                        cycle(o[1], c3);
                    } else {
                        if (c2[6] == c1[2]) {
                            cycle(o[1], c3);
                            cycle(o[1] * -1, c2);
                        } else {
                            cycle(o[1], c3);
                            cycle(o[1] * -1, c2);
                            cycle(o[1], c1);
                        }
                    }
                    break;
                case 4:
                    if (c3[2] == c4[6]) {
                        cycle(o[1], c4);
                    } else {
                        if (c3[6] == c2[2]) {
                            cycle(o[1], c4);
                            cycle(o[1] * -1, c3);
                        } else {
                            if (c2[6] == c1[2]) {
                                cycle(o[1], c4);
                                cycle(o[1] * -1, c3);
                                cycle(o[1], c2);
                            } else {
                                cycle(o[1], c4);
                                cycle(o[1] * -1, c3);
                                cycle(o[1], c2);
                                cycle(o[1] * -1, c1);
                            }
                        }
                    }
                    break;
            }
        }
        System.out.println(c1[0] + (c2[0] * 2) + (c3[0] * 4) + (c4[0] * 8));
    }

    public static void cycle(int i, int c[]) {
        if (i == 1) {
            int temp = c[7];
            for (int j = 7; j > 0; j--) {
                c[j] = c[j - 1];
            }
            c[0] = temp;
        } else {
            int temp = c[0];
            for (int j = 0; j < 7; j++) {
                c[j] = c[j + 1];
            }
            c[7] = temp;
        }
    }
}
