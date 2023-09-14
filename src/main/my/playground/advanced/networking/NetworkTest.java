package my.playground.advanced.networking;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Arrays;

public class NetworkTest {

  public static void main(String[] args) {
    try {
      String url = "www.google.com";
      InetAddress inetAddress = InetAddress.getByName(url);

      String hostAddress = inetAddress.getHostAddress();
      String address = Arrays.toString(inetAddress.getAddress());
      var hostname = inetAddress.getHostName();
      boolean loopbackAddress = inetAddress.isLoopbackAddress();
      boolean anyLocalAddress = inetAddress.isAnyLocalAddress();
      boolean reachable = inetAddress.isReachable(200);

      System.out.printf("hostAddress = %s, address = %s, hostname = %s\n", hostAddress, address,
          hostname);
      System.out.printf("loopbackAddress = %s, anyLocalAddress = %s, reachable = %s\n",
          loopbackAddress, anyLocalAddress, reachable);
    } catch (IOException exception) {
      System.out.println("Exception: " + exception);
    }
  }

}
