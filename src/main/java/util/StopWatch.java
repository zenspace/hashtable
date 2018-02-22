package util;

public class StopWatch {
  private long startTime;
  private long endTime;
  private String prefix;

  public StopWatch(String prefix) {
    this.prefix = prefix;
    start();
  }

  public void start() {
    this.startTime = System.nanoTime();
    this.endTime = 0;
  }

  public void stop() {
    this.endTime = System.nanoTime();
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public void Print() {

    StringBuffer buffer = new StringBuffer();

    buffer.append((this.endTime - this.startTime) / 1000000.0);
    buffer.append("(ms)");
    System.out.print(prefix + ": ");
    System.out.println(buffer.toString());
  }

  public String toString() {
    StringBuffer buffer = new StringBuffer();


    buffer.append((this.endTime - this.startTime) / 1000000.0);
    buffer.append("(ms)");
    System.out.print(prefix + ": ");
    System.out.println(buffer.toString());
    return buffer.toString();
  }
}
