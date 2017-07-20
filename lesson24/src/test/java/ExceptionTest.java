import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ExceptionTest {
  @Test
  public void name() throws Exception {
    baz ();
  }

  private void baz() throws Exception {
    try {
      bar ();
    } catch (SuperDuperException | IOException e) { // for not writing twice
      e.printStackTrace ();
//      throw new SuperDuperException (e);
    }
  }


  class SuperDuperException extends Exception {

    SuperDuperException(Exception e) {
      super(e);
    }

    public SuperDuperException(String message) {
      super(message);
    }
  }

  private void bar() throws Exception {
    foo ();
  }

  private void foo() throws Exception {
    throw new Exception();
  }

  @Test
  public void name2() throws Exception {
    printWords (new String[] {"Hi", "Buddy"});
  }

  private void printWords(String[] words) {

    for (int i = 0; i < words.length; i++) {
//        System.out.println (words[i]);
      /*try {
        printer.print(words[i]);
      } catch (TooMuchSybmolsException e) {
        log("Writting attempt" + words[i] +
                "was unsuccessful [" +
                e.getMessage() + "]");
        throw new CannotPrintException();
      } */
      if (canReturnNull() != null) {
        // do canReturnNull
      }
    }
  }

  private Object canReturnNull() {
    return null;
  }

  @Test
  public void test3() throws Exception {
    try {
      zzz ();
    } catch (SuperDuperException e) {
      System.out.println ("It's okay. I'm fixing it from catch");
    } finally {
      System.out.println ("Hello from finally");
    }
  }

  public void zzz() throws SuperDuperException {
    throw new SuperDuperException ("ololo from zzz");
  }

  @Test
  public void testFinallyAndReturn() throws Exception {
    assertThat(returnWhenFinally(), is(-1));
  }

  public int returnWhenFinally() {
    try {
      zzz ();
    } catch (SuperDuperException e) {
      return -1;
    } finally {
      return 0;
    }
  }
}
