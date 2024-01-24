import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static int[] mDate(int year) {
    int[] monthDay = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
      monthDay[1] = 29;
    }
    return monthDay;
  }

  public static int dDay(int year, int month, int day) {
    int date = 0;
    for (int i = 1; i < year; i++) {
      int monthDay[] = mDate(i);
      for (int j = 0; j < 12; j++) {
        date += monthDay[j];
      }
    }
    int monthDay[] = mDate(year);
    for (int i = 0; i < month - 1; i++) {
      date += monthDay[i];
    }
    date += day;
    return date;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int year = Integer.parseInt(st.nextToken());
    int month = Integer.parseInt(st.nextToken());
    int day = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int Dyear = Integer.parseInt(st.nextToken());
    int Dmonth = Integer.parseInt(st.nextToken());
    int Dday = Integer.parseInt(st.nextToken());
    String ans = "D-";
    if (Dyear - year > 1000 || (Dyear - year == 1000 && Dmonth > month)
        || (Dyear - year == 1000 && Dmonth == month && Dday >= day)) {
      System.out.println("gg");
      System.exit(0);
    }
    System.out.println(ans + String.valueOf(dDay(Dyear, Dmonth, Dday) - dDay(year, month, day)));

  }
}
