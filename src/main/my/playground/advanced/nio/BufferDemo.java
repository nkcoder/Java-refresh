package my.playground.advanced.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO: enables you to do non-blocking IO. For instance, a thread can ask a channel to read data
 * into a buffer. While the channel reads data into the buffer, the thread can do something else.
 * Once data is read into the buffer, the thread can then continue processing it. The same is true
 * for writing data to channels.
 * <p/>
 *
 * Channels: connections to entities capable of performing I/O operations.<br>
 * Channel types: FileChannel, DatagramChannel, SocketChannel, ServerSocketChannel.
 * <p/>
 *
 * Buffers: container for data, data is read from channels into buffer (write buffer), and written
 * from buffers into channels (read buffer). <br>
 *
 * Buffer types: ByteBuffer, CharBuffer, DoubleBuffer, FloatBuffer, IntBuffer, LongBuffer,
 * ShortBuffer. <br>
 *
 * <pre>
 * Basic Buffer usage:
 * 1. write data into the Buffer (the data can be from file or from channel)
 * 2. call `buffer.flip()` (switch the buffer between reading mode and writing mode)
 * 3. read data out of the buffer
 * 4. call `buffer.clear()` or `buffer.compact()` (make it rady for writing again)
 * </pre>
 *
 * <pre>
 * When you have read all the data, you need to clear the buffer to make it ready for writing again:
 * 1. `clear()`: clears the whole buffer
 * 2. `compact()`: only clears the data you have read, any unread data is moved into the beginning of the buffer, and new data will be written into the buffer after the unread data
 * </pre>
 *
 * <pre>
 *   A Buffer has three properties:
 *   1. capacity: the certain fixed size of the memory block, you can only write `capacity` bytes/chars/longs etc. into the buffer. Once the buffer is full, you need to empty it (read the data or clear it) before you can write more data into it.
 *   2. position: points into the next cell in the buffer to insert data into; max is `capacity - 1`
 *   3. limit: in write mode, it's equal to capacity meaning how much data you can write; when you flip to read mode, limit is equal to the position meaning how much data you can read (you can only
 * </pre>
 *
 * <pre>
 *   Buffer methods:
 *   1. rewind(): sets the position back to 0, so you can reread all the data in the buffer, `limit` remains the same.
 *   2. flip(): switches the buffer from writing mode to reading mode
 *   3. mark() and reset(): you can mark a given position in a buffer, later reset the position back to the marked position
 * </pre>
 *
 *
 * <p/>
 *
 * Selector: a select allows a single thread to handle multiple Channels.
 * <p/>
 *
 * Ref: <a href="https://jenkov.com/tutorials/java-nio/buffers.html">Java NIO<a/>
 */
public class BufferDemo {

  public static void main(String[] args) {
    readFromFile();
    writeToFile();
    bufferReadAndWrite();
  }

  private static void bufferReadAndWrite() {
    try (RandomAccessFile raf = new RandomAccessFile("data/source.txt", "rw")) {
      FileChannel inChannel = raf.getChannel();
      ByteBuffer buffer = ByteBuffer.allocate(256);
      // read from channel into buffer (write operation)
      int bytesRead = inChannel.read(buffer);
      while (bytesRead != -1) {
        buffer.flip();    // flip: make buffer ready for read
        while (buffer.hasRemaining()) {
          // read data from buffer
          System.out.println("char: " + (char) buffer.get());
        }
        // clear the buffer, make buffer ready for writing
        buffer.clear();
        // read from channel into buffer again (write operation)
        bytesRead = inChannel.read(buffer);
      }

    } catch (IOException exception) {
      System.out.println("Exception: " + exception.getMessage());
    }
  }

  private static void readFromFile() {
    try (FileInputStream fis = new FileInputStream("data/source.txt")) {
      FileChannel inChannel = fis.getChannel();
      ByteBuffer buffer = ByteBuffer.allocate(1024);
      int byteRead = inChannel.read(buffer);
      System.out.println("File data has been read successfully, total bytes: " + byteRead);
    } catch (IOException exception) {
      System.out.println("Exception: " + exception.getMessage());
    }
  }

  private static void writeToFile() {
    try (FileOutputStream fos = new FileOutputStream("data/dest.txt")) {
      FileChannel outChannel = fos.getChannel();
      ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
      // writes data into the buffer, exception will throw if the buffer overflow or readonly
      writeBuffer.put("Hi 2023!".getBytes());
      // flip, make the buffer read for read
      writeBuffer.flip();
      // read data from the buffer into the channel
      int bytesWrite = outChannel.write(writeBuffer);
      System.out.println("Write data to file successfully, total bytes: " + bytesWrite);
    } catch (IOException exception) {
      System.out.println("Exception: " + exception.getMessage());
    }
  }

}
