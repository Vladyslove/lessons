import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.Iterator;

public class MainTest {
  private List<Integer> list;

  @Before
  public void setUp() {
  list = new ArrayList<>();
    list.add(0);
    list.add(1);
    list.add(2);
}


  @Test
  public void testAdditionOfOneElement() {
    assertThat(list.get(0), is(0));
  }


  @Test
  public void testAdditionOfFewElements() {

    assertThat(list.get(0), is(0));
    assertThat(list.get(1), is(1));
    assertThat(list.get(2), is(2));
  }


  @Test
  public void testIteration() {

    int counter = 0;
    Iterator<Integer> iter = list.iterator();
    while (iter.hasNext()) {
      assertThat(iter.next(), is(counter));
      counter++;
    }
    Iterator<Integer> iter2 = list.iterator();
    while (iter2.hasNext()) {
      // iter2.remove(); // Whew! in the class we had java
      //.lang.UnsupportedOperationExeption at ...
      System.out.println(iter2.next());
    }
  }


  // @Ignore
  @Test
  public void testClearWithSize() {
    list.clear();

    assertThat(list.size(), is(0));
  }


  @Test
  public void testClearWithGet() {
    list.clear();

    assertThat(list.get(0), is(list.get(0)));
  }


  @Test
  public void testClear() {
    list.clear();

    assertThat(0, is(0));
  }


  @Test
  public void testIsEmpty() {
    list.clear();

    assertThat(list.isEmpty(), is(true));
  }


  @Test
  public void testSize() {

    assertThat(list.size(), is(3));
  }


  // @Ignore
  @Test
  public void testRemove() {

    list.remove(1);

    assertThat(list.get(1), is(2));
  }


  @Test
  public void testPrevious() {

    List<Integer> list = new ArrayList<>();
      list.add(1251);
      list.add(12);
      list.add(77);

    assertThat(list.reverseIterator().previous(), is(77));
  }


  @Test
  public void testPrevious2() {
    assertThat(list.reverseIterator().previous(), is(2));
  }


  @Test
  public void reverseIteratorOverallTest() {
    List<Integer> list = new ArrayList<>();
    list.add(44);
    list.add(27);
    list.add(3);

    int sum = 0;
    ReverseIterator<Integer> revIter = list.reverseIterator();
    while(revIter.hasPrevious()) {
      sum += revIter.previous();
    }

    assertThat(sum, is(3 + 27 + 44));
  }


  @Test
  public void testhasPreviousWithClear() {
    list.clear();
    assertThat(list.reverseIterator().hasPrevious(), is(false));

  }

  @Test
  public void testhasPreviousWithAdd() {
    assertThat(list.reverseIterator().hasPrevious(), is(true));

  }

  @Test
  public void testPreviousIterator() {

    int counter = list.size()-1;
    ReverseIterator<Integer> reverIter = list.reverseIterator();
    while (reverIter.hasPrevious()) {
      assertThat(reverIter.previous(), is(counter));
      counter--;
    }
    ReverseIterator<Integer> iter2 = list.reverseIterator();
    while (iter2.hasPrevious()) {
      System.out.println(iter2.previous());
    }
  }

  @Test
  public void testNext() {

    assertThat(list.iterator().next(), is(0));

  }

  @Test
  public void testHasNext() {
    list.clear();

    assertThat(list.iterator().hasNext(), is(false));

  }

  // @Ignore
  // @Test
  // public void testRandomIterator() {
  //
  //   assertThat(list.randomIterator().randomNext(), anyOf(is(0), is(1), is(2) ));
  // }

}
