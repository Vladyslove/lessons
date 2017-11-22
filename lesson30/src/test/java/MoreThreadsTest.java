import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MoreThreadsTest  {
    public static class IntWrapper {
        private int i = 0;

        public int get() {
            return i;
        }

        public void incrementOn(int i) {
            this.i = this.i + i;
        }
    }

    @Test
    public void intWrapperCalculationInOneThread() throws Exception {
        IntWrapper intWrapper = new IntWrapper();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    intWrapper.incrementOn(1000);
                }
            }
        };

        Thread th = new Thread(task);

        th.start();
        th.join();

        assertThat(intWrapper.get(), is(1000 * 1000));
    }
    @Test
    public void intWrapperCalculationInMoreThreads() throws Exception {
        IntWrapper intWrapper = new IntWrapper();
        Object lock = new Object();

        Runnable task = new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 1000; i++) {
                    synchronized (lock) {
                        intWrapper.incrementOn(1);
                    }
                }
            }
        };

        Thread[] threads = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }
        for (int i = 0; i < 1000; i++) {
            threads[i].join();
        }
        assertThat(intWrapper.get(), is(1000 * 1000));
    }
}

class Singleton {
    private static Singleton instance;

    private Singleton() { }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
