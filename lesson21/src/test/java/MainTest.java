import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import java.util.Arrays;
import java.util.Comparator;

public class MainTest {
  @Test
  public void testNothing() {
      PriorityQueue<Integer> queue = new PriorityQueue<>();
      queue.insert(10);
      queue.insert(30);
      queue.insert(40);
      queue.insert(20);
      queue.insert(15);

      assertThat(queue.max(), is(40));
  }

  // @Ignore
  @Test
  public void testNothing2() {
      PriorityQueue<Integer> queue = new PriorityQueue<>();
      queue.insert(10);
      queue.insert(30);
      queue.insert(40);
      queue.insert(20);
      queue.insert(15);

      assertThat(queue.max(), is(40));
      assertThat(queue.max(), is(30));
      assertThat(queue.max(), is(20));
      assertThat(queue.max(), is(15));
      assertThat(queue.max(), is(10));
  }

  @Test
  public void test_withString() {
      PriorityQueue<String> queue = new PriorityQueue<>();
      queue.insert("aa");
      queue.insert("cc");
      queue.insert("bb");

      assertThat(queue.max(), is("cc"));
      assertThat(queue.max(), is("bb"));
      assertThat(queue.max(), is("aa"));
  }

  @Test
  public void test_withComparator() {
    PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
      public int compare(Integer a, Integer b) {
        return -1 * (a - b);
      }
    });

    queue.insert(10);
    queue.insert(30);
    queue.insert(40);
    queue.insert(20);
    queue.insert(15);

    assertThat(queue.max(), is(10));
    assertThat(queue.max(), is(15));
    assertThat(queue.max(), is(20));
    assertThat(queue.max(), is(30));
    assertThat(queue.max(), is(40));
  }
}

class PriorityQueue<T extends Comparable> {
  private Object[] elements = new Object[8];
  private int size;
  private Comparator<T> comparator;


  public PriorityQueue() {};

  public PriorityQueue(Comparator comparator) {
    this.comparator = comparator;
  }

  public void insert(T item) {
    if (isNotCapable()) {
      elements = Arrays.copyOf(elements, elements.length * 2);
    }
    elements[++size] = item;

    swimUp(size);
  }

  private void swimUp(int k) {
    while(k > 1 && lessOrEqual(k / 2, k)) {
      exchange(k, k / 2);
      k = k / 2;
    }
  }

  private boolean lessOrEqual(int n, int m) {
    if (comparator == null) {
      return ((Comparable)elements[n]).compareTo(elements[m]) < 1;
    } else {
      return (comparator.compare((T) elements[n], (T) elements[m])) < 1;
    }
  }

  private boolean isNotCapable() {
    return elements.length == size;
  }

  private void exchange(int n, int m) {
    T t = (T) elements[n];
    elements[n] = elements[m];
    elements[m] = t;
  }

  public T max() {
    T value = (T) elements[1];

    exchange(1, size);
    elements[size] = null;
    size--;

    sink(1);

    return value;
  }
    private void sink(int k) {
      while (k * 2 <= size) {
        int childK = k * 2;

        if (childK < size && lessOrEqual(childK,  childK + 1)) {
          childK++;
        }

        if (lessOrEqual(childK, k)) {
        // or line below
        // if (!lessOrEqual(k, childK)) {

          break;
        }

        exchange(k, childK);
        k = childK;
      }
    }
  }
