import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.Iterator;

public class MainTest {
  private Queue<String> queue;

  @Before
    public void setUp() {
      queue = new Queue<>();
    }

  @Test
  public void test_simpleAddition() {
    queue.enqueue("10");

    assertThat(queue.dequeue(), is("10"));
  }

  @Test
  public void test_moreElementsAddition() {
    queue.enqueue("10");
    queue.enqueue("20");
    queue.enqueue("30");

    assertThat(queue.dequeue(), is("10"));
    assertThat(queue.dequeue(), is("20"));
    assertThat(queue.dequeue(), is("30"));
  }

  @Test
  public void test_size_whenOneElmeExist() {
    queue.enqueue("10");

    assertThat(queue.size(), is(1));
  }

  @Test
  public void test_size_whenThreesElmeExist() {
    queue.enqueue("10");
    queue.enqueue("20");
    queue.enqueue("30");

    assertThat(queue.size(), is(3));
  }

  @Test
  public void test_size_whenDequeueIsCalled() {
    queue.enqueue("10");
    queue.enqueue("20");

    queue.dequeue();

    assertThat(queue.size(), is(1));
  }

  @Test
  public void test_initialSize() {

    assertThat(queue.size(), is(0));
  }

  @Test
  public void test_multipleAdditions() {
    for (int i = 0; i < 20 ; i++ ) {
      //  CONVERT INTEGER to String
      // queue.enqueue(new Integer(i).toString()); // FIRST VARIANT
      queue.enqueue(Integer.toString(i)); // 2 VARIANT работает только потому, что есть
      // перегруженный статический метод toString()- не тот, который наследуется от Object
    }
    assertThat(queue.size(), is(20));
  }

  private class Queue<T> {
    private Object[] elements = new Object[10];
    private int putIndex;
    private int firstElemIndex;
    private int size;

    // METHOD BEFORE REFACTORIGN
    // public void enqueue(T item) {
    //   if (putIndex >= elements.length) {
    //     Object[] newElements = new Object[elements.length * 2];
    //     System.arraycopy(elements, 0, newElements, 0, elements.length);
    //     elements = newElements;
    //
    //   }
    //   elements[putIndex++] = item;
    //
    //   size++;
    //
    // }

    // AFTER REFACTORIGN
    public void enqueue(T item) {
      if (!isCapable()) {
        increaseCapacity();
      }
      elements[putIndex++] = item;

      size++;
    }

    private boolean isCapable() {
      return putIndex < elements.length;
    }

    private void increaseCapacity() {
      Object[] newElements = new Object[elements.length * 2];
      System.arraycopy(elements, 0, newElements, 0, elements.length);
      elements = newElements;
    }

    public T dequeue() {

      // PREVIOUS CODE OF METHOD
      // size--;
      //
      // return (T) elements[firstElemIndex++];

      // NEW CODE. we assign 'NULL' for elements, which doesn't habe link
      // on firstElemIndex. Therefore GC will remove this objects
      size--;
      T value = (T) elements[firstElemIndex];
      elements[firstElemIndex++] = null;

      return value;
    }

    public int size() {
      return size;
    }
  }
}
