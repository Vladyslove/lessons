package stuff;

import stuff.base.Engineer;
import stuff.base.SEX;

public class QA extends Engineer {

  public QA (String name, int age) { // Construcor
      super(name, age, SEX.NOT_DEFINED);
      // System.out.println(name);
  }

  // @Override
  // public void sayHello() {
  //   System.out.println("Hello from QA");
  // }
}
