package inner;

public class Enclosing {
  private static int sInt = 10;
  private int nonSInt = 10;

  private static void esFoo() {
    System.out.println("esFoo");
  }

  private void eFoo() {
    System.out.println("eFoo");
  }

  public static class InnerStatic {
    private static int innerStaticInt = 20;
    public void foo() {
      System.out.println("InnerStatic: foo");
      System.out.println("InnerStatic:Sint " + sInt);
      // System.out.println("InnerStatic:nonSInt " + nonSInt);
      // won't compile non-static variable nonSInt
      // cannot be referenced from a static context

      esFoo();
      // eFoo();// won't compile  non-static method eFoo()
      // cannot be referenced from a static context

      System.out.println("InnerStatic: innerStaticInt " +innerStaticInt);
    }
  }

    public class Inner {
      private final static int innerStaticInt = 20;
      public void foo() {
        System.out.println("Inner:foo");
          System.out.println("Inner:Sint " + sInt);
          System.out.println("Inner:nonSIn  t " + nonSInt);

      esFoo();
      Enclosing.this.eFoo();  // this добавляется неявно
      System.out.println("Enclosing nonSInt: " + nonSInt);
      System.out.println("Inner: innerStaticInt " +innerStaticInt);
    }

    public void eFoo() {
      System.out.println("Inner:eFoo");
    }
  }
  public static interface Nothing {
      void doNothing();
  }

  public interface Nothing2 {
      void doNothing();
  }
}
