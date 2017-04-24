public class Main {
  public static void main(String[] args) {
    System.out.println("Lesson5");

    Main main = new Main();

    Student student = new Student ();
    System.out.println(student.name);
    System.out.println(student.age);

    // student.foo(student);

    Student student2 = new Student ("John", 18);
    System.out.println(student2.name);
    System.out.println(student2.age);

    Student student3 = new Student ("Vlad");
    System.out.println(student3.name);
    System.out.println(student3.age);

    // student3.bar();
    // student3.bar();
    // student3.bar();
    // student3.bar();

    int a = 10;
    int b = 20;

    main.swap (a,b);

    System.out.println(a);
    System.out.println(b);

  }

    void swap (int a, int b) {
    int t = a;
    a = b;
    b = t;
  }
}

class TwoIntHolder {
  int a;
  int b;
  }

class Student {
  String name;
  int age;

  Student () { // Constructor
    this ("NONE", -1);
  }

  Student (String n) { // Constructor
    this (n, 25);
  }

  Student (String name, int age) { // Constructor
    this.name = name;
    this.age = age; // использовать, чтобы имена
                    // параметров указывать как имена полей
    this.foo();
    foo();
  }

  void foo() {}
  void bar() {}
  void bar(int i) {}
  void bar(int i, int b) {}
  void bar(double i, int b) {}


}
