import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.InputStream;
import java.io.Reader;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StreamTest {
  private  String text = "ololo ya voditel nlo"+
          "ololo ya voditel nlo"+"ololo ya voditel nlo НЛО";
  
  @Test

  public void test_arrayInputStream() throws Exception {


    InputStream inputStream = new ByteArrayInputStream (text.getBytes ());
    int data1 = inputStream.read ();
    int data2 = inputStream.read ();
    int data3 = inputStream.read ();
    int data4 = inputStream.read ();

    System.out.println (Character.getName (data1));
    System.out.println (Character.getName (data2));
    System.out.println (Character.getName (data3));
    System.out.println (Character.getName (data4));

    int data;
    int charsCount = 4 - 1; // because we called read four times already
    do {
      data = inputStream.read ();
      System.out.print((char)data);
      charsCount++;
    } while (data != -1);

    inputStream.close ();

    assertThat(charsCount, is(text.length () + "НЛО".length ()));
  }

  @Test
  public void test_withReader() throws Exception {
    Reader reader = new CharArrayReader (text.toCharArray ());

    int data;
    int charsCount = 0 - 1;
    do {
      data = reader.read ();
      System.out.print ((char)data);
      charsCount++;
    } while (data != -1);

    reader.close ();

    assertThat(charsCount, is(text.length ()));
  }
}
