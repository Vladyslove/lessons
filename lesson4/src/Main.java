public class Main {
static int a;
static char c;
static double d;
static float f = 1.0f;
static long l =1l;
static Стринг полеСтринг;

  public static void main(String[] args) {
    System.out.println("Wow");

    System.out.println(a);
    System.out.println(c);
    System.out.println(l);
    System.out.println(d);
    System.out.println(f);

    double localD= 100.00d;
    System.out.println(localD);

    String str = new String("Hello string");
    String str2 = "foo bar";
    String строка = "ололо";
    Стринг строка2 = new Стринг();

    System.out.println(str);
    System.out.println(str2);
    System.out.println(строка);

    Стринг стринг = null;

    System.out.println(стринг);
    System.out.println(полеСтринг);

    // Main main = null;
    // main.main(new String[0]);

    Стринг.foo(); // in works despite the null reference
    // because it's asstatic method
    // стринг.bar(); // in throws NPE (NullPointerException)

    System.out.println(Стринг.classVar);

    стринг = new Стринг();
    стринг.bar();
    System.out.println(стринг.instanceVar);

    Counter counter = new Counter();
    System.out.println(counter.a);
    System.out.println(counter.b);

    for (int j =0; j < 100 ; j++ ) {
      new Counter(); // create object in heap

    }

      System.out.println(counter.a);
      System.out.println(counter.b);
    // стринг.foo();
                    // relate ot HW4
                    // for (int i = 1; i<=2 ;i++ ) {
                    //     Main.outputStr();
                    // }

    }   // RELATED TO main

                    // relate ot HW4
                    //   static void outputStr () {
                    //   System.out.println("Is it right?");
                    // }

}     // RELATED TO GENERAL

  class Стринг {
    int instanceVar;
    static int classVar;
    static void foo() {
        System.out.println("foo");
    }

    void bar() {
        System.out.println("bar");
    }

  }

  class Counter {
    static int a = 0;
           int b = 0;

    Counter () {
      a++;
      b++;
    }
  }
