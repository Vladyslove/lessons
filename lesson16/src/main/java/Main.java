
public class Main {
  public static void main(String[]  args) {
      System.out.println("Lesson 16");

      Bag <Integer> bag = new Bag();
      for (int i = 0;  i < 10; i++ ) {
        bag.add(i + 1);
        bag.add(1.0);
      }
      System.out.println(bag);
      // System.out.println(bag.size);

      // Node node = new Node(-1);
      // node.next = new Node(-1);

    // создание instance of INNER CLASS
    // Bag.Node node1 = new Bag().new Node(1);
    // Bag.Node node1 = bag.new Node(1);

    System.out.println(bag.hasNext());
    while (bag.hasNext()) {
      System.out.println(bag.next());

    }
  }
}
