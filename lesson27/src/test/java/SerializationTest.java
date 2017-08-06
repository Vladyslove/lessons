import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

public class SerializationTest {

  @Test
  public void serialization() throws Exception {
    ObjectOutputStream out = new ObjectOutputStream(
            new FileOutputStream("items.ser")
    );

    Item item = new Item();
    item.name = "Apple";
    item.description = "Fruit";
    item.price = 0.99;
    item.isForSale = true;

    out.writeObject(item);
    out.close();

    ObjectInputStream in = new ObjectInputStream(
            new FileInputStream("items.ser")
    );

    Item storedItem = (Item)in.readObject();
    Item storedItem2 = (Item)in.readObject();
    in.close();

    assertThat(storedItem.name, is("Apple"));
    assertThat(storedItem.description, is("Fruit"));
    assertThat(storedItem.price, is(0.99));
    assertThat(storedItem.isForSale, is(true));

    assertThat(storedItem2.name, is("Apple"));
    assertThat(storedItem2.description, is("Fruit"));
    assertThat(storedItem2.price, is(0.99));
    assertThat(storedItem2.isForSale, is(true));
  }

    private static class Item implements Serializable{
      String description;
      double price;
      boolean isForSale;
      String name;

      @Override
      public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", version=" + price +
                ", isForSale=" + isForSale +
                ", payload='" + name + '\'' +
                '}';
      }
    }


    private static class Student extends Human /*implements Serializable*/ {
//        private static final long serialVersionUID = 234213522342351346L;
        private /*transient*/ double score; // In we don't want serialize this field
        private int age;

        public Student() {
        }

        public Student(String name, double score, int age) {
            super(name, age);
            this.score = score;
        }

        /*private void writeObject(ObjectOutputStream stream) throws IOException {
            //stream.writeDouble(score);
            stream.defaultWriteObject();
        }
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            //score = stream.readDouble();
        }*/

        @Override
        public String toString() {
            return "Student{" +
                    "score=" + score +
                    ", name='" + name +
                    ", age='" + age + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Student student = (Student) o;

            return Double.compare(student.score, score) == 0
                    && Integer.compare(student.age, age) == 0
                    && student.name.equals(name);
        }

    }

    private static class Human implements Serializable {
        protected String name;
        protected int age;

        public Human() {
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

    }

    @Test
    public void serializationStudent() throws Exception {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("John Doe", 100.00, 25);
        Student student2 = new Student("Jane Roe", 100.00, 24);

        students.add(student1);
        students.add(student2);
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("students.ser")
        );
//        Student student1 = new Student();
//        Student student2 = new Student();

        out.writeObject(students);
        out.close();

        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("students.ser")
        );

        List<Student> storedStudents = (List<Student>) in.readObject();
        in.close();
//        List<Student> storedStudents2 = (List<Student>) in.readObject();

        students.forEach(x -> System.out.println(x));
        storedStudents.forEach(System.out::println); // 1 variant
        assertThat(storedStudents, contains(student1, student2));


//        students.forEach(x -> System.out.println(x)); // 2 var
//        for (Student student : students) { // 3 var
//            System.out.println(student);
//        }
//        for (int i = 0; i < students.size(); i++) { // 4 var
//            Student student = students.get(i);
//            System.out.println(student);
//        }
//        Student st = students.get(0); // 5 var для каждого отдельного элемента
//        System.out.println(st);
    }


}


/*
 class Item implements Serializable{
  String description;
  double price;
  boolean isForSale;
  String name;

  @Override
  public String toString() {
    return "Item{" +
            "description='" + description + '\'' +
            ", version=" + price +
            ", isForSale=" + isForSale +
            ", payload='" + name + '\'' +
            '}';
  }
}
*/
