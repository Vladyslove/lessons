package education;
// import student.*;
import student.Student;

public class Group {
    String name;
    Student[] students = new Student[15];
    int size = 0;

  public void addStudent(Student student) {
    students [size++] = student;
  }

  public Group (String n) {
    name = n;
  }

  public static void infoAboutGroups (Group...group) {
    // String str = null;
    for (int i = 0; i < group.length ;i++)
      System.out.println("Name of group " + (i+1) + " is: " +
       group[i].name + ". Number of students = " + group[i].size +
        "\n---------------------------------------------------------");

       System.out.println();
      // return str;
  }

  //  PART 2

  // for X arguments: namely groups, but theris doubling of last argument
  // public static String infoAboutGroups (Group...group) {
  //   String str = null;
  //   for (int i= 0; i < group.length ;i++) {
  //   str  = "Name of group " + (i+1) + " is: " +
  //    group[i].name + ". Number of students = " + group[i].size;
  //     System.out.println(str);
  //
  //     System.out.println();
  //     }
  //   // System.out.println(str);
  //     return str;
  // }

  // for 2 arguments: namely groups
  // public static String infoAboutGroups2(Group group, Group group2) {
  //   String str;
  //   str = "Name of group is: " + group.name
  //   + ". Number of studentss = " + group.size
  //   + "\nName of group2 is: " + group2.name
  //   + ". Number of studentss = " + group2.size;
  //   // System.out.println(str);
  //   return str;
  // }

  // for 1 argument:namely groups
  // public static String infoAboutGroups(Group group) {
  //   String str;
  //   str = "Name of group is: " + group.name
  //   + ". Number of studentss = " + group.size;
  //   // System.out.println(str);
  //   return str;
  // }
} // Group
