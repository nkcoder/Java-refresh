package my.playground.advanced.concurrency;

import java.util.concurrent.TimeUnit;

public class ThreadByExtend extends Thread {

  private final MathUtil mathUtil;

  public ThreadByExtend(MathUtil mathUtil) {
    this.mathUtil = mathUtil;
  }

  @Override
  public void run() {
    System.out.println("ThreadByExtend is running.");
    mathUtil.getMultiples(2);
  }
}
