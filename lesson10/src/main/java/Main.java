import stuff.base.Engineer;
import stuff.QA;
import stuff.Developer;
import stuff.base.SEX;


public class Main {
  public static void main(String[]  args) {
      Developer dev = new Developer("John Doe", 21);
      Developer dev2 = new Developer("John Goe", 221, SEX.MALE);
      QA qa = new QA("Jane Doe", 32);


// qa.name = "Vasya"; //Encapsulation!!! for avoid this situations
// namely: anyone can chage important things: fields, methods etc
// CREATE private FIELDS CREATE private FIELDS CREATE private FIELDS
// CREATE private FIELDS CREATE private FIELDS CREATE private FIELDS
// CREATE private FIELDS CREATE private FIELDS CREATE private FIELDS

      dev.sayHello();
      dev2.sayHello();
      qa.sayHello();

      Engineer.staticMethod();
      Developer.staticMethod();

      System.out.println(Math.PI);
      // System.out.println(qa.eqauls(qa));
  }
}
