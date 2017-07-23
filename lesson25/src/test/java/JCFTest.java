import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.stringContainsInOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JCFTest {

  @After
  public void tearDown() throws Exception {
    /*File file = new File("helloJava.txt");
    if (file.exists ()) {
      file.delete ();
    }*/
  }

  @Test
  public void test_notExists() throws Exception {
    File file = new File ("helloJava.txt");

    assertThat(file.exists (), is(false));
  }

  @Test
  public void test_fileExists() throws Exception {
    File file = new File (".gitignore");

    assertThat(file.exists (), is(true));
  }

  @Test
  public void test_fileCreated() throws Exception {
    File file = new File ("helloJava.txt");
    file.createNewFile();
    file.deleteOnExit ();

    assertThat(file.exists (), is(true));
  }

  @Test
  public void test_createdNiewFile() throws Exception {
    File file = new File ("newFile.txt");

    long modified = file.lastModified ();

    file.createNewFile ();
    file.createNewFile ();

    file.deleteOnExit ();

    assertThat(file.exists (), is(true));
    assertThat(file.lastModified (), is(not(true)));
  }

  @Ignore // because it's wrong case
  @Test
  public void test_absolutPath_wrongCase() throws Exception {
    File file = new File (".gitignore");

    assertThat (file.getAbsolutePath (),
            is("/home/vladyslav/lessons/lesson25/.gitignore"));
  }

  @Ignore // wrong case - it will fail on Win
  @Test
  public void test_separatorPath() throws Exception {
    assertThat (File.separatorChar,is('/'));
    assertThat (File.separator,is("/"));
  }

  @Test
  public void test_folder() throws Exception {
    File file = new File("helloFolder");
    file.mkdir ();
    file.deleteOnExit ();

    assertThat (file.isDirectory (), is(true));
  }

  @Test
  public void test_folders() throws Exception {
//    File file = new File("src/main/java"); // fails on Win
    File file = new File("hello/java");
    file.mkdirs ();

    file.getParentFile ().deleteOnExit();
    file.deleteOnExit ();
    assertThat (file.isDirectory (), is(true));
  }

  @Test
  public void test_deletionRecursively() throws Exception {
    StringBuilder sb = new StringBuilder ();
    for (int i = 0; i < 10; i++) {
      String s = "f" + "0" + File.separator;
      sb.append(s);
    }
    File file = new File (sb.toString());
    file.mkdirs ();

    File parentDir = new File("f0");
    deleteRecursively (parentDir);

    assertThat(parentDir.exists(), is (false));
  }

  private void deleteRecursively(File dir) {
    if (dir.isDirectory()) {
      for (File file : dir.listFiles()) {
        deleteRecursively(file);

      }
    }
//    System.out.println (dir.getName ());
    dir.delete ();
  }

  @Test
  public void test_deletionWithFilesWalker() throws Exception {
    StringBuilder sb = new StringBuilder ();
    for (int i = 0; i < 10; i++) {
      String s = "f" + "0" + File.separator;
      sb.append(s);
    }
    File file = new File (sb.toString());
    file.mkdirs ();

    File parentDir = new File("f0");
    Files.walkFileTree (Paths.get (parentDir.getAbsolutePath ()),
            new SimpleFileVisitor<Path>() {
              @Override
              public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete (file);
                return FileVisitResult.CONTINUE;
              }

              @Override
              public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete (dir);
                return FileVisitResult.CONTINUE;
              }
            }

    );

    assertThat(parentDir.exists(), is (false));

  }
}
