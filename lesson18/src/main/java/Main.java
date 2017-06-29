import java.util.Iterator;

import inner.Enclosing;

import generics.Box;

public class Main {
  public static void main(String[]  args) {
      System.out.println(("Lesson 18"));
      Bag <Integer> bag = new Bag<>();
      bag.add(10);
      bag.add(20);
      bag.add(20);
      bag.add(10);
      bag.add(0);

      Iterator<Integer> iter = bag.iterator();
      while(iter.hasNext()) {
        System.out.println(iter.next());
      }
      for (Integer bagElem : bag) {
        System.out.println(bagElem);
      }
      System.out.println("\n\n\n----------------");
      //------------
      Enclosing.InnerStatic eSt = new Enclosing.InnerStatic();
      eSt.foo();

      Enclosing enc = new Enclosing();
      Enclosing.Inner eNonSt = enc.new Inner();
      eNonSt.foo();

      Enclosing.Inner eNonSt2 = new Enclosing().new Inner();
      eNonSt2.foo();

      new Enclosing.Nothing() {
        public void doNothing() {}
      };

      new Enclosing.Nothing2() {
        public void doNothing() {}
      };

      class Wow implements Enclosing.Nothing {
        void lol() {
          System.out.println("Java rules");
        }
        public void doNothing() {}
      }

      Wow wow = new Wow();
      wow.lol();

      //----------
      Box<Integer> box = new Box<>();
      box.set(10);
      int i = box.get();
  }
}
