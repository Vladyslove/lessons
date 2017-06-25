import java.util.Iterator;

public class ArrayList <T> implements List <T> {
  private int size = 0;
  private Object[] elements = new Object[10];

  public void add(T elem) {
    elements[size++] = elem;
  }

  public T get(int index) {
    return (T)elements[index]; // we must cast Object to T
  }

  public void clear() {
    elements = new Object[10];
    size = 0;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public Iterator <T> iterator() {
    return new Iterator<T>() { // Anonim class
      int currentIndex;
      public boolean hasNext() {
        return currentIndex != size;
      }

      public T next() {
        return (T) elements[currentIndex++];
      }

      public void remove() {

      }
    };
  }
}

// The same code with commentaries
public class ArrayList <T> implements List <T> {
  //create Array and local variable int size
  private int size = 0; // RIGHT !!! or just int size;
  // T[] elements = new T[10]; // error: generic array creation
  private Object[] elements = new Object[10];

  public void add(T elem) {
    elements[size++] = elem; // new member of array
    // (second + in []) EQUALS elem(10), not somethimg else!
  }

  public T get(int index) {
    // must return value of итого элемента
    // return elements.[elem]; - WRONG !!!  we add value (10), but
    // ordinal(index) of array(elements)
    return (T)elements[index]; // we must cast Object to T
  // java:17: error: incompatible types: Object cannot be converted to T
  }

  public void clear() {
    // elements[size] = 0;
    elements = new Object[10];
    size = 0;
  }

  public boolean isEmpty() {
    return size == 0; // EQUALS (look lower)
    // return size() == 0
    // created in the beginnig of class
    // private int variable size (собственно, размер of array) EQUALS 0
  }

  public int size() {
    // return elements[size];
    return size;
  }
  public Iterator <T> iterator() {
    return new Iterator<T>() {
      int currentIndex;
      public boolean hasNext() {
        return currentIndex != size;
      }

      public T next() {
        return (T) elements[currentIndex++];
      }

      public void remove() {

      }

    };
  }
}
