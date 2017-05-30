package stuff;
import stuff.base.Engineer;
import stuff.base.SEX;

public class Developer extends Engineer {
  public Developer (String name, int age) { // Construcor
  this(name, age, SEX.NOT_DEFINED);
  }

  public Developer (String name, int age, SEX sex) { // Construcor
    super(name, age, sex);
  }

  public static void staticMethod() {
    System.out.println("Yes I'm a static method in Developer");
  }

  // public void sayHello() { cannot be overriden if
  // method in superclass is final
  //
  // }
}
