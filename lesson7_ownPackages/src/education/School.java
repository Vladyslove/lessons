package education;
public class School {
  String name;
  Group[] groups = new Group[5];
  int size = 0;

public void addGroup(Group group) {
  groups [size++] = group;
}
public School (String n) {
  name = n;
}
public static String infoAboutSchool(School school) {
  String str;
  str = "Name of school is: " + school.name + ". Number of groups = " + school.size;
  // System.out.println(str);
  return str;
}
}
