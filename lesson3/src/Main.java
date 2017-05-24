public class Main {
  public static void main(String[] args) {
    System.out.println("Hello " + args[0]);

    int a = 1 + 1;
    a++;

    // 1 + 1
    // 1 - 1
    // 1 * 1
    // 1 / 1

    System.out.println(10 % 10);
    System.out.println(10 % 5);
    System.out.println(10 % 3);
    System.out.println(10 % 6);

    if (11 % 2 == 0) {
      System.out.println("1-true");
    } else {
      System.out.println("0-false");
    }

    if (20 % 1 == 0) {
      //
    } else if (true) {
      //
    } else {
      //
    }

    int i = 10;
    while (i > 0) {
      switch (i) {
        case 1: System.out.println("1"); break;
        case 2: System.out.println("2"); break;
        default: System.out.println("3");
      }
      i--;
    }

    do {
      System.out.println("Hello");
    } while (false);

    for (int ii = 0; ii < 10; ii += 2) {
      System.out.println("hello from " + ii);
    }

    int b = 0;
    b++;
    b += 1;

    for (int j = 0; j <= 10; j++) {
      if (isEven(j)) {
        System.out.println(j + " is even");
      } else {
        System.out.println(j + " is odd");
      }
    }

    // -----
    short s = 0;
    byte bt = 0;
    int i1 = 0;
    char c = '0';
    long l = 1l;
    float f = 0.0f;
    double d = 0.0;
    boolean bb = false;

  }

  public static boolean isEven(int num) {
    return num % 2 == 0;
  }
}
