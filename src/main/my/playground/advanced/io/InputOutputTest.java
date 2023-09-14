package my.playground.advanced.io;

import java.io.*;

public class InputOutputTest {
  private static final String SOURCE = "source.txt";
  private static final String DEST = "dest.txt";

  public static void main(String[] args) {
    byteStreamIO();
    characterIO();
  }

  /**
   * FileInputStream: A FileInputStream obtains input bytes from a file in a file system.
   * FileInputStream is meant for reading streams of raw bytes such as image data.
   */
  private static void byteStreamIO() {
    try (FileInputStream fis = new FileInputStream(SOURCE); FileOutputStream fos = new FileOutputStream(DEST)) {
      int content;
      while ((content = fis.read()) != -1) {
        fos.write(content);
      }
    } catch (IOException exception) {
      System.out.println("Exception: " + exception.getMessage());
    }
  }

  /**
   * For reading streams of characters, consider using FileReader.
   * FileReader: Reads text from character files using a default buffer size.
   * Decoding from bytes to characters uses either a specified charset or the platform's default charset.
   */
  private static void characterIO() {
    try (FileReader reader = new FileReader(SOURCE); FileWriter writer = new FileWriter(DEST)) {
      int content;
      while ((content = reader.read()) != -1) {
        writer.write(content);
      }
    } catch (IOException exception) {
      System.out.println("Exception: " + exception.getMessage());
    }
  }
}


