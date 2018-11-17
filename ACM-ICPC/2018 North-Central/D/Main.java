import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int airportNum = sc.nextInt();
    int dayNum = sc.nextInt();
    int flighNum = sc.nextInt();

    int[][] flights = new int[flighNum][4];
    for (int i = 0; i < flighNum; i ++) {
      flights[i][0] = sc.nextInt() - 1;
      flights[i][1] = sc.nextInt() - 1;
      flights[i][2] = sc.nextInt() - 1;
      flights[i][3] = sc.nextInt();
    }

    int[][] customers = new int[airportNum][dayNum];
    for (int i = 0; i < airportNum * dayNum; i ++) {
      int airport = sc.nextInt();
      int day = sc.nextInt();
      int num = sc.nextInt();
      customers[airport - 1][day - 1] = num;
    }

    for (int airport = 0; airport < airportNum; airport ++) {
      int sum = 0;
      for (int day = 0; day < dayNum; day ++) {
        for (int i = 0; i < flighNum; i ++) {
          if (flights[i][0] == airport && flights[i][2] == day)
            sum -= flights[i][3];
          else if (flights[i][1] == airport && flights[i][2] == day - 1)
            sum += flights[i][3];
        }
        sum += customers[airport][day];
        //System.out.println(airport + " " + day + " " + sum);
        if (sum < 0) {
          System.out.println("suboptimal");
          return;
        }
      }
    }
    System.out.println("optimal");
  }
}
