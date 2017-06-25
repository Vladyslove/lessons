public class Bag<Item>  {
  private Node firstNode;
  private int size = 0;

// 1-10 desc
  public void add(Item item) {
    if (firstNode == null) {
      firstNode = new Node(item);
    } else {
      Node node = firstNode;
      while (node.next != null) {
        node = node.next;
      }
      node.next = new Node(item);
    }
      size++;
  }
  // по сути node здесь (и в методе toString) является temp -
  // для лучшего понимание варианта с обратным порядком наполнения Bag

  // 10-1 ОБРАТНЫЙ ПОРЯДОК НАПОЛНЕНИЯ
  // public void add(Item item) {
  //   if (firstNode == null) {
  //     firstNode = new Node(item);
  //   } else {
  //     Node node = new Node(item);
  //
  //     Node temp = firstNode;
  //     firstNode = node;
  //     node.next = temp;

      //SWAP method
      // private static void nodeSwap (Node a, Node b) {
      //   int c = a. value/next;
      //   a.value/next = b.value/next;
      //   b.value/next = c;
      // }
      // int a = 1; firstNode
      // int b = 2; newNode
      // int c = a; // c == 1 temp = firstNode
      // a = b; // a == 2 firstNode = node;
      // b = c; // b == 1 node = temp
  //   }
  //     size++;
  // }

  public String toString() {
    String result = "[";
    Node node = firstNode;
    for (int i = size;  i > 0; i-- ) {
      result += node.value + " ";
      node = node.next;
    }
    return result + "]";
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  private class Node {
    Node(Item value) {
      this.value = value;
    }

    Item value;
    Node next;
  }

  public Iterator<Item> iterator() {
    return new Iterator<Item>()
                            { // ANONIM CLASS
      private Node current = firstNode;

      public boolean hasNext() {
        return current != null;
      }

      public Item next() {
        // Item value = current.value;
        // current = current.next;
        Item value = current.value.next;

        return value;

      }

      };
  }
}


  interface Iterator <Item> {
    boolean hasNext();
    Item next();
  }
