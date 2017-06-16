public class Bag <T>{
  int size;
  Node first;

  public void add(T elem) {
    if (first == null) {
      first = new Node();
      first.value = elem;
    } else {
      Node node = first;
      first = new Node();
      first.next = node;
    }
    first.value = elem;
    size++;
  }

  public int size() {
    return size;

  }

  public boolean isEmpty() {
    return size == 0;
  }

  public String toString() {
    for (int i = 0; i < size ;i++ ) {

    }
  }

  private class Node { // INNER CLASS!!!!!!!!!!!!!
    T value;
    Node next;
  }
}
