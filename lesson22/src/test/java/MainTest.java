import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class MainTest {
  @Test
  public void apiExample() {
    Map<Integer, String> map = new Map<>();

    map.put(100, "hundred");
    // assertEquals(expected, given);
    // assertEquals("hundred", map.get(100));
    assertThat(map.get(100), is("hundred"));
    assertThat(map.get(90), is(nullValue()));
  }

  @Test
  public void stringItegerMapExamle() {
    Map<String, Integer> map = new Map<>();

    map.put("one", 1);

    assertThat(map.get("one"), is(1));
  }

  @Test
  public void myClassAsAKey() {
    class Foo{}
    Map<Foo, String> map = new Map<>();
    Foo key = new Foo();

    map.put(key, "foo");

    assertThat(map.get(key), is("foo"));
  }

  @Test
  public void sameKeysExample() {
    Map<Integer, String> map = new Map<>();

    map.put(100, "hundred");
    map.put(100, "not-hundred");

    assertThat(map.get(100), is("not-hundred"));
    // assertThat(map.get(100), is("hundred"));
  }

  class Map<K, V> {
    private Node[] values = new Node[10];

    private class Node<K, V> {
      K key;
      V value;
      Node<K, V> next;

    }

    public void put(K key, V value) {
      Node<K, V> newNode = new Node<>();
      newNode.key = key;
      newNode.value = value;
      // values[getIndex(key)] = value;
      if (values[getIndex(key)] == null) {
        values[getIndex(key)] = newNode;
      } else {
        Node<K,V> node = values[getIndex(key)];
        do {
          if (node.key == key) {
            node.value = value;
            return;
          }
          node = node.next;
          if (node == null) break;
        }
        while (node.next != null);
        node = newNode;
      }
    }

    private int getIndex(K key) {
      return key.hashCode() % values.length;
    }

    public V get(K key) {
      // return (V) values[getIndex(key)].value;
      Node<K,V> node = values[getIndex(key)];
      if (node != null) {
        do {
          if (node.key == key) {
            return node.value;
          }
          node = node.next;
          if (node == null) break;
        } while (node.next != null);
      }
      return null;
    }
  }
}
