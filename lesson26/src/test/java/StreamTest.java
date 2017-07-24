import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import static junit.framework.TestCase.fail;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StreamTest {
  private String text = "ololo ya voditel НЛО";

  @Test
//  @Test (expected = )
//  @Test (timeout = )

  public void test_arrayInputStream() throws Exception {


    InputStream inputStream = new ByteArrayInputStream (text.getBytes ());
    //int data1 = inputStream.read (); // is read 1 byte
    //System.out.println (Character.getName (data1)); // and print

    int data;
    int charsCount = -1; // because loop do-while will be executed 1 more time bigger
    do {
      data = inputStream.read ();
      System.out.print ((char) data);
      charsCount++;
    } while (data != -1);

    inputStream.close ();

    assertThat (charsCount, is (text.length () + "НЛО".length ()));
  }

  @Test
  public void test_withReader() throws Exception {
    Reader reader = new CharArrayReader (text.toCharArray ());

    int data;
    int charsCount = 0 - 1;
    do {
      data = reader.read ();
      System.out.print ((char) data);
      charsCount++;
    } while (data != -1);

    reader.close ();

    assertThat (charsCount, is (text.length ()));
  }

  @Test
  public void test_readFromFileAndWriteToAnother() throws Exception {
    InputStream inputStream = new FileInputStream ("3lpigs.txt");
    byte[] data = new byte[1024];
    int readBytes = inputStream.read (data);

//    OutputStream outputStream = new FileOutputStream ("out.txt", true);
    OutputStream outputStream = new FileOutputStream ("out.txt");

    outputStream.write (data);
  }

  @Test
  public void test_readFromFileAndWriteToAnother_usingReaderWriter() throws Exception {
    Reader reader = new FileReader ("3lpigs.txt");
    char[] data = new char[1024];
    reader.read (data);
//    reader.close ();
//    reader.read ();

    Writer writer = new FileWriter ("out2.txt");
    writer.write (data);

//    writer.flush (); // not mandatory, close() is ENOUGH
    reader.close ();
    writer.close (); // Closer the stream, flushing it first.
  }

  @Test
  public void decoratorExample() throws Exception {
//    InputStream inputStream = new FileInputStream ("cybersla.txt");

    InputStream inputStream = new BufferedInputStream (
            new FileInputStream ("cybersla.txt")
    );
    byte[] data = new byte[415872];
    int readBytes = inputStream.read (data);

    assertThat (readBytes, is (415872));
  }

  @Test
  public void setPtintStream() throws Exception {
    OutputStream outputStream = new FileOutputStream ("sout.txt");

    System.out.println ("hello, worm");
    System.setOut (new PrintStream (outputStream));

    System.out.println ("hello");
    System.out.println ("worm");
  }

  @Test
  public void name() throws Exception {
    Scanner scanner = new Scanner (System.in);

    scanner.nextInt ();
  }

  @Test
  public void test_inputFromCommandLineInsteadConsole() throws Exception {
    String[] args = "java --name value".split (" ");
    String[] args1 = "java --name=value".split ("=");

    System.out.println (Arrays.toString (args));
    System.out.println (Arrays.toString (args1));
  }

  @Test(expected = FileNotFoundException.class)
  public void testExceptionalSituation() throws Exception {
//    new FileInputStream ("out.txt"); test failed because of absence of Exception because file "out.txt" is exists
    new FileInputStream ("out-out.txt");
  }

  @Test
  public void testExceptionalSituation_closingTheStreams() {

    Reader reader = null;
    char[] data = new char[1024];
    Writer writer = null;

    try {
      reader = new FileReader ("3lpigs.txt");
      reader.read (data);

      writer = new FileWriter ("out2.txt");
      writer.write (data);

    } catch (IOException e) {
      // handle IOException
    } finally {
      try {
        if (reader != null) {
          reader.close ();
        }
        if (writer != null) {
          writer.close ();
        }

      } catch (IOException e) {
        //e.printStackTrace ();
      }
    }
  }

  @Test
  public void testExceptionalSituation_closingTheStreams_tryWithResources() {

    try (Reader reader = new FileReader ("3lpigs.txt");
        Writer writer = new FileWriter ("out2.txt")
    ) {
      char[] data = new char[1024];

      reader.read (data);
      writer.write (data);
    } catch (IOException e) {
      // handle IOException

    }
  }
}
