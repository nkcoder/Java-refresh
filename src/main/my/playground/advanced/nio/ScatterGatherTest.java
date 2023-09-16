package my.playground.advanced.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Set;

public class ScatterGatherTest {

  public static void main(String[] args) {
    scatter();
    gather();
  }

  /**
   * A scattering read reads data from a single channel into multiple buffers.
   * Scattering reads fill up one buffer before moving on to the next, so it's more suited for fixed
   * buffers, not dynamically sized buffers.
   */
  private static void scatter() {
    try (RandomAccessFile raf = new RandomAccessFile("data/source.txt", "rw")) {
      FileChannel channel = raf.getChannel();

      ByteBuffer firstBuffer = ByteBuffer.allocate(32);
      ByteBuffer secondBuffer = ByteBuffer.allocate(64);

      ByteBuffer[] byteBuffers = {firstBuffer, secondBuffer};
      long bytesRead = channel.read(byteBuffers);
      System.out.println("bytes written: " + bytesRead);
    } catch (IOException exception) {
      System.out.println("Exception: " + exception.getMessage());
    }
  }

  /**
   * A gathering write writes data from multiple buffers into a single channel
   */
  private static void gather() {
    String path = Paths.get("").toAbsolutePath() + "/data/dest.txt";
    System.out.println("path: " + path);
    try (FileChannel fileChannel = FileChannel.open(Paths.get(path), Set.of(
        StandardOpenOption.READ, StandardOpenOption.WRITE))) {
      ByteBuffer firstBuffer = ByteBuffer.allocate(32);
      firstBuffer.put("hello 2023!".getBytes());
      firstBuffer.flip();

      ByteBuffer secondBuffer = ByteBuffer.allocate(64);
      secondBuffer.put("Today is a very nice day".getBytes());
      secondBuffer.flip();

      ByteBuffer[] byteBuffers = {firstBuffer, secondBuffer};

      long bytesRead = fileChannel.write(byteBuffers);
      System.out.println("bytes read: " + bytesRead);

    } catch (IOException exception) {
      System.out.println("Exception: " + exception.getMessage());
    }

  }

}
