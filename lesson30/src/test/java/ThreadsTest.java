import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.*;

public class ThreadsTest {

    @Test
    public void startThread() throws Exception {
        Thread thread1 = new Worker();
        Thread thread2 = new Worker();
        Thread thread3 = new Worker();

        thread1.start();
        thread2.start();
        thread3.start();


//        thread1.join();
//        thread2.join();
//        thread3.join();
        System.out.println(Thread.currentThread().getName());
    }

    class Worker extends Thread {
        @Override
        public void run() {
            System.out.println(getName());
        }
    }

    @Test
    public void startThreadRunnable() throws Exception {

        Runnable runnable0 = /*new Runnable*/() -> {
            /*@Override
            public void run() {

            }*/
        };
                             /* new only -> */
        Runnable runnableWithLambda = () -> { };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
            }
        };

     Thread thread1 = new Thread(runnable);
     Thread thread2 = new Thread(runnable);
     Thread thread3 = new Thread(runnable);

        /*synchronized (this) {
            System.out.println(Thread.currentThread().getName());
            System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
        }*/

     thread1.start();
     thread2.start();
     thread3.start();

     thread1.join();
     thread2.join();
     thread3.join();
    }

    @Test
    public void executorServic() throws Exception {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
//            System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
        };
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.submit(runnable);

        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void executorService_withCallable() throws Exception {
        Callable<Integer> callable = () -> {
            TimeUnit.SECONDS.sleep(5);
            return 10;
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor( );
        Future<Integer> result = executorService.submit(callable);

            System.out.println(result.get());
    }
}
