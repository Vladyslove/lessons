class Stack<T> {
  private Object[] elements = new Object[4];
  private int size;

  public void push(T item) {
    // if (!isCapable()) { // the same lower
      if (isNotCapable()) {
      increaseCapacity();
    }
    elements[size++] = item;
  }

  // private boolean isCapable() { // the same lower
  private boolean isNotCapable() {
    // return size < elements.length; // the same lower
    return size >= elements.length;
  }

  private void increaseCapacity() {
    Object[] newElements = new Object[elements.length * 3/2 +1];
    System.arraycopy(elements, 0, newElements, 0, elements.length);
    elements = newElements;
  }

  public T pop() {
    size--;
    T elem = (T) elements[size];
    elements[size] = null;
    return elem;
  }
}
