package student;

public class Student {
  String name;

  public Student (String n) {
    name = n;
  }
  public static String infoAboutStudents(Student student) {
    String str;
    str = "Name of Student of group22 is: " + student.name;
    // System.out.println(str);
    return str;
  }
}
