package my.playground.advanced.concurrency;

public class ThreadByImplement implements Runnable {

  private final MathUtil mathUtil;

  public ThreadByImplement(MathUtil mathUtil) {
    this.mathUtil = mathUtil;
  }

  @Override
  public void run() {
    System.out.println("ThreadByImplement is running.");
    mathUtil.getMultiples(3);
  }
}
