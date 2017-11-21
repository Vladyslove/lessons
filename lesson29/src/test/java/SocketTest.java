import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class SocketTest {

    @Test(timeout = 30_000)
    public void testSimpleService() throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(1313)) { // serverSocket is created.
            while (true) {
                try (Socket connection = serverSocket.accept()) { // We launch sever to wait
                    System.out.println(connection.getInetAddress());
                    System.out.println(connection.getPort());

                    OutputStream out = connection.getOutputStream();
                    Writer writer = new OutputStreamWriter(out);

                    writer.write("Hello-" + new Random().nextInt() + "\n");
                    writer.flush();

                    TimeUnit.SECONDS.sleep(5);
                    /*Thread.sleep(5 * 1000);*/

                    writer.write(" enough ... ");
                    writer.flush();
                }
            }
        }
    }

/*    @Test(timeout = 50_000)
    public void testAdvancedService0() throws Exception {
        class Worker extends Thread {

            private Socket connection;

            public Worker(Socket connection) {
                this.connection = connection;
                System.out.println(connection.isClosed()); // false
            }
            @Override
            public void run() {
                System.out.println(connection.isClosed()); // was true, when in line 77 in loop while
                //  try was with resources //try (Socket connection = serverSocket.accept())
                try (
                        OutputStream out = connection.getOutputStream();
                        Writer writer = new OutputStreamWriter(out)) {

//                    System.out.println(connection);
                    writer.write("Hello-" + new Random().nextInt() + "\n");
                    writer.flush();

                    *//*Thread.sleep(5 * 1000);*//*
                    TimeUnit.SECONDS.sleep(10);

                    writer.write(" enough ...\n");
                    writer.flush();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
//        new Worker().start(); // we launch Thread
        try (ServerSocket serverSocket = new ServerSocket(1313)) { // serverSocket is created.
            while(true) {
                try { // We launch sever to wait
                    Socket connection = serverSocket.accept();
                    new Worker(connection).start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

    @Test(timeout = 40_000)
    public void testAdvancedService() throws Exception {
        class Worker extends Thread {

            private Socket connection;

            public Worker(Socket connection) {
                this.connection = connection;
                System.out.println(connection.isClosed()); // false
            }

            @Override
            public void run() {
                System.out.println(connection.isClosed()); // was true, when in line 77 in loop while
                //  try was with resources //try (Socket connection = serverSocket.accept())
                try (
                    OutputStream out = connection.getOutputStream();
                    Writer writer = new OutputStreamWriter(out)) {

                    System.out.println(connection);
                    writer.write("Hello-" + new Random().nextInt() + "\n");
                    writer.flush();

//                    Thread.sleep(5 * 1000);
                    TimeUnit.SECONDS.sleep(10);

                    writer.write(" enough ...\n");
                    writer.close();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
//        new Worker().start(); // we launch Thread

        try (ServerSocket serverSocket = new ServerSocket(1313)) { // serverSocket is created.
            while(true) {
                try { // We launch sever to wait
                    Socket connection = serverSocket.accept();
                    System.out.println(connection);

                    new Worker(connection).start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
}

    @Test // for connecting with server - instead of telnet(which works on Ubuntu)
    public void client() throws Exception {
        Socket socket = new Socket ("localhost", 1313);
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
}
