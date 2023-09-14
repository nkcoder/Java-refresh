package my.playground.advanced.concurrency;

public class MathUtil {
  // use synchronized on the method
  public synchronized void getMultiples(int n) {
    for (int i = 1; i <= 5; i++) {
      System.out.printf("Thread: %s, value: %d\n", Thread.currentThread().getName(), n * i);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        System.out.println("Exception: " + e.getMessage());
      }
    }
  }

  public void getMultiples2(int n) {
    // use synchronized for the block
    synchronized (this) {
      for (int i = 1; i <= 5; i++) {
        System.out.printf("Thread: %s, value: %d\n", Thread.currentThread().getName(), n * i);
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          System.out.println("Exception: " + e.getMessage());
        }
      }
    }

  }
}
