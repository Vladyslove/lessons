// package name;
// package lll;
import education.*;
// import education.Group;
// import education.School;
import student.Student;

public class Main {
  public static void main(String[] args) {
    System.out.println("Lesson7");

    // JelementaryGroup group1 = new JelementaryGroup();

    School school = new School("Hillel");
    Group group11 = new Group("Jelementary");
    Group group22 = new Group("Jelementary2");
    Group group33 = new Group("Jelementary3");

    Student student = new Student("Joh");
    Student student2 = new Student("Jane");
    Student student3 = new Student("Jan");
    Student student4 = new Student("Jafsdn");
    Student student5 = new Student("Janasdf");

    group11.addStudent(student);
    group11.addStudent(student2);
    group11.addStudent(student4);
    group11.addStudent(student5);
    group22.addStudent(student3);
    school.addGroup(group11);
    school.addGroup(group22);
    school.addGroup(group33);

    System.out.println(School.infoAboutSchool(school));
    Group.infoAboutGroups(group11, group22, group33);

    // PART 2
    // System.out.println(Group.infoAboutGroups(group11));
    // System.out.println(Group.infoAboutGroups(group11, group22, group33));

    // System.out.println(Group.infoAboutGroups2(group11, group22));
    // System.out.println(Student.infoAboutStudents(student3));
     // объект передается
    // как строка через метод toString
    // as in previous homework (5_6)

  }
}




// classStudent {
//   String name;
//   String phone = "emergency: 103; home :102";
//   // String emer = "102";
// }
