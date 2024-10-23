// You can experiment here, it won’t be checked

import java.util.Scanner;

public class Task {
  public static void main(String[] args) {
    // put your code here
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    int result = operateNumber(n);
    System.out.println(result);
  }

  private static int operateNumber(int n) {
    //increment n by 1, then decrement n by 2, then double the resulting value of n.
    n++;
    n -= 2;
    n *= 2;
    return n;
  }
}
