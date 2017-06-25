import java.util.Iterator;

public interface List<T> {
  void add(T elem);

  T get(int index);

  void clear();

  boolean isEmpty();

  int size();

  Iterator<T> iterator();
}
