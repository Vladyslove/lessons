package school;

public class JelementaryGroup {
  // Student student1 = new Student("John Doe");
  // Student student2 = new Student("John Doe");
  Student[] students = new Student[14];
  int size = 0;

  void add (Student student) {
    students [size++] = student;
  }
}


// class Student {
//   String name;
//   String phone;
// }
class Student {
  String name;
  Phone phone;
}
class Phone {
  String type;
  String number;
}
