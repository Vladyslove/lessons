package stuff.base;

public class Engineer {
  private String name;
  private int age;
  private SEX sex;

  // public static final String DEFAULT_SEX = "-";   //CONSTANT MUST BE INITIALIZED
  //CONSTANT MUST BE INITIALIZED

  // public static final String DEFAULT_SEX = get();
  //
  // private static String get() {
  //   return  "-";
  // }

  // public Engineer () {}

  public Engineer (String name, int age, SEX sex) { // Construcor
    this.name = name; // initialization of Construcor
    this.age = age;  // initialization of Construcor
    this.sex = sex;  // initialization of Construcor
  }

  // public Engineer (/*String name, int age*/) {
  //     this.name = "name";
  //     this.age = 10;
  // }

  // public Engeneer (/*String name, int age*/) {
  //     this.name = name;
  //     this.age = age;
  // }

  /* final */ public void sayHello() { // final method cannot be overriden
    System.out.println("Hello from " + name + " {" + sex + "} " + " [" + getClass().getName()+ "]");
  }

  private   /* final */ void foo() {} // don't have sence private method is
  // already final

  public static void staticMethod() {
    System.out.println("Yes I'm a static method");
  }

}
