package my.playground.advanced.concurrency;

public class ThreadDemo {
  public static void main(String[] args) {
    MathUtil mathUtil = new MathUtil();
    Thread t1 = new ThreadByExtend(mathUtil);
    t1.start();

    Thread t2 = new Thread(new ThreadByImplement(mathUtil));
    t2.start();
  }
}
