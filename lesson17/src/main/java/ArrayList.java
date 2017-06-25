import java.util.Iterator;

public class ArrayList <T> implements List <T> {
  private int size;
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

  public void remove(int index) {
    elements[size--] = (T)elements[index];
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

    };
  }

  public ReverseIterator<T> reverseIterator() {
    return new ReverseIterator<T>() { // Anonim class
      int previousIndex = size - 1;
      public boolean hasPrevious() {
        return previousIndex != -1;
      }

      public T previous() {
        return (T) elements[previousIndex--];
      }

    };
  }
}

  // public RandomlyIterable<T> randomIterator() {
  //   return new RandomlyIterable<T>() {
  //     int randomIndex = ((int)(Math.random() * size));
  //     public boolean hasRandom() {
  //       return randomIndex != -1;
  //     }
  //
  //     public T randomNext() {
  //         return (T) elements[randomIndex];
  //       }
  //   };
  // }
