// package name;
// package lll;
import  school.JelementaryGroup;

public class Main {
  public static void main(String[] args) {
    System.out.println("Lesson7");

    JelementaryGroup group1 = new JelementaryGroup();

    School school = new School("Hillel");
    Group group = new Group("Jelementary");

    Student student = new Student("Joh");
    Student student2 = new Student("Jane");

    group.addStudent(student1);
    group.addStudent(student2);
    school.addGroup(group);

    System.out.println(school); // объект передается как строка через метод toString
    // as in previous homework (5_6)

  }
}




// classStudent {
//   String name;
//   String phone = "emergency: 103; home :102";
//   // String emer = "102";
// }
