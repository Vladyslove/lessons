import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
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

  private class Node { // Inner class
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
        Item value = current.value;
        current = current.next;
        // Item value = current.value.next;

        return value;

      }

      };
  }
}
