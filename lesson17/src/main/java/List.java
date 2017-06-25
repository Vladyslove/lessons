import java.util.Iterator;

public interface List<T> {
  void add(T elem);

  T get(int index);

  void clear();

  boolean isEmpty();

  int size();

  void remove(int index);

  Iterator<T> iterator();

  ReverseIterator<T> reverseIterator();

  // RandomlyIterable<T> randomlyIterable();
}
