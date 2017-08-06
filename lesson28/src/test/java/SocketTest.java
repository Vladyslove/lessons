import jdk.nashorn.internal.objects.annotations.Where;
import org.junit.Test;
import sun.util.calendar.BaseCalendar;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by vladyslav on 03.08.17.
 */
public class SocketTest {
  @Test
  public void server() throws Exception {
    ServerSocket serverSocket  = new ServerSocket (1313);
    System.out.println (serverSocket.getInetAddress ());
    Socket connection = serverSocket.accept ();

    System.out.println(connection.getInetAddress ());

    OutputStream out = connection.getOutputStream ();
    Writer write = new OutputStreamWriter (out);
    
    write.write (LocalDate.now ().toString ());
    write.write ("\n" /*+ connection.getPort ()*/);
    write.close ();
  }

  @Test
  public void client() throws Exception {
    Socket socket = new Socket ("10.0.2.15", 1313);
    InputStream in = socket.getInputStream();

    OutputStream out = socket.getOutputStream ();
    Writer write = new OutputStreamWriter (out);

    write.write ("\n");
    write.flush ();

    InputStreamReader reader = new InputStreamReader (in);
    int ch;
    while ((ch = reader.read()) != -1) {
      System.out.print ((char) ch);
    }
    socket.close ();
  }

  @Test
  public void client2() throws Exception {
    Socket socket = new Socket ("time-c.nist.gov", 13);
    InputStream in = socket.getInputStream();

    OutputStream out = socket.getOutputStream ();
    Writer write = new OutputStreamWriter (out);

    write.write ("\n");
    write.flush ();

    InputStreamReader reader = new InputStreamReader (in);
    int ch;
    while ((ch = reader.read()) != -1) {
      System.out.print ((char) ch);
    }
    socket.close ();
  }

  @Test(timeout = 10000)
  public void coolTimeServer() {
    try (ServerSocket serverSocket = new ServerSocket (1313)) {
      while (true) {
        Socket connection = serverSocket.accept ();
        System.out.println (connection.getInetAddress ());

        OutputStream out = connection.getOutputStream ();
        Writer write = new OutputStreamWriter (out);
        write.write (LocalDate.now ().toString ());
        write.write ("\n" /*+ connection.getPort ()*/);
        write.close ();
      }
    } catch (IOException e) {
      e.printStackTrace ();
    }

  }

  @Test(timeout = 60000)
  public void coolTimeServer2() {
    try (ServerSocket serverSocket = new ServerSocket (1313)) {
      while (true) {
        try(Socket connection = serverSocket.accept ()) {
          System.out.println (connection.getInetAddress ());

          OutputStream out = connection.getOutputStream ();
          Writer writer = new OutputStreamWriter (out);

          writer.write ("Welcome " + connection.getInetAddress ());
          writer.write ("\n");
          writer.flush ();

          InputStream in = connection.getInputStream ();
          BufferedReader reader = new BufferedReader (new InputStreamReader (in));

          String command;
        while ((command = reader.readLine ()) != null) {
          if (command.equalsIgnoreCase ("TIME")) {
            writer.write (LocalTime.now ().toString ());
          } else if (command.equalsIgnoreCase ("DATE")) {
            writer.write (LocalDate.now ().toString ());
          } else if (command.equalsIgnoreCase ("DATETIME")) {
            writer.write (LocalDateTime.now ().toString ());
          } else if (command.equalsIgnoreCase ("quit")) {
            writer.write ("bye");
            writer.flush ();
            break;
          } else  {
            writer.write ("unknown operation");
          }
          writer.write ("\n");
          writer.flush ();
        }

          writer.write ("\n");
          writer.close ();
        }
      }
    } catch (IOException e) {
      e.printStackTrace ();
    }

  }
}