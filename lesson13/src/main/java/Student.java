public class Student implements Comparable{
  private String name;
  private int age;

  public Student(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String toString() {
    return String.format("Name: %s, age: %d", name, age);
  }

  public int compareTo(Object o) {
    Integer thatAge = (Integer) o;

    return this.age - thatAge;
  }
}
